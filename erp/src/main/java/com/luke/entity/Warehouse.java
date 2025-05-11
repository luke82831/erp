package com.luke.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ERP_WAREHOUSE")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WAREHOUSE_ID" )
    private int warehouseId;

    @Column(name = "WAREHOUSE_NAME" )
    private String warehouseName;

    @Column(name = "WAREHOUSE_ADDRESS" )
    private String warehouseAddress;

    @Column(name = "CONTACT_PERSON" )
    private String contactPerson;

}
