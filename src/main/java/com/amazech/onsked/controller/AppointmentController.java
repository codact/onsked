package com.amazech.onsked.controller;

import com.amazech.onsked.domain.Category;
import com.amazech.onsked.service.AppointmentSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentSvc appointmentSvc;
    @PostMapping("/category")
    public ResponseEntity<Integer> addCategory(@Valid @RequestBody Category category){
        try {
            Integer categoryCode = appointmentSvc.addBusinessCategory(category);
            return new ResponseEntity<>(categoryCode, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Category creation failed");
        }
    }


}
