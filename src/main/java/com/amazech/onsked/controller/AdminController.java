package com.amazech.onsked.controller;

import com.amazech.onsked.domain.*;
import com.amazech.onsked.service.AdminSvc;
import com.amazech.onsked.service.AppointmentSvc;
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
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminSvc adminSvc;

    @PostMapping("/businessCategory")
    public ResponseEntity<Integer> addBusinessCategory(@Valid @RequestBody Category category){
        try {
            Integer categoryCode = adminSvc.addBusinessCategory(category);
            return new ResponseEntity<>(categoryCode, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Business Category creation failed");
        }
    }

    @PostMapping("/updateBusinessCategory")
    public ResponseEntity updateBusinessCategory(@Valid @RequestBody Category category){
        try {
            adminSvc.updateBusinessCategory(category);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Business Category updation failed");
        }
    }
    @GetMapping("/getCategory")
    public ResponseEntity<Category> getCategory(@RequestParam(required = false) Integer categoryCode, @RequestParam(required = false) String categoryName){

        try{
            Category category = null;
            if(categoryCode!=null) {
                category = adminSvc.getCategoryByCategoryCode(categoryCode);
            }
            if(categoryName!=null) {
                category = adminSvc.getCategoryByCategoryName(categoryName);
            }
            return new ResponseEntity<>(category, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/enableDisableCategory")
    public ResponseEntity enableDisableCategory(@Valid @RequestBody Integer categoryCode){

        try{
            adminSvc.enableDisableCategory(categoryCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/addServiceToCategory")
    public ResponseEntity addServiceToCategory(@Valid @RequestBody ServiceMaster servicemaster){
        try {
            adminSvc.addServiceToCategory(servicemaster);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Service creation failed");
        }
    }

    @GetMapping("/getService")
    public ResponseEntity<ServiceMaster> getService(@RequestParam String serviceCode, @RequestParam(required=false) String categoryCode){

        try{
            ServiceMaster serviceMaster = null;
            if(categoryCode!=null) {
                serviceMaster = adminSvc.getServiceByCategoryCodeServiceCode(categoryCode, serviceCode);
            }else{
                serviceMaster = adminSvc.getServiceByServiceCode(serviceCode);
            }
            return new ResponseEntity<>(serviceMaster, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/updateServiceDetails")
    public ResponseEntity updateServiceDetails(@Valid @RequestBody ServiceMaster service){
        try {
            adminSvc.updateServiceDetails(service);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Service updating failed");
        }
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<Category>> getAllCategories(){

        try{
            List<Category> categories = adminSvc.getAllCategories();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/checkService")
    public ResponseEntity<Integer> checkService(@Valid @RequestBody ServiceMaster service){

        try{
            Integer count = adminSvc.checkService(service);
            return new ResponseEntity<>(count, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/addService")
    public ResponseEntity addService(@Valid @RequestBody ServiceMaster service){
        try {
            adminSvc.addService(service);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Service creation failed");
        }
    }

    @PostMapping("/updateService")
    public ResponseEntity updateService(@Valid @RequestBody ServiceMaster service, @RequestParam String categoryCode, @RequestParam String serviceCode){
        try {
            adminSvc.updateService(service, categoryCode, serviceCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Service updating failed");
        }
    }

    @DeleteMapping("/deleteService")
    public ResponseEntity deleteService(@RequestParam String categoryCode, @RequestParam String serviceCode){
        try {
            adminSvc.deleteService(categoryCode, serviceCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Service deletion failed");
        }
    }

    @GetMapping("/getAllServices")
    public ResponseEntity<List<ServiceMaster>> getAllServices(){

        try{
            List<ServiceMaster> serviceMasters = adminSvc.getAllServices();
            return new ResponseEntity<>(serviceMasters, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getMasterServices")
    public ResponseEntity<List<ServiceMaster>> getMasterServices(@RequestParam Integer categoryCode){

        try{
            List<ServiceMaster> serviceMasters = adminSvc.getMasterServices(categoryCode);
            return new ResponseEntity<>(serviceMasters, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/enableDisableHoliday")
    public ResponseEntity enableDisableHoliday(@RequestParam String countryCode, @RequestParam String holidayDt){
        try {
            adminSvc.enableDisableHoliday(countryCode, holidayDt);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/checkDefaultHoliday")
    public ResponseEntity<Integer> checkDefaultHoliday(@RequestParam String countryCode, @RequestParam String holidayDt){
        try {
            Integer value = adminSvc.checkDefaultHoliday(countryCode, holidayDt);
            return new ResponseEntity<>(value, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/addDefaultHoliday")
    public ResponseEntity<Holiday> addDefaultHoliday(@Valid @RequestBody Holiday holiday){
        try {
            holiday = adminSvc.addDefaultHoliday(holiday);
            return new ResponseEntity<>(holiday, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Holiday creation failed");
        }
    }

    @GetMapping("/getHoliday")
    public ResponseEntity<Holiday> getHoliday(@RequestParam String countryCode, @RequestParam String holidayDt){
        try {
            Holiday value = adminSvc.getHolidayByDateAndCountry(countryCode, holidayDt);
            return new ResponseEntity<>(value, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/updateDefaultHoliday")
    public ResponseEntity updateDefaultHoliday(@Valid @RequestBody Holiday holiday, @RequestParam String countryCode, @RequestParam String holidayDt){
        try {
            adminSvc.updateDefaultHoliday(holiday, countryCode, holidayDt);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Holiday updating failed");
        }
    }

    @GetMapping("/getAllCountries")
    public ResponseEntity<List<Country>> getAllCountries(){
        try {
            List<Country> values = adminSvc.getAllCountries();
            return new ResponseEntity<>(values, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/checkCountry")
    public ResponseEntity<Integer> checkCountry(@RequestParam(required=false) String countryName, @RequestParam(required=false) String countryCode){
        try {
            Integer value = null;
            if(countryName!=null) {
                value = adminSvc.checkCountryByCountryName(countryName);
            }
            if(countryCode!=null) {
                value = adminSvc.checkCountryByCountryCode(countryCode);
            }
            return new ResponseEntity<>(value, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/addCountry")
    public ResponseEntity addCountry(@Valid @RequestBody Country country){
        try {
            adminSvc.addCountry(country);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Country addition failed");
        }
    }

    @GetMapping("/getCountry")
    public ResponseEntity<Country> getCountry(@RequestParam String countryCode){
        try {
            Country country = adminSvc.getCountryByCountryCode(countryCode);
            return new ResponseEntity<>(country, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/updateCountry")
    public ResponseEntity updateCountry(@Valid @RequestBody Country country, @RequestParam String countryCode){
        try {
            adminSvc.updateCountry(country, countryCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Country updating failed");
        }
    }

    @DeleteMapping("/deleteCountry")
    public ResponseEntity deleteCountry(@RequestParam String countryCode){
        try {
            adminSvc.deleteCountry(countryCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Country deletion failed");
        }
    }

    @DeleteMapping("/deleteState")
    public ResponseEntity deleteState(@RequestParam String countryCode, @RequestParam String stateCode){
        try {
            adminSvc.deleteState(countryCode, stateCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "State deletion failed");
        }
    }

    @PostMapping("/addState")
    public ResponseEntity addState(@Valid @RequestBody State state){
        try {
            adminSvc.addState(state);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "State addition failed");
        }
    }

    @GetMapping("/getState")
    public ResponseEntity<State> getState(@RequestParam String countryCode, @RequestParam String stateCode){
        try {
            State state = adminSvc.getStateByCountryCodeStateCode(countryCode, stateCode);
            return new ResponseEntity<>(state, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/updateState")
    public ResponseEntity updateState(@Valid @RequestBody State state, @RequestParam String countryCode, @RequestParam String stateCode){
        try {
            adminSvc.updateState(state, countryCode, stateCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "State updating failed");
        }
    }

    @PostMapping("/enableDisableBusiness")
    public ResponseEntity enableDisableBusiness(@RequestParam Integer bizId){
        try {
            adminSvc.enableDisableBusiness(bizId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Business updating failed");
        }
    }

    @PostMapping("/upgradeUser")
    public ResponseEntity upgradeUser(@RequestParam Integer userId){
        try {
            adminSvc.upgradeUser(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "User updating failed");
        }
    }

    @PostMapping("/updateOnskedUsers")
    public ResponseEntity updateOnskedUsers(@RequestParam String userId){
        try {
            adminSvc.updateOnskedUsers(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "User updating failed");
        }
    }
}
