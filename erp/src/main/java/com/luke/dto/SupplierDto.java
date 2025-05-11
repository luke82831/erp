package com.luke.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SupplierDto {

    @Schema(description = "供應商名稱")
    private String SupplierName;

    @Schema(description = "聯絡人")
    private String SupplierContactPerson;

    @Schema(description = "聯絡電話")
    private String SupplierTelephone;

    @Schema(description = "聯絡信箱")
    private String SupplierEmail;

    @Schema(description = "聯絡地址")
    private String SupplierAddress;

    @Schema(description = "稅籍編號")
    private String SupplierBusinessIdNumber;

    @Schema(description = "付款方式")
    private String SupplierPaymentTerm;

    @Schema(description = "供應商類型")
    private String SupplierType;
}
