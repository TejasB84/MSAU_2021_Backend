package com.example.candidatemgmt.repository;

import com.example.candidatemgmt.bean.EduDetails;
import com.example.candidatemgmt.bean.OnBoardingDetails;
import com.example.candidatemgmt.respository.OnBoardingDetailsRepository;
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
public class TestOnBoardingDetailsRepository {
    @Autowired
    OnBoardingDetailsRepository onBoardingDetailsRepository;
    @Test
    @Order(1)
    public  void TestgetOnboarddetails()
    {
        assertEquals(16,onBoardingDetailsRepository.getOnboarddetails().size());
    }

    @Test
    @Order(2)
    public void TestfindById()
    {
        assertEquals(1,onBoardingDetailsRepository.findById(1).getId());
    }

    @Test
    @Order(3)
    public void TestsaveOnboarddetails()
    {
        OnBoardingDetails onBoardingDetails = new OnBoardingDetails();
        onBoardingDetails.setId(223);
        onBoardingDetails.setonboardingDate("01-10-2021");
        onBoardingDetails.setbcgStatus("Done");
        onBoardingDetails.setGraduationStatus("Pending");
        onBoardingDetails.setetaStatus("Pending");
        onBoardingDetailsRepository.saveOnboarddetails(onBoardingDetails);
        assertNotNull(onBoardingDetailsRepository.findById(222).getId());
    }
    @Test
    @Order(4)
    public void TestupdateOnboarddetails()
    {
        OnBoardingDetails onBoardingDetails = new OnBoardingDetails();
        onBoardingDetails.setId(222);
        onBoardingDetails.setonboardingDate("10-10-2021");
        onBoardingDetails.setbcgStatus("Pending");
        onBoardingDetails.setGraduationStatus("Pending");
        onBoardingDetails.setetaStatus("Pending");
        onBoardingDetailsRepository.updateOnboarddetails(onBoardingDetails);
        assertNotNull(onBoardingDetailsRepository.findById(222).getId());
    }


    @Test
    @Order(5)
    public void TestdeleteOnboarddetailsById(){
        Integer onboardId = 223;
        assertEquals(1,onBoardingDetailsRepository.deleteOnboarddetailsById(onboardId));
    }
}
