package com.example.covoiturage.services;

import com.example.covoiturage.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getUsers(int page, int limit);
    UserDto getUserByUserId(String userId);
    UserDto updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);
    UserDto updateUserAccount(String userId, UserDto userDto);
}
