package com.amazech.onsked.controller;

import com.amazech.onsked.domain.Category;
import com.amazech.onsked.domain.PageviewTracker;
import com.amazech.onsked.domain.User;
import com.amazech.onsked.exceptions.DataAccessException;
import com.amazech.onsked.service.PageviewTrackerSvc;
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
@RequestMapping("/api/v1/page")
public class PageViewController {

    @Autowired
    private PageviewTrackerSvc pageviewTrackerSvc;


    @GetMapping("/pageviewCount")
    public ResponseEntity<Object> getPageviewCountOfBusiness(@RequestParam(required = false) String bizId,
                                                                @RequestParam(required = false)  String userId,  @RequestParam String pageName){
        try {
            Integer count = null;
            List<PageviewTracker> counts = null;
            if(bizId!=null) {
                count = pageviewTrackerSvc.getPageviewCountOfBusiness(bizId, pageName);
                return new ResponseEntity<>(count, HttpStatus.OK);
            }
            else if(userId!=null){
                counts = pageviewTrackerSvc.getPageviewCountOfAllBusiness(userId, pageName);
                return new ResponseEntity<>(counts, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Invalid request", HttpStatus.OK);
            }
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Business Category creation failed");
        }
    }

    @PostMapping
    public ResponseEntity<Object> addPageviewCount(@Valid @RequestBody PageviewTracker pageviewTracker){
        try {
            pageviewTrackerSvc.addPageviewCount(pageviewTracker);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "User creation failed");
        }
    }

}
