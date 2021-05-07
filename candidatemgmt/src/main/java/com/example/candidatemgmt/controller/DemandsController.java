package com.example.candidatemgmt.controller;

import com.example.candidatemgmt.bean.*;
import com.example.candidatemgmt.respository.DemandsRepository;
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
@RequestMapping("/demands")
public class DemandsController {

    @Autowired
    DemandsRepository demandsRepository;

    @GetMapping("/test")
    public String test()
    {
        return "testing";
    }

    @GetMapping()
    public List<Demands> getAllDemandsdetails()
    {
        log.info("Get request received for all demands");
        return demandsRepository.getDemandsdetails();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getDemandsdetails(@PathVariable("id") Integer id) {
        log.info("Get request received for demand with id: "+id);

        Demands demands = demandsRepository.findById(id);
        if (demands == null) {
            return new ResponseEntity<String>("No Onboarding details found with this "+ id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Demands>( demands, HttpStatus.OK);
    }
//    @PostMapping
//    public ResponseEntity<String> createDemandsdetails(@RequestBody Demands demands) throws SQLIntegrityConstraintViolationException {
//        log.info("Post request received to create a new demand");
//        if (demandsRepository.findById(demands.getDid()) != null) {
//            return new ResponseEntity<String>("Duplicate Entry "+ demands.getDid(), HttpStatus.IM_USED);
//        }
//        demandsRepository.saveDemandsdetails(demands);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//    @PutMapping
//    public ResponseEntity<?> updateOnboarddetails(@RequestBody Demands demands) {
//        if (demandsRepository.findById(demands.getDid()) == null) {
//            return new ResponseEntity<String>("Unable to update as  User id " + demands.getDid() + " not found.",
//                    HttpStatus.NOT_FOUND);
//        }
//
//        demandsRepository.updateDemandsdetails(demands);
//        return new ResponseEntity<Demands>(demands, HttpStatus.OK);
//    }



//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deleteOnboarddetails(@PathVariable("id") Integer id) {
//        Demands demands =demandsRepository.findById(id);
//        if (demands == null) {
//            return new ResponseEntity<String>("Unable to delete as  User id " + id + " not found.", HttpStatus.NOT_FOUND);
//        }
//        demandsRepository.deleteDemandsdetailsById(id);
//        return new ResponseEntity<Demands>(HttpStatus.NO_CONTENT);
//    }

//    @GetMapping("/trends2")
//    public List<trends2> getCountPerYear()
//    {
//        return demandsRepository.getCountPerYear();
//    }

}
