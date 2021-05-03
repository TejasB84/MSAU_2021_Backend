package com.example.candidatemgmt.controller;

import com.example.candidatemgmt.bean.EduDetails;
import com.example.candidatemgmt.respository.EduDetailsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/edudetails")
public class EduDetailsController {

    @Autowired
    EduDetailsRespository eduDetailsRespository;

    @GetMapping("/test")
    public String test()
    {
        return "testing";
    }

    @GetMapping()
    public List<EduDetails> getAllEdudetails()
    {
        log.info("Get request received for get all education details ");
        return eduDetailsRespository.getEdudetails();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEdudetails(@PathVariable("id") Integer id) {
        EduDetails eduDetails = eduDetailsRespository.findById(id);
        log.info("Get request received for get all education details with id ");
        if (eduDetails == null) {
            return new ResponseEntity<String>("No edudetails found with this "+ id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EduDetails>( eduDetails, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createEdudetails(@RequestBody EduDetails eduDetails) throws SQLIntegrityConstraintViolationException {
        log.info("Post request received for Create new education Details ");
        if (eduDetailsRespository.findById(eduDetails.getId()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ eduDetails.getId(), HttpStatus.IM_USED);
        }
        eduDetailsRespository.saveEdudetails(eduDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<?> updateEdudetails(@RequestBody EduDetails eduDetails) {
        log.info("Put request received for Update education details ");
        if (eduDetailsRespository.findById(eduDetails.getId()) == null) {
            return new ResponseEntity<String>("Unable to update as  User id " + eduDetails.getId() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        eduDetailsRespository.updateEdudetails(eduDetails);
        return new ResponseEntity<EduDetails>(eduDetails, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEdudetails(@PathVariable("id") Integer id) {
        log.info("Delete request received for Delete education details with id ");
        EduDetails eduDetails =eduDetailsRespository.findById(id);
        if (eduDetails == null) {
            return new ResponseEntity<String>("Unable to delete as  User id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        eduDetailsRespository.deleteEdudetailsById(id);
        return new ResponseEntity<EduDetails>(HttpStatus.NO_CONTENT);
    }
}
