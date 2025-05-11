package com.luke.service;

import com.luke.dto.UserDto;
import com.luke.entity.User;

public interface UserService {
    User findById(int id);

    User createUserInfo(UserDto userDto);

    User updateUserInfo(int userId, UserDto erpUserDto);

}
