package com.luke.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InventoryTransactionDto {

    @Schema(description = "產品ID")
    private long productId;

    @Schema(name = "庫存異動日期")
    private LocalDate inventoryTransactionDate;

    @Schema(name = "異動類型")
    private String inventoryTransactionType;

    @Schema(name = "異動數量")
    private long inventoryTransactionQuantity;

    @Schema(name = "異動數量單位")
    private String inventoryTransactionUnit;

    @Schema(name = "訂單ID")
    private long OrderId;

    @Schema(name = "倉庫ID")
    private int warehouseId;
}
