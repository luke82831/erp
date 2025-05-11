package com.luke.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WarehouseDto {

    @Schema(description = "倉庫名稱")
    private String warehouseName;

    @Schema(description = "倉庫地址")
    private String warehouseAddress;

    @Schema(description = "聯絡人姓名")
    private String contactPerson;

}
