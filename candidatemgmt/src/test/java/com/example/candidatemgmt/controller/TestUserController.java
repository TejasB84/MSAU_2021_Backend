package com.example.candidatemgmt.controller;


import java.util.ArrayList;
import java.util.List;

import com.example.candidatemgmt.bean.User;
import com.example.candidatemgmt.respository.UserRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class TestUserController {
    @InjectMocks
    UserController userController;

    @MockBean
    UserRespository userRespository;

    @Autowired
    private MockMvc mockMvc;

    List<User> list;
    List<User> singleResponse;

    String baseURL = "http://localhost:8080/user";
    @BeforeEach
    public void setup() {
        list  = new ArrayList<User>();
        singleResponse = new ArrayList<User>();
        User user = new User();
        user.setId(17);
        user.setFirstname("Hrishi");
        user.setLastname("Shenai");
        user.setPhoneno("1234567890");
        user.setEmail("DH33@gmail.com");
        user.setBirthdate("1999-02-02");
        user.setCity("Aurangabad");
        user.setCountry("India");
        user.setDid(2);
        list.add(user);
        singleResponse.add(user);
        user = new User();
        user.setId(16);
        user.setEmail("Test1");
        list.add(user);
    }
    @Test
    public void testGetAllCandidates() throws Exception{
        when(userRespository.getUser()).thenReturn(list);
        this.mockMvc.perform(get(baseURL ))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }


}
