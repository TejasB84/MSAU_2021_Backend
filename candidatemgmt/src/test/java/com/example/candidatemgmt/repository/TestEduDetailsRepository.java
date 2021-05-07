package com.example.candidatemgmt.repository;

import com.example.candidatemgmt.bean.EduDetails;
import com.example.candidatemgmt.respository.EduDetailsRespository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEduDetailsRepository {

    @Autowired
    EduDetailsRespository eduDetailsRespository;
    @Test
    @Order(1)
    public void TestgetEdudetails()
    {
        assertEquals(15,eduDetailsRespository.getEdudetails().size());
    }

    @Test
    @Order(2)
    public void TestfindById()
    {
        assertEquals(1,eduDetailsRespository.findById(1).getId());
    }


    @Test
    @Order(3)
    public void TestsaveEdudetails()
    {
        EduDetails eduDetails = new EduDetails();
        eduDetails.setId(223);
        eduDetails.setClgname("DYPIEMR");
        eduDetails.setUniversityname("Pune University");
        eduDetails.setCourse("C++");
        eduDetails.setAddress("Akurdi");
        eduDetailsRespository.saveEdudetails(eduDetails);
        assertNotNull(eduDetailsRespository.findById(222).getId());
    }
    @Test
    @Order(4)
    public void TestupdateEdudetails()
    {
        EduDetails eduDetails = new EduDetails();
        eduDetails.setId(222);
        eduDetails.setClgname("D Y Patil");
        eduDetails.setUniversityname("Pune University");
        eduDetails.setCourse("AI");
        eduDetails.setAddress("near ravet");
        eduDetailsRespository.updateEdudetails(eduDetails);
        assertNotNull(eduDetailsRespository.findById(222).getId());
    }


    @Test
    @Order(5)
    public void TestdeleteEdudetailsById(){
        Integer onboardId = 223;
        assertEquals(1,eduDetailsRespository.deleteEdudetailsById(onboardId));
    }
}
