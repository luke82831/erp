package com.luke.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDto {

    @Schema(description = "使用者帳號")
    private String userName;

    @Schema(description = "使用者密碼")
    private String passWord;

    @Schema(description = "員工編號")
    private Integer employeeId;

    @Schema(description = "權限ID")
    private Integer roleId;

    @Schema(description = "帳號狀態")
    private String status;

}