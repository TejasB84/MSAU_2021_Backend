package com.example.candidatemgmt.controller;

//import com.example.candidatemgmt.bean.User;
import com.example.candidatemgmt.bean.JoiningDetails;
import com.example.candidatemgmt.bean.Trends1;
import com.example.candidatemgmt.bean.Trends3;
import com.example.candidatemgmt.bean.trends2;
import com.example.candidatemgmt.respository.JoiningDetailsRepository;
import com.example.candidatemgmt.respository.UserRespository;
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
@RequestMapping("/joining")
public class JoiningDetailsController {

    @Autowired
    JoiningDetailsRepository joiningDetailsRepository;

    @GetMapping("/test")
    public String test()
    {
        return "testing";
    }

    @GetMapping()
    public List<JoiningDetails> getAllJoiningDetails()
    {
        log.info("Get request received for get all Joining details ");
        return joiningDetailsRepository.getJoiningDetails();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getJoiningDetails(@PathVariable("id") Integer id) {
        JoiningDetails joiningDetails = joiningDetailsRepository.findById(id);
        log.info("Get request received for get all Joining details with id ");
        if (joiningDetails == null) {
            return new ResponseEntity<String>("No Joining details found with this "+ id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<JoiningDetails>(joiningDetails, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createJoiningDetails(@RequestBody JoiningDetails joiningDetails) throws SQLIntegrityConstraintViolationException {
        log.info("Post request received for Create new Joining details ");
        if (joiningDetailsRepository.findById(joiningDetails.getId()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ joiningDetails.getId(), HttpStatus.IM_USED);
        }
        joiningDetailsRepository.saveJoiningDetails(joiningDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<?> updateJoiningDetails(@RequestBody JoiningDetails joiningDetails) {
        log.info("Put request received for Update Joining details ");
        if (joiningDetailsRepository.findById(joiningDetails.getId()) == null) {
            return new ResponseEntity<String>("Unable to update as  Joining id " + joiningDetails.getId() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        joiningDetailsRepository.updateJoiningDetails(joiningDetails);
        return new ResponseEntity<JoiningDetails>(joiningDetails, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteJoiningDetails(@PathVariable("id") Integer id) {
        JoiningDetails joiningDetails =joiningDetailsRepository.findById(id);
        log.info("Delete request received for Delete Joining details ");
        if (joiningDetails == null) {
            return new ResponseEntity<String>("Unable to delete as  Joining Details id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        joiningDetailsRepository.deleteJoiningDetailsById(id);
        return new ResponseEntity<JoiningDetails>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/trends1")
    public List<Trends1> getCountPerYear()
    {
        return joiningDetailsRepository.getCountPerYear();
    }

    @GetMapping("/trends2")
    public List<trends2> getCountPerLocation()
    {
        return joiningDetailsRepository.getCountPerLoaction();
    }

    @GetMapping("/trends3")
    public List<Trends3> getCountPerTechnology()
    {
        return joiningDetailsRepository.getCountPerTechnology();
    }
}
