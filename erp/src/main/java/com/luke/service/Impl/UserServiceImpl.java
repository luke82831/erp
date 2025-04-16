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
    UserService UserService;

    @Autowired
    UserRepository UserRepository;

    @Override
    public User findById(int id) {
        return UserRepository.findById(id).orElse(null);
    }

    @Override
    public User createUserInfo(UserDto UserDto) {

        LocalDateTime getNow = LocalDateTime.now();
        User User = new User();
        User.setUsername(UserDto.getUsername());
        User.setPassWord(UserDto.getPassWord());
        User.setEmployeeId(UserDto.getEmployeeId());
        User.setRoleId(UserDto.getRoleId());
        User.setLastLoginTime(getNow);
        User.setStatus(User.getStatus());
        return UserRepository.save(User);
    }

    @Override
    public User updateUserInfo(int userId, UserDto UserDto) {

        User User = UserRepository.findById(userId).orElse(null);
        LocalDateTime getNow = LocalDateTime.now();
        if (UserDto.getUsername() != null && !UserDto.getUsername().isEmpty()) {
            User.setUsername(UserDto.getUsername());
        }
        if (UserDto.getPassWord() != null && !UserDto.getPassWord().isEmpty()) {
            User.setPassWord(UserDto.getPassWord());
        }
        if (UserDto.getEmployeeId() != null) {
            User.setEmployeeId(UserDto.getEmployeeId());
        }
        if (UserDto.getRoleId() != null) {
            User.setRoleId(UserDto.getRoleId());
        }
        if (UserDto.getStatus() != null && !UserDto.getStatus().isEmpty()) {
            User.setStatus(UserDto.getStatus());
        }
        User.setLastLoginTime(getNow);
        return UserRepository.saveAndFlush(User);
    }
}
