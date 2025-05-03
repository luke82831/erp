package com.luke.service.Impl;

import com.luke.entity.Supplier;
import com.luke.repository.SupplierRepository;
import com.luke.service.SupplierService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppliersServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public int findBySupplierName(String supplierName) {
        Supplier supplier = supplierRepository.findBySupplierName(supplierName);
        if (supplier != null) {
            return supplier.getSupplierId();
        } else {
            throw new EntityNotFoundException("找不到供應商" + supplierName);
        }
    }
}
