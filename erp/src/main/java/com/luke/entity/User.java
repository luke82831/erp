package com.luke.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ERP_USER")
@EqualsAndHashCode(of = "UserId")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID")
    private int UserId;

    @Column(name = "USERNAME")
    private String Username;

    @Column(name = "PASSWORD")
    private String PassWord;

    @Column(name = "EMPLOYEEID")
    private int EmployeeId;

    @Column(name = "ROLEID")
    private int RoleId;

    @Column(name = "LASTLOGINTIME")
    private LocalDateTime LastLoginTime;

    @Column(name = "STATUS")
    private String Status;

}