package com.luke.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "ERP_INVENTORY_TRANSACTION")
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVENTORY_TRANSACTION_ID")
    private long transactionId;

    @Column(name = "INVENTORY_PRODUCT_ID")
    private long productId;

    @Column(name = "INVENTORY_TRANSACTION_DATE")
    private LocalDate transactionDate;

    @Column(name = "INVENTORY_TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "INVENTORY_TRANSACTION_QUANTITY")
    private long transactionQuantity;

    @Column(name = "INVENTORY_TRANSACTION_UNIT")
    private String transactionUnit;

    @Column(name = "ORDER_ID")
    private long OrderId;

    @Column(name = "WAREHOUSE_ID")
    private int warehouseId;

}
