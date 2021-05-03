package com.example.candidatemgmt.controller;

import com.example.candidatemgmt.bean.EduDetails;
import com.example.candidatemgmt.bean.OnBoardingDetails;
import com.example.candidatemgmt.respository.EduDetailsRespository;
import com.example.candidatemgmt.respository.OnBoardingDetailsRepository;
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
@RequestMapping("/onboardingdetails")
public class OnBoardingDetailsController {

    @Autowired
   OnBoardingDetailsRepository onBoardingDetailsRepository;

    @GetMapping("/test")
    public String test()
    {
        return "testing";
    }

    @GetMapping()
    public List<OnBoardingDetails> getAllOnboarddetails()
    {
        log.info("Get request received for get all Onboardee details ");

        return onBoardingDetailsRepository.getOnboarddetails();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOnboarddetails(@PathVariable("id") Integer id) {
        OnBoardingDetails onBoardingDetails = onBoardingDetailsRepository.findById(id);
        log.info("Get request received for get all Onboardee details with id  ");
        if (onBoardingDetails == null) {
            return new ResponseEntity<String>("No Onboarding details found with this "+ id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OnBoardingDetails>( onBoardingDetails, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createOnboarddetails(@RequestBody OnBoardingDetails onBoardingDetails) throws SQLIntegrityConstraintViolationException {
        log.info("Post request received for Create Onboardee details ");
        if (onBoardingDetailsRepository.findById(onBoardingDetails.getId()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ onBoardingDetails.getId(), HttpStatus.IM_USED);
        }
        onBoardingDetailsRepository.saveOnboarddetails(onBoardingDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<?> updateOnboarddetails(@RequestBody OnBoardingDetails onBoardingDetails) {
        log.info("Put request received for Update Onboardee details ");
        if (onBoardingDetailsRepository.findById(onBoardingDetails.getId()) == null) {
            return new ResponseEntity<String>("Unable to update as  User id " + onBoardingDetails.getId() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        onBoardingDetailsRepository.updateOnboarddetails(onBoardingDetails);
        return new ResponseEntity<OnBoardingDetails>(onBoardingDetails, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOnboarddetails(@PathVariable("id") Integer id) {
       OnBoardingDetails onBoardingDetails =onBoardingDetailsRepository.findById(id);
        log.info("Delete request received for Delete Onboardee details with id ");
        if (onBoardingDetails == null) {
            return new ResponseEntity<String>("Unable to delete as  User id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        onBoardingDetailsRepository.deleteOnboarddetailsById(id);
        return new ResponseEntity<OnBoardingDetails>(HttpStatus.NO_CONTENT);
    }
}
