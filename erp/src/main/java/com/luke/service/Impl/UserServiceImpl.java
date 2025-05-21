package com.luke.service.Impl;

import com.luke.dto.UserDto;
import com.luke.entity.User;
import com.luke.repository.UserRepository;
import com.luke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUserInfo(UserDto userDto) {

        LocalDateTime getNow = LocalDateTime.now();
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmployeeId(userDto.getEmployeeId());
        user.setRoleId(userDto.getRoleId());
        user.setLastLoginTime(getNow);
        user.setStatus(userDto.getStatus());
        return userRepository.save(user);
    }

    @Override
    public User updateUserInfo(int userId, UserDto userDto) {

        User user = userRepository.findById(userId).orElse(null);
        LocalDateTime getNow = LocalDateTime.now();
        if (userDto.getUsername() != null && !userDto.getUsername().isEmpty()) {
            user.setUsername(userDto.getUsername());
        }
        if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
            user.setPassword(userDto.getPassword());
        }
        if (userDto.getEmployeeId() != null) {
            user.setEmployeeId(userDto.getEmployeeId());
        }
        if (userDto.getRoleId() != null) {
            user.setRoleId(userDto.getRoleId());
        }
        if (userDto.getStatus() != null && !userDto.getStatus().isEmpty()) {
            user.setStatus(userDto.getStatus());
        }
        user.setLastLoginTime(getNow);
        return userRepository.saveAndFlush(user);
    }
}