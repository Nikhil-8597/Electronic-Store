package com.icwd.electronic.store.service.Impl;

import com.icwd.electronic.store.dto.UserDto;
import com.icwd.electronic.store.entity.User;

import com.icwd.electronic.store.exception.ResourceNotFoundException;
import com.icwd.electronic.store.service.userServiceI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.icwd.electronic.store.repository.userRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements userServiceI {
    @Autowired
    private  userRepository userRepository;
@Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        String string = UUID.randomUUID().toString();
        userDto.setUserid(string);
        User user = DtoToUser(userDto);
        User save = this.userRepository.save(user);
        UserDto userDto1 = UserToDto(save);
        return  userDto1;
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userid) {
        User user = this.userRepository.findById(userid).orElseThrow(() -> new ResourceNotFoundException());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        user.setImagename(userDto.getImagename());
        user.setGender(userDto.getGender());
        User save = this.userRepository.save(user);
        UserDto userDto1 = this.UserToDto(user);
        return userDto1;
    }

    @Override
    public void deleteUser(String userid) {
        User user = this.userRepository.findById(userid).orElseThrow(() -> new ResourceNotFoundException());
        this.userRepository.delete(user);


    }

    @Override
    public List<UserDto> getAllUser(int pageNumber,int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<User> all = this.userRepository.findAll(pageable);
        List<User> users = all.getContent();
        List<UserDto> userDtoList = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public UserDto getUserById(String userid) {
        User user = this.userRepository.findById(userid).orElseThrow(() -> new ResourceNotFoundException());
        UserDto userDto1 = this.UserToDto(user);
        return userDto1;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User byEmail = this.userRepository.findByEmail(email);
        UserDto userDto1 = this.UserToDto(byEmail);
        return userDto1;
    }

    @Override
    public List<UserDto> searchUser(String pattern) {
        List<User> byUseridContaining = this.userRepository.findByUseridContaining(pattern);
        List<UserDto> collect = byUseridContaining.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
        return collect;
    }

    public User DtoToUser (UserDto userDto){
        User user = this.modelMapper.map(userDto, User.class);
//        User user = User.builder()
//                .userid(userDto.getUserid())
//                .name(userDto.getName())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .gender(userDto.getGender())
//                .about(userDto.getAbout())
//                .imagename(userDto.getImagename())
//                .build();
        return user;
    }

    public UserDto UserToDto(User user){
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
//        UserDto userDto = UserDto.builder()
//                .userid(user.getUserid())
//                .name(user.getName())
//                .email(user.getEmail())
//                .password(user.getPassword())
//                .gender(user.getGender())
//                .about(user.getAbout())
//                .imagename(user.getImagename())
//                .build();
      return userDto;
    }

}
