package com.luke.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ERP_USER_INFO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID")
    private int userId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String passWord;

    @Column(name = "EMPLOYEEID")
    private int employeeId;

    @Column(name = "ROLEID")
    private int roleId;

    @Column(name = "LASTLOGINTIME")
    private LocalDateTime lastLoginTime;

    @Column(name = "STATUS")
    private String status;

}