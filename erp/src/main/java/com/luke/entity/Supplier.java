package com.luke.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ERP_SUPPLIERS_INFO")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUPPLIER_ID")
    private int supplierId;

    @Column(name = "SUPPLIER_NAME")
    private String supplierName;

    @Column(name = "SUPPLIER_CONTACT_PERSON")
    private String supplierContactPerson;

    @Column(name = "SUPPLIER_TELEPHONE")
    private String supplierTelephone;

    @Column(name = "SUPPLIER_EMAIL")
    private String supplierEmail;

    @Column(name = "SUPPLIER_ADDRESS")
    private String supplierAddress;

    @Column(name = "SUPPLIER_BUSINESS_ID_NUMBER")
    private String supplierBusinessIdNumber;

    @Column(name = "SUPPLIER_PAYMENT_TERM")
    private String supplierPaymentTerm;

    @Column(name = "SUPPLIER_TYPE")
    private String supplierType;
}
