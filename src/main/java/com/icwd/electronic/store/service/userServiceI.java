package com.icwd.electronic.store.service;

import com.icwd.electronic.store.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userServiceI {

    public UserDto createUser(UserDto userDto);

    public UserDto updateUser(UserDto userDto, String userid);

    public void deleteUser(String userid);

    public List<UserDto> getAllUser (int pageNumber, int pageSize);

    public UserDto getUserById(String userid);

    public  UserDto getUserByEmail (String email);

    public List<UserDto> searchUser(String pattern);



}
