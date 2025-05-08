package com.luke.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ERP_ROLE_PERMISSION")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private int roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;

}
