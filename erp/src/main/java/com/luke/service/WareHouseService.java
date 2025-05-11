package com.luke.service;

import com.luke.dto.WarehouseDto;
import com.luke.entity.Warehouse;

public interface WareHouseService {
    Warehouse createWarehouseInfo(WarehouseDto warehouseDto);
}
