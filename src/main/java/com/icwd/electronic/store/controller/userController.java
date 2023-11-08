package com.icwd.electronic.store.controller;

import com.icwd.electronic.store.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.icwd.electronic.store.service.userServiceI;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class userController {
    Logger logger = LoggerFactory.getLogger(userController.class);
    @Autowired
    private userServiceI userServiceI;
    @PostMapping("/create")
    public ResponseEntity<UserDto> createuser(@Valid @RequestBody UserDto userDto){
        UserDto user = this.userServiceI.createUser(userDto);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
    @PostMapping("/update/{userid}")
    public ResponseEntity<UserDto> updateuser(@Valid @RequestBody UserDto userDto,@PathVariable String userid){
        UserDto userDto1 = this.userServiceI.updateUser(userDto, userid);
        return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
    }
    @GetMapping("/getalluser")
    public ResponseEntity<List<UserDto>>getalluser(
            @RequestParam (value = "pageNumber" , defaultValue = "1") int pageNumber,
            @RequestParam (value = "pageSize",defaultValue = "5") int pageSize){
        List<UserDto> allUser = this.userServiceI.getAllUser(pageNumber,pageSize);
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }

    @GetMapping("/getuser/{userid}")
    public ResponseEntity<UserDto> getuser(@PathVariable String userid){
        UserDto userById = this.userServiceI.getUserById(userid);
        return new ResponseEntity<>(userById,HttpStatus.OK);
    }
    @DeleteMapping("/userdeleted/{userid}")
    public ResponseEntity<String> deleteuser(@PathVariable String userid){
        this.userServiceI.deleteUser(userid);
        return new ResponseEntity<>("User deleted sucessfully",HttpStatus.OK);
    }

    @GetMapping("/getuserbyemail/{email}")
    public ResponseEntity<UserDto> getuserbyemail(@PathVariable String email){
        UserDto userByEmail = this.userServiceI.getUserByEmail(email);
        return new ResponseEntity<>(userByEmail,HttpStatus.OK);
    }
    @GetMapping("/searchuser/{pattern}")
    public ResponseEntity<List<UserDto>> searchuser(@PathVariable String pattern){
        List<UserDto> userDtos = this.userServiceI.searchUser(pattern);
        return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }


}
