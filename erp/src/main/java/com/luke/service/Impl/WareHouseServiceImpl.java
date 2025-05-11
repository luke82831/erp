package com.luke.service.Impl;

import com.luke.dto.WarehouseDto;
import com.luke.entity.Employee;
import com.luke.entity.Warehouse;
import com.luke.repository.EmployeeRepository;
import com.luke.repository.WarehouseRepository;
import com.luke.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Warehouse createWarehouseInfo(WarehouseDto warehouseDto) {

        //先查詢是否有這個員工
        Optional<Employee> optionalEmployee = employeeRepository.findByEmployeeName(warehouseDto.getContactPerson());

        if (optionalEmployee.isEmpty()) {
            throw new IllegalArgumentException("指定的聯絡人不存在於員工資料中");
        }

        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseName(warehouseDto.getWarehouseName());
        warehouse.setWarehouseAddress(warehouseDto.getWarehouseAddress());
        warehouse.setContactPerson(warehouseDto.getContactPerson());
        return warehouseRepository.save(warehouse);
    }
}
