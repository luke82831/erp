package com.luke.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDto {

    @Schema(description = "產品ID")
    private long productId;

    @Column(name = "庫存異動日期")
    private LocalDate transactionDate;

    @Column(name = "異動類型")
    private String transactionType;

    @Column(name = "異動數量")
    private long transactionQuantity;

    @Column(name = "異動數量單位")
    private String transactionUnit;

    @Column(name = "訂單ID")
    private long OrderId;

    @Column(name = "倉庫ID")
    private int warehouseId;
}
