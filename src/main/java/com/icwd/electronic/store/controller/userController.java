package com.icwd.electronic.store.controller;

import com.icwd.electronic.store.constants.AppConstants;
import com.icwd.electronic.store.dto.PageableResponse;
import com.icwd.electronic.store.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.icwd.electronic.store.service.userServiceI;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
@Slf4j
public class userController {

    @Autowired
    private userServiceI userServiceI;

    /**
     * @author NikhPhalke
     * @apiNote Create A User
     * @param userDto
     * @param
     * @return
     * @since 1.0v
     * */
    @PostMapping("/create")
    public ResponseEntity<UserDto> createuser(@Valid @RequestBody UserDto userDto){
      log.info("Entering The Request For Save  UserData");
        UserDto user = this.userServiceI.createUser(userDto);
        log.info("Completed The Request For Save UserData");
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    /**
     * @author NikhPhalke
     * @apiNote Update A User
     * @param userDto
     * @param userid
     * @return
     * @since 1.0v
     * */

    @PostMapping("/update/{userid}")
    public ResponseEntity<UserDto> updateuser(@Valid @RequestBody UserDto userDto,@PathVariable String userid){
        log.info("Entering The Request For Update UserData :{}", userid);
        UserDto userDto1 = this.userServiceI.updateUser(userDto, userid);
        log.info("Completed The Request For Update UserData :{}", userid);
        return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
    }

    /**
     *@author NikhPhalke
     *@apiNote Get All Users
     *@return
     *@since 1.0v
     **/

    @GetMapping("/getalluser")
    public ResponseEntity<PageableResponse<UserDto>>getalluser(
            @RequestParam (value = "pageNumber" , defaultValue = AppConstants.PAGE_NUMBER,required = false) int pageNumber,
            @RequestParam (value = "pageSize",defaultValue = AppConstants.PAGE_SIZE) int pageSize,
            @RequestParam(value="sortBy",defaultValue = AppConstants.SORT_BY,required = false)String sortBy,
            @RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR, required = false)String sortDir){
        log.info("Entering The Request For GetAllUsers");
        PageableResponse<UserDto> allUser = this.userServiceI.getAllUser(pageNumber,pageSize,sortBy,sortDir);
        log.info("Completed The Request For GetAllUsers");
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }

    /**
     * @author NikhPhalke
     * @apiNote Get A Single User
     * @param userid
     * @return
     * @since 1.0v
     * */

    @GetMapping("/getuser/{userid}")
    public ResponseEntity<UserDto> getuser(@PathVariable String userid){
        log.info("Entering The Request For Get UserData :{}", userid);
        UserDto userById = this.userServiceI.getUserById(userid);
        log.info("Completed The Request For Get UserData :{}", userid);
        return new ResponseEntity<>(userById,HttpStatus.OK);
    }

    /**
     * @author NikhPhalke
     * @apiNote Delete A User By UserId
     * @param userid
     * @return
     * @since 1.0v
     * */
    @DeleteMapping("/userdeleted/{userid}")
    public ResponseEntity<String> deleteuser(@PathVariable String userid){
        log.info("Entering The Request For Delete The UserData :{}", userid);
        this.userServiceI.deleteUser(userid);
        log.info("Completed The Request For Delete The UserData :{}", userid);
        return new ResponseEntity<>(AppConstants.DELETED_SUCCESSFULLY,HttpStatus.OK);
    }

    /**
     * @author NikhPhalke
     * @apiNote Get A Single User By Email
     * @param email
     * @return
     * @since 1.0v
     * */

    @GetMapping("/getuserbyemail/{email}")
    public ResponseEntity<UserDto> getuserbyemail(@PathVariable String email){
        log.info("Entering The Request For Get The UserData :{}", email);
        UserDto userByEmail = this.userServiceI.getUserByEmail(email);
        log.info("Completed The Request For Get The UserData :{}", email);
        return new ResponseEntity<>(userByEmail,HttpStatus.OK);
    }

    /**
     * @author NikhPhalke
     * @apiNote Search User by containing any letter
     * @param pattern
     * @return
     * @since 1.0v
     * */
    @GetMapping("/searchuser/{pattern}")
    public ResponseEntity<List<UserDto>> searchuser(@PathVariable String pattern){
        log.info("Entering The Request For Search The UserData :{}", pattern);
        List<UserDto> userDtos = this.userServiceI.searchUser(pattern);
        log.info("Completed The Request For Search The UserData :{}", pattern);
        return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }


}
