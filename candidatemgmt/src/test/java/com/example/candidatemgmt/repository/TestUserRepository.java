package com.example.candidatemgmt.repository;

import com.example.candidatemgmt.bean.EduDetails;
import com.example.candidatemgmt.bean.User;
import com.example.candidatemgmt.respository.UserRespository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class TestUserRepository {
    @Autowired
    UserRespository userRespository =  new UserRespository();

    @Test
    @Order(1)
    public void TestgetUser()
    {
        assertEquals(18,userRespository.getUser().size());
    }
    @Test
    @Order(2)
    public void TestfindById()
    {
        assertEquals(1,userRespository.findById(1).getId());
    }

    @Test
    @Order(3)
    public  void TestsaveUser()
    {
        User user = new User();
        user.setId(225);
        user.setFirstname("Fname");
        user.setLastname("Lname");
        user.setPhoneno("1110000001");
        user.setEmail("testemail111@gmail.com");
        user.setBirthdate("1999-04-04");
        user.setCity("hydrabad");
        user.setCountry("India");
        user.setDid(2);
        userRespository.saveUser(user);
        assertNotNull(userRespository.findById(225).getId());

    }
    @Test
    @Order(4)
    public void TestupdateUser()
    {
        User user = new User();
        user.setId(225);
        user.setFirstname("Test Fname");
        user.setLastname("TestLname");
        user.setPhoneno("0000000000");
        user.setEmail("testemail1@gmail.com");
        user.setBirthdate("1999-04-04");
        user.setCity("Delhi");
        user.setCountry("India");
        user.setDid(2);
        userRespository.updateUser(user);
        assertNotNull(userRespository.findById(225).getId());
    }


    @Test
    @Order(5)
    public void TestdeleteUserById(){
        Integer onboardId = 225;
        assertEquals(1,userRespository.deleteUserById(onboardId));
    }
}
