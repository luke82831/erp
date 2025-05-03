package com.luke.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProductDto {

    @Schema(description = "產品品牌")
    private String productBrand;

    @Schema(description = "產品名稱")
    private String productName;

    @Schema(description = "產品描述")
    private String productDescription;

    @Schema(description = "產品類別")
    private String productType;

    @Schema(description = "產品條碼")
    private String productBarcode;

    @Schema(description = "產品成本價")
    private double productCostPrice;

    @Schema(description = "產品成本價_v2")
    private double productCostPriceVer2;

    @Schema(description = "日幣價格")
    private double yen;

    @Schema(description = "上架日期")
    private LocalDateTime releaseDate;

    @Schema(description = "到貨日期")
    private LocalDate arriveDate;

    @Schema(description = "建議售價")
    private double sellingPrice;

    @Schema(description = "庫存數量")
    private String productQuantity;

    @Schema(description = "庫存單位")
    private String productUnit;

    @Schema(description = "最低庫存警告")
    private int lowStockWarning;

    @Schema(description = "供應商ID")
    private int supplierId;

}
