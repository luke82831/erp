package com.luke.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="USER")
@Data
public class User {
    @Id
    private int userId;
}
