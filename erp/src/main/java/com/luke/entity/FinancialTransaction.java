package com.luke.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "ERP_FINANCIAL_TRANSACTION")
public class FinancialTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FINANCIAL_TRANSACTION_ID")
    private Long financialTransactionId;

    @Column(name = "FINANCIAL_TRANSACTION_DATE")
    private LocalDate financialTransactionDate;

    @Column(name = "FINANCIAL_TRANSACTION_TYPE")
    private String financialTransactionType;

    @Column(name = "FINANCIAL_TRANSACTION_AMOUNT")
    private String financialTransactionAmount;

    @Column(name = "RECEIPT_ID")
    private Long receiptId;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @Column(name = "FINANCIAL_TRANSACTION_DESCRIPTION")
    private String financialTransactionDescription;


}
