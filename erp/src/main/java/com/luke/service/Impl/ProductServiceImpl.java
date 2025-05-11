package com.luke.service.Impl;

import com.luke.entity.Product;
import com.luke.service.ProductService;
import com.luke.service.SupplierService;
import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SupplierService supplierService;

    @Override
    @Transactional
    public void importExcelToDatabase(InputStream is) throws Exception {
        Workbook workbook = WorkbookFactory.create(is);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

        Sheet targetSheet = workbook.getSheet("成本表");
        if (targetSheet == null) {
            throw new RuntimeException("找不到名為『成本表』的Sheet！");
        }

        Iterator<Row> rowIterator = targetSheet.iterator();
        if (!rowIterator.hasNext()) {
            throw new RuntimeException("Excel檔案是空的！");
        }

        // 讀取表頭
        Row headerRow = rowIterator.next();
        List<String> headers = new ArrayList<>();
        for (Cell cell : headerRow) {
            headers.add(cell.getStringCellValue().trim());
        }

        List<Product> products = new ArrayList<>();

        // 讀取每一列資料
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Product product = parseRow(row, headers, evaluator);
            if (product != null) {
                products.add(product);
            }
        }

        // 批次插入DB
        batchInsert(products);
    }

    private Product parseRow(Row row, List<String> headers, FormulaEvaluator evaluator) {
        Product product = new Product();

        for (int i = 0; i < headers.size(); i++) {
            try {
            Cell cell = row.getCell(i);
            if (cell == null) continue; // 如果該欄位為空，跳過

            String header = headers.get(i).trim();
            System.out.println("處理欄位: " + header + ", 類型: " + cell.getCellType());

            switch (header) {
                case "產品品牌":
                    product.setProductBrand(getCellValue(cell));
                    break;
                case "產品名稱":
                    product.setProductName(getCellValue(cell));
                    break;
                case "備註":
                    product.setProductDescription(getCellValue(cell));
                    break;
                case "產品類型":
                    product.setProductType(getCellValue(cell));
                    break;
                case "產品條碼":
                    product.setProductBarcode(getCellValue(cell));
                    break;
                case "單顆進價":
                    product.setProductCostPrice(getDoubleCellValue(cell));
                    break;
                case "V2":
                    product.setProductCostPriceVer2(getDoubleFormulaCellValue(cell, evaluator));
                    break;
                case "日幣價格":
                    product.setYen(getDoubleCellValue(cell));
                    break;
                case "上架日期":
                    product.setReleaseDate(getDateCellValue(cell));
                    break;
                case "到貨日期":
                    product.setArriveDate(getLocalDateCellValue(cell));
                    break;
                case "建議售價":
                    product.setSellingPrice(getDoubleCellValue(cell));
                    break;
                case "庫存數量":
                    product.setProductQuantity(getCellValue(cell));
                    break;
                case "庫存單位":
                    product.setProductUnit(getCellValue(cell));
                    break;
                case "最低庫存警告":
                    product.setLowStockWarning(getIntCellValue(cell));
                    break;
                case "供應商名稱":
                    int supplierId = supplierService.findBySupplierName(getCellValue(cell));
                    product.setSupplierId(supplierId);
                    break;
            }
            } catch (Exception e) {
                System.err.println("在處理行 " + row.getRowNum() + " 的第 " + i + " 欄時出錯: " + e.getMessage());
            }
        }

        return product;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return null;
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue()).trim();
            default:
                return null;
        }
    }

    private Double getDoubleCellValue(Cell cell) {
        if (cell == null) return null;
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            default:
                return null;
        }
    }

    private Double getDoubleFormulaCellValue(Cell cell, FormulaEvaluator evaluator) {
        if (cell == null) return null;

        switch (cell.getCellType()) {
            case FORMULA:
                CellValue cellValue = evaluator.evaluate(cell);
                if (cellValue.getCellType() == CellType.NUMERIC) {
                    return cellValue.getNumberValue();
                }
                break;
            case NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }

    private Integer getIntCellValue(Cell cell) {
        if (cell == null) return null;
        switch (cell.getCellType()) {
            case NUMERIC:
                return (int) cell.getNumericCellValue();
            default:
                return null;
        }
    }

    private LocalDate getLocalDateCellValue(Cell cell) {
        if (cell == null) return null;

        if (cell.getCellType() == CellType.NUMERIC) {
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getLocalDateTimeCellValue().toLocalDate();
            } else {
                return LocalDate.ofEpochDay((long) cell.getNumericCellValue());
            }
        } else if (cell.getCellType() == CellType.STRING) {
            LocalDateTime ldt = parseDateTime(cell.getStringCellValue());
            if (ldt != null) {
                return ldt.toLocalDate();
            }
        }
        return null;
    }

    private LocalDateTime getDateCellValue(Cell cell) {
        if (cell == null) return null;

        if (cell.getCellType() == CellType.NUMERIC) {
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getLocalDateTimeCellValue();
            } else {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli((long) cell.getNumericCellValue()), ZoneOffset.UTC);
            }
        } else if (cell.getCellType() == CellType.STRING) {
            return parseDateTime(cell.getStringCellValue());
        }
        return null;
    }

    private LocalDateTime parseDateTime(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) return null;

        dateStr = dateStr.trim().replace("/", "-"); // 把 "/" 換成 "-"，比較好解析

        String[] patterns = {
                "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd HH:mm",
                "yyyy-MM-dd"  // 只有日期
        };

        for (String pattern : patterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                if (pattern.contains("HH")) {
                    return LocalDateTime.parse(dateStr, formatter);
                } else {
                    return LocalDate.parse(dateStr, formatter).atStartOfDay();
                }
            } catch (DateTimeParseException e) {
                // 這個格式不行，換下一個 pattern
            }
        }
        System.err.println("無法解析日期字串: " + dateStr);
        return null;
    }


    private void batchInsert(List<Product> products) {
        String sql = "INSERT INTO ERP_PRODUCT (PRODUCT_BRAND, PRODUCT_NAME, PRODUCT_DESCRIPTION, " +
                "PRODUCT_TYPE, PRODUCT_BARCODE, PRODUCT_COST_PRICE, PRODUCT_COST_PRICE_VER2, YEN, " +
                "RELEASE_DATE, ARRIVE_DATE, SELLING_PRICE, PRODUCT_QUANTITY, PRODUCT_UNIT, " +
                "LOW_STOCK_WARNING, SUPPLIER_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, products, 500, (ps, product) -> {
            ps.setString(1, product.getProductBrand()); // PRODUCT_BRAND
            ps.setString(2, product.getProductName()); // PRODUCT_NAME
            ps.setString(3, product.getProductDescription()); // PRODUCT_DESCRIPTION
            ps.setString(4, product.getProductType()); // PRODUCT_TYPE
            ps.setString(5, product.getProductBarcode()); // PRODUCT_BARCODE
            ps.setDouble(6, product.getProductCostPrice()); // PRODUCT_COST_PRICE
            ps.setDouble(7, product.getProductCostPriceVer2()); // PRODUCT_COST_PRICE_VER2
            ps.setDouble(8, product.getYen()); // YEN
            if (product.getReleaseDate() != null) {
                ps.setTimestamp(9, Timestamp.valueOf(product.getReleaseDate())); // RELEASE_DATE
            } else {
                ps.setNull(9, Types.TIMESTAMP);
            }
            if (product.getArriveDate() != null) {
                ps.setDate(10, Date.valueOf(product.getArriveDate())); // ARRIVE_DATE
            } else {
                ps.setNull(10, Types.DATE);
            }
            ps.setDouble(11, product.getSellingPrice()); // SELLING_PRICE
            ps.setString(12, product.getProductQuantity()); // PRODUCT_QUANTITY
            ps.setString(13, product.getProductUnit()); // PRODUCT_UNIT
            ps.setInt(14, product.getLowStockWarning()); // LOW_STOCK_WARNING
            ps.setInt(15, product.getSupplierId()); // SUPPLIER_ID
            System.out.println("匯入完成!!");
        });
    }

}