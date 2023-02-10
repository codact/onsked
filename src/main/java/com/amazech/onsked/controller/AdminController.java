package com.amazech.onsked.controller;

import com.amazech.onsked.domain.*;
import com.amazech.onsked.service.AdminSvc;
import com.amazech.onsked.service.AppointmentSvc;
import com.amazech.onsked.util.OnskedList;
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

    @GetMapping("/getFeaturedBusinesses")
    public ResponseEntity<List<Business>> getFeaturedBusinesses(){
        try {
            List<Business> businesses = adminSvc.getFeaturedBusinesses();
            return new ResponseEntity<>(businesses, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getCategoriesOfSearchElement")
    public ResponseEntity<OnskedList> getCategoriesOfSearchElement(@RequestParam String searchElement,
                                                                   @RequestParam int pageSize,
                                                                   @RequestParam int pageNo,
                                                                   @RequestParam String sortBy,
                                                                   @RequestParam String sort){
        try {
            OnskedList categories = adminSvc.getCategoriesOfSearchElement(searchElement, pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getCountriesOfSearchElement")
    public ResponseEntity<OnskedList> getCountriesOfSearchElement(@RequestParam String searchElement,
                                                                   @RequestParam int pageSize,
                                                                   @RequestParam int pageNo,
                                                                   @RequestParam String sortBy,
                                                                   @RequestParam String sort){
        try {
            OnskedList countries = adminSvc.getCountriesOfSearchElement(searchElement, pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(countries, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getStatesOfSearchElement")
    public ResponseEntity<OnskedList> getStatesOfSearchElement(@RequestParam String filterState, @RequestParam String searchElement,
                                                                  @RequestParam int pageSize,
                                                                  @RequestParam int pageNo,
                                                                  @RequestParam String sortBy,
                                                                  @RequestParam String sort){
        try {
            OnskedList state = adminSvc.getStatesOfSearchElement(filterState, searchElement, pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(state, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getHolidaysOfSearchElement")
    public ResponseEntity<OnskedList> getHolidaysOfSearchElement(@RequestParam String searchElement,
                                                               @RequestParam int pageSize,
                                                               @RequestParam int pageNo,
                                                               @RequestParam String sortBy,
                                                               @RequestParam String sort){
        try {
            OnskedList holiday = adminSvc.getHolidaysOfSearchElement(searchElement, pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(holiday, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/checkStateIsEditable")
    public ResponseEntity<Integer> checkStateIsEditable(@RequestParam String countryCode, @RequestParam String stateCode){
        try {
            Integer count = adminSvc.checkStateIsEditable(countryCode, stateCode);
            return new ResponseEntity<>(count, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/markOrRemoveFeaturedBusiness")
    public ResponseEntity markOrRemoveFeaturedBusiness(@RequestParam Integer bizId, @RequestParam Integer userId){
        try {
            adminSvc.markOrRemoveFeaturedBusiness(bizId, userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getAllActiveOnskedUsersBySort")
    public ResponseEntity<OnskedList> getAllActiveOnskedUsersBySort(@RequestParam int pageSize,
                                                                 @RequestParam int pageNo,
                                                                 @RequestParam String sortBy,
                                                                 @RequestParam String sort){
        try {
            OnskedList users = adminSvc.getAllActiveOnskedUsersBySort(pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getUpgradeOptionsBySort")
    public ResponseEntity<OnskedList> getUpgradeOptionsBySort(@RequestParam int pageSize,
                                                                    @RequestParam int pageNo,
                                                                    @RequestParam String sortBy,
                                                                    @RequestParam String sort){
        try {
            OnskedList upgradeOptions = adminSvc.getUpgradeOptionsBySort(pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(upgradeOptions, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/addPaymentDetails")
    public ResponseEntity addPaymentDetails(@RequestParam Payment payment, @RequestParam String requestPath){
        try {
            adminSvc.addPaymentDetails(payment, requestPath);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/insertSubscription")
    public ResponseEntity insertSubscription(@RequestParam int userId,
                                             @RequestParam int numberOfBusiness,
                                             @RequestParam int numberOfLocation,
                                             @RequestParam int numberOfResource,
                                             @RequestParam String requestPath){
        try {
            adminSvc.insertSubscription(userId, numberOfBusiness, numberOfLocation, numberOfResource, requestPath);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/updateExpiryDate")
    public ResponseEntity updateExpiryDate(@RequestParam String expiryDate,
                                           @RequestParam Integer userId,
                                           @RequestParam String requestPath){
        try {
            adminSvc.updateExpiryDate(expiryDate, userId, requestPath);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getExpiryDate")
    public ResponseEntity<String> getExpiryDate(@RequestParam Integer userId){
        try {
            String dt = adminSvc.getExpiryDate(userId);
            return new ResponseEntity<>(dt, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getUsersByEmailId")
    public ResponseEntity<OnskedList> getUsersByEmailId(@RequestParam String searchElement,
                                                            @RequestParam int pageSize,
                                                            @RequestParam int pageNo,
                                                            @RequestParam String sortBy,
                                                            @RequestParam String sort){
        try {
            OnskedList users = adminSvc.getUsersByEmailId(searchElement, pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getFeaturedBusinessesBySort")
    public ResponseEntity<OnskedList> getFeaturedBusinessesBySort(@RequestParam int pageSize,
                                                        @RequestParam int pageNo,
                                                        @RequestParam String sortBy,
                                                        @RequestParam String sort){
        try {
            OnskedList users = adminSvc.getFeaturedBusinessesBySort(pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getAllCategoriesBySort")
    public ResponseEntity<OnskedList> getAllCategoriesBySort(@RequestParam int pageSize,
                                                                  @RequestParam int pageNo,
                                                                  @RequestParam String sortBy,
                                                                  @RequestParam String sort){
        try {
            OnskedList categories = adminSvc.getAllCategoriesBySort(pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getAllServicesBySort")
    public ResponseEntity<OnskedList> getAllServicesBySort(@RequestParam int pageSize,
                                                             @RequestParam int pageNo,
                                                             @RequestParam String sortBy,
                                                             @RequestParam String sort){
        try {
            OnskedList services = adminSvc.getAllServicesBySort(pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(services, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getMasterServicesBySort")
    public ResponseEntity<OnskedList> getMasterServicesBySort(@RequestParam Integer categoryCode, @RequestParam int pageSize,
                                                           @RequestParam int pageNo,
                                                           @RequestParam String sortBy,
                                                           @RequestParam String sort){
        try {
            OnskedList services = adminSvc.getMasterServicesBySort(categoryCode, pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(services, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getServicesOfSearchElement")
    public ResponseEntity<OnskedList> getServicesOfSearchElement(@RequestParam Integer filterService,
                                                                 @RequestParam String searchElement,
                                                                 @RequestParam int pageSize,
                                                                 @RequestParam int pageNo,
                                                                 @RequestParam String sortBy,
                                                                 @RequestParam String sort){
        try {
            OnskedList services = adminSvc.getServicesOfSearchElement(filterService, searchElement, pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(services, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/checkStateExist")
    public ResponseEntity<Integer> checkStateExist(@RequestParam String countryCode){
        try {
            Integer count = adminSvc.checkStateExist(countryCode);
            return new ResponseEntity<>(count, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/checkAppointmentExists")
    public ResponseEntity<Integer> checkAppointmentExists(@RequestParam String countryCode,
                                                          @RequestParam String holidayDt){
        try {
            Integer count = adminSvc.checkAppointmentExists(countryCode, holidayDt);
            return new ResponseEntity<>(count, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @PostMapping("/checkState")
    public ResponseEntity<Integer> checkState(@Valid @RequestBody State state){
        try {
            Integer count = adminSvc.checkState(state);
            return new ResponseEntity<>(count, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getAllStatesBySort")
    public ResponseEntity<OnskedList> getAllStatesBySort(@RequestParam int pageSize,
                                                           @RequestParam int pageNo,
                                                           @RequestParam String sortBy,
                                                           @RequestParam String sort){
        try {
            OnskedList states = adminSvc.getAllStatesBySort(pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(states, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }

    @GetMapping("/getCountryStates")
    public ResponseEntity<OnskedList> getCountryStates(@RequestParam String countryCode,
                                                              @RequestParam int pageSize,
                                                              @RequestParam int pageNo,
                                                              @RequestParam String sortBy,
                                                              @RequestParam String sort){
        try {
            OnskedList states = adminSvc.getCountryStates(countryCode, pageSize, pageNo, sortBy, sort);
            return new ResponseEntity<>(states, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Transaction failed");
        }
    }
}