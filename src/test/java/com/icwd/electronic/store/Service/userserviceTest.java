package com.icwd.electronic.store.Service;

import com.icwd.electronic.store.dto.UserDto;
import com.icwd.electronic.store.entity.User;
import com.icwd.electronic.store.repository.userRepository;
import com.icwd.electronic.store.service.Impl.userServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.icwd.electronic.store.service.userServiceI;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class userserviceTest {


    @Mock
    private userRepository userRepo;

    @MockBean
    userServiceI  userServiceI = new userServiceImpl(userRepo);

    @Autowired
    private ModelMapper modelMapper;

    User user;
    @BeforeEach
    public void init(){
     User user = User.builder()
                .name("nikhil")
                .about("Mechanical Engineer")
                .gender("male")
                .email("abc@outlook.com")
                .build();

    }
    @Test
    public void createUserTest(){
       Mockito.when(userRepo.save(Mockito.any())).thenReturn(user);

        UserDto user1 = userServiceI.createUser(modelMapper.map(user, UserDto.class));
        System.out.println(user1);
        Assertions.assertEquals(user1.getName(),"nikhil");
    }
    @Test
    public void updateUserTest(){
        String userId="";
        UserDto userDto = UserDto.builder()
                .name("Chotya")
                .about("I am Software Engineer")
                .email("chotya@yahoo.com")
                .build();
     Mockito.when(userRepo.findById(Mockito.anyString())).thenReturn(Optional.of(user));
     Mockito.when(userRepo.save(Mockito.any())).thenReturn(user);

        UserDto userDto1 = userServiceI.updateUser(userDto, userId);
        System.out.println(userDto1.getName().equals("chotya"));
        Assertions.assertEquals(userDto1.getName(),"chotya");
    }
     @Test
    public void deleteuser(){
        String userId="abcd";

        Mockito.when(userRepo.findById("abcd")).thenReturn(Optional.of(user));
        userServiceI.deleteUser(userId);
        Mockito.verify(userRepo,Mockito.times(1)).delete(user);


    }



}
