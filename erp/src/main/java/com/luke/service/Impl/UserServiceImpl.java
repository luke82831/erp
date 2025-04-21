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
        user.setUsername(userDto.getUserName());
        user.setPassWord(userDto.getPassWord());
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
        if (userDto.getUserName() != null && !userDto.getUserName().isEmpty()) {
            user.setUsername(userDto.getUserName());
        }
        if (userDto.getPassWord() != null && !userDto.getPassWord().isEmpty()) {
            user.setPassWord(userDto.getPassWord());
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