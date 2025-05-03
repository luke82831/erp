package com.luke.repository;

import com.luke.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>, JpaSpecificationExecutor<Supplier> {

    Supplier findBySupplierName(String supplierName);
}
