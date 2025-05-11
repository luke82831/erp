package com.luke.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "ERP_TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private long transactionId;

    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "TRANSACTION_DATE")
    private LocalDate transactionDate;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "TRANSACTION_QUANTITY")
    private long transactionQuantity;

    @Column(name = "TRANSACTION_UNIT")
    private String transactionUnit;

    @Column(name = "ORDER_ID")
    private long OrderId;

    @Column(name = "WAREHOUSE_ID")
    private int warehouseId;

}
