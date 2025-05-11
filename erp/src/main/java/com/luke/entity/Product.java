package com.luke.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ERP_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "PRODUCT_BRAND")
    private String productBrand;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "PRODUCT_BARCODE")
    private String productBarcode;

    @Column(name = "PRODUCT_COST_PRICE")
    private double productCostPrice;

    @Column(name = "PRODUCT_COST_PRICE_VER2")
    private double productCostPriceVer2;

    @Column(name = "YEN")
    private double yen;

    @Column(name = "RELEASE_DATE")
    private LocalDateTime releaseDate;

    @Column(name = "ARRIVE_DATE")
    private LocalDate arriveDate;

    @Column(name = "SELLING_PRICE")
    private double sellingPrice;

    @Column(name = "PRODUCT_QUANTITY")
    private String productQuantity;

    @Column(name = "PRODUCT_UNIT")
    private String productUnit;

    @Column(name = "LOW_STOCK_WARNING")
    private int lowStockWarning;

    @Column(name = "SUPPLIER_ID")
    private int supplierId;
}
