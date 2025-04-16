package com.luke.controller;

import com.luke.dto.UserDto;
import com.luke.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(tags = "user", description = "使用者")
public class UserController {

    @Autowired
    private UserService UserService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/user/{id}")
    @ApiOperation("取得使用者id")
    public UserDto getUserId(@PathVariable int id){
        return modelMapper.map(UserService.findById(id), UserDto.class);
    }

    @PostMapping(value = "/user")
    @ApiOperation("新增使用者")
    public UserDto createUserInfo(@RequestBody UserDto UserDto){
        return modelMapper.map(UserService.createUserInfo(UserDto), UserDto.class);
    }

    @PutMapping(value = "/user/{id}")
    @ApiOperation("修改使用者資料")
    public UserDto updateUserInfo(@PathVariable int id, @RequestBody UserDto UserDto){
        return modelMapper.map(UserService.updateUserInfo(id,UserDto), UserDto.class);
    }
}
