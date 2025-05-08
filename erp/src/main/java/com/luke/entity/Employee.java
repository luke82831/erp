package com.luke.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "ERP_EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID" )
    private int employeeId;

    @Column(name = "EMPLOYEE_NAME" )
    private String employeeName;

    @Column(name = "DEPARTMENT" )
    private String department;

    @Column(name = "POSITION" )
    private String position;

    @Column(name = "START_DATE" )
    private LocalDate startDate;

    @Column(name = "EMPLOYEE_PHONE" )
    private String employeePhone;

    @Column(name = "EMPLOYEE_EMAIL" )
    private String employeeEmail;

    @Column(name = "EMPLOYEE_ADDRESS" )
    private String employeeAddress;

    @Column(name = "SALARY" )
    private long salary;

    @Column(name = "BANK_ACCOUNT" )
    private long bankAccount;

}
