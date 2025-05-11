package com.luke.controller;

import com.luke.dto.WarehouseDto;
import com.luke.service.WareHouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "warehouse", description = "倉庫資料表")
public class WarehouseController {

    @Autowired
    WareHouseService wareHouseService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value = "/warehouse")
    @Operation(summary = "新增倉庫")
    public WarehouseDto createWarehouseInfo(@RequestBody WarehouseDto warehouseDto) {
        return modelMapper.map(wareHouseService.createWarehouseInfo(warehouseDto), WarehouseDto.class);
    }
}
