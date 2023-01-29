package com.amazech.onsked.controller;


import com.amazech.onsked.domain.Category;
import com.amazech.onsked.domain.SecurityQuestion;
import com.amazech.onsked.domain.User;
import com.amazech.onsked.exceptions.GenericBusinessException;

import com.amazech.onsked.service.UserSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserSvc userSvc;

    @GetMapping
    public ResponseEntity<Object> getUser(@RequestParam String email, @RequestParam(required = false) String password){
        try {
            User user =null;
            if(password!=null){
                user = userSvc.getUser(email, password);
            }
            else{
                user = userSvc.getUserByEmailId(email);
            }
            if(user!=null)
                return new ResponseEntity<>(user, HttpStatus.OK);
            else
                return new ResponseEntity<>("User Not Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Invalid User Details");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Integer id){
        try {
            User user =userSvc.getUserByUserId(id);
            if(user!=null)
                return new ResponseEntity<>(user, HttpStatus.OK);
            else
                return new ResponseEntity<>("User Not Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Invalid User Details");
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addUser(@Valid @RequestBody User user){
        try {
            Integer userId = userSvc.addUser(user);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "User creation failed");
        }
    }

    @GetMapping("/securityQuestions")
    public ResponseEntity<Object> getAllSecurityQuestions(){
        try {
            List<SecurityQuestion> securityQuestions =userSvc.getAllSecurityQuestions();
            if(securityQuestions!=null && !securityQuestions.isEmpty())
                return new ResponseEntity<>(securityQuestions, HttpStatus.OK);
            else
                return new ResponseEntity<>(" Not Results Found", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }




}
