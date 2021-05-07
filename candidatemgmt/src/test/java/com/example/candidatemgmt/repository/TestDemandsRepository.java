package com.example.candidatemgmt.repository;

import com.example.candidatemgmt.respository.DemandsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestDemandsRepository {
    @Autowired
    DemandsRepository demandsRepository;
    @Test
    public void TestgetDemandsdetails(){
       assertEquals(5,demandsRepository.getDemandsdetails().size());
    }
    @Test
    public void TestfindById()
    {
        assertEquals(1,demandsRepository.findById(1).getDid());
    }

}
