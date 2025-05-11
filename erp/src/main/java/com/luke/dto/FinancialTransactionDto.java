package com.luke.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public class FinancialTransactionDto {

    @Schema(description = "交易日期")
    private LocalDate financialTransactionDate;

    @Schema(description = "交易類型")
    public String financialTransactionType;

    @Schema(description = "交易金額")
    private String financialTransactionAmount;

    @Schema(description = "相關單據ID")
    private Long receiptId;

    @Schema(description = "付款方式")
    private String paymentMethod;

    @Schema(description = "帳戶ID")
    private String accountId;

    @Schema(description = "交易內容")
    private String financialTransactionDescription;

}
