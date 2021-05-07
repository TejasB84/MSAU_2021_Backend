package com.example.candidatemgmt.repository;

import com.example.candidatemgmt.bean.EduDetails;
import com.example.candidatemgmt.bean.JoiningDetails;
import com.example.candidatemgmt.respository.JoiningDetailsRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestJoiningDetailsRepository {
@Autowired
    JoiningDetailsRepository joiningDetailsRepository;

@Test
    public void TestgetJoiningDetails()
    {
        assertEquals(15,joiningDetailsRepository.getJoiningDetails().size());
    }
    @Test
    @Order(1)
    public void TestfindById()
    {
        assertEquals(1,joiningDetailsRepository.findById(1).getId());
    }

    @Test
    @Order(2)
    public void TestsaveJoiningDetails()
    {
        JoiningDetails joiningDetails = new JoiningDetails();
        joiningDetails.setId(224);
        joiningDetails.setDate("2020-10-05");
        joiningDetails.setTechnology("Deep Learning");
        joiningDetails.setLocation(" Pune");
        joiningDetails.setFeedback("Testing Feedback Done");
        joiningDetailsRepository.saveJoiningDetails(joiningDetails);
        assertNotNull(joiningDetailsRepository.findById(223).getId());
    }
    @Test
    @Order(3)
    public void updateJoiningDetails()
    {
        JoiningDetails joiningDetails = new JoiningDetails();
        joiningDetails.setId(223);
        joiningDetails.setDate("2021-10-05");
        joiningDetails.setTechnology("Machine Learning");
        joiningDetails.setLocation(" Hydrabad");
        joiningDetails.setFeedback("Testing Feedback Done");
        joiningDetailsRepository.updateJoiningDetails(joiningDetails);
        assertNotNull(joiningDetailsRepository.findById(223).getId());
    }


    @Test
    @Order(4)
    public void deleteJoiningDetailsById(){
        Integer onboardId = 224;
        assertEquals(1,joiningDetailsRepository.deleteJoiningDetailsById(onboardId));
    }

}
