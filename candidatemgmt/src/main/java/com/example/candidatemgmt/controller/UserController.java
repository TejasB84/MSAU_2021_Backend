package com.example.candidatemgmt.controller;

import com.example.candidatemgmt.bean.User;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRespository userRespository;

    @GetMapping("/test")
    public String test()
    {
        return "testing";
    }

    @GetMapping()
    public List<User> getAllUsers()
    { log.info("Get request received for all users");
      return userRespository.getUser();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
        User user = userRespository.findById(id);
        log.info("Get request received for user with id: "+id);

        if (user == null) {
            return new ResponseEntity<String>("No User found with this "+ id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) throws SQLIntegrityConstraintViolationException {
        log.info("Post request received for Create user ");

        if (userRespository.findById(user.getId()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ user.getId(), HttpStatus.IM_USED);
        }
        userRespository.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        log.info("Put request received for Update user ");
        if (userRespository.findById(user.getId()) == null) {
            return new ResponseEntity<String>("Unable to update as  User id " + user.getId() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        userRespository.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        User user =userRespository.findById(id);
        log.info("Delete request received for delete user ");
        if (user == null) {
            return new ResponseEntity<String>("Unable to delete as  User id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        userRespository.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
