package com.amazech.onsked.controller;

import com.amazech.onsked.domain.AppointmentSchedule;
import com.amazech.onsked.service.AppointmentSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    AppointmentSvc appointmentSvc;
    @GetMapping
    public String getHello(){
        return "Hello World";
    }
}
