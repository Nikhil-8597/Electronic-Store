package com.icwd.electronic.store.Controller;

import com.icwd.electronic.store.controller.userController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.icwd.electronic.store.service.userServiceI;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(value = userController.class )
public class userControllerTest {
    @MockBean
    private userServiceI userServiceI;
    @Autowired
    private MockMvc mockMvc;
@Test
    public void testwelcome() throws Exception{
        when(userServiceI.getwelcome()).thenReturn("Good Luck..!!");

        MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/greet");

        MvcResult andReturn = mockMvc.perform(reqBuilder).andReturn();

        MockHttpServletResponse response = andReturn.getResponse();

        int status = response.getStatus();

        assertEquals(200, status);
    }
    }

