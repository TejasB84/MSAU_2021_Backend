package com.example.candidatemgmt.controller;


import java.util.ArrayList;
import java.util.List;

import com.example.candidatemgmt.bean.EduDetails;
import com.example.candidatemgmt.bean.JoiningDetails;
import com.example.candidatemgmt.bean.User;
import com.example.candidatemgmt.respository.EduDetailsRespository;
import com.example.candidatemgmt.respository.JoiningDetailsRepository;
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
@WebMvcTest(controllers = EduDetailsController.class)
public class TestEduDetailsController {

    @InjectMocks
    UserController userController;

    @MockBean
    EduDetailsRespository eduDetailsRespository;

    @Autowired
    private MockMvc mockMvc;

    List<EduDetails> list;
    List<EduDetails> singleResponse;

    String baseURL = "http://localhost:8080/edudetails";

    @Test
    public void testGetAllCandidates() throws Exception{
        when(eduDetailsRespository.getEdudetails()).thenReturn(list);
        this.mockMvc.perform(get(baseURL ))
                .andExpect(status().isOk());
    }
}


