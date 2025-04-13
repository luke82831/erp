package com.luke.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="USERINFO")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int userId;

    private String UserName;

    private String PassWord;

    private int EmployeeId;

    private int RoleId;

    private LocalDate LastLoginTime;

    private String Status;
}
