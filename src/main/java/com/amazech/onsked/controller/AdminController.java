package com.amazech.onsked.controller;

import com.amazech.onsked.service.AdminSvc;
import com.amazech.onsked.service.AppointmentSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminSvc adminSvc;
}
