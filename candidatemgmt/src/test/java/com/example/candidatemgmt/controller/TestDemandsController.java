package com.example.candidatemgmt.controller;


import com.example.candidatemgmt.bean.Demands;
import com.example.candidatemgmt.bean.OnBoardingDetails;
import com.example.candidatemgmt.respository.DemandsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DemandsController.class)
public class TestDemandsController {

    @InjectMocks
    DemandsController demandsController;
    @MockBean
    DemandsRepository demandsRepository;
    Demands demands;
    @Autowired
    private MockMvc mockMvc;
    List<Demands> list;

    List<Demands> singleResponse;
    String baseURL = "http://localhost:8080/demands";
    @BeforeEach
    public void setup() {
        list  = new ArrayList<Demands>();
        singleResponse = new ArrayList<Demands>();
        Demands demands = new Demands();
        demands.setDid(6);
        demands.setRole("Graphics");
        demands.setDept("Graph");
        demands.setMname("bob");
        demands.setLocation("pune");
        demands.setSkills("Java");
        list.add(demands);
        singleResponse.add(demands);
        demands = new Demands();
        demands.setDid(6);
        demands.setDept("Test1");
        list.add(demands);
    }


    @Test
    public void testGetAllCandidates() throws Exception{
         when(demandsRepository.getDemandsdetails()).thenReturn(list);
        this.mockMvc.perform(get(baseURL ))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }


}
