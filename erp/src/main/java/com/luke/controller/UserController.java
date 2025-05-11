package com.luke.controller;

import com.luke.dto.UserDto;
import com.luke.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "user", description = "會員資料表")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/user/{id}")
    @Operation(summary = "取得使用者id")
    public UserDto getUserId(@PathVariable(name = "id") int id) {
        return modelMapper.map(userService.findById(id), UserDto.class);
    }

    @PostMapping(value = "/user")
    @Operation(summary = "新增使用者")
    public UserDto createUserInfo(@RequestBody UserDto UserDto) {
        return modelMapper.map(userService.createUserInfo(UserDto), UserDto.class);
    }

    @PutMapping(value = "/user/{id}")
    @Operation(summary = "修改使用者資料")
    public UserDto updateUserInfo(@PathVariable(name = "id") int id, @RequestBody UserDto UserDto) {
        return modelMapper.map(userService.updateUserInfo(id, UserDto), UserDto.class);
    }
}
