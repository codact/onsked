package com.amazech.onsked.controller;


import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.DataAccessException;
import com.amazech.onsked.exceptions.GenericBusinessException;

import com.amazech.onsked.service.UserSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

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
    @GetMapping("/level/{id}")
    public ResponseEntity<Object> getLevelId(@PathVariable("id") Integer id){
        try {
            String levelId =userSvc.getLevelId(id);
            if(levelId !=null)
                return new ResponseEntity<>(levelId, HttpStatus.OK);
            else
                return new ResponseEntity<>("User level Id Not Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Invalid User Details");
        }
    }


    @GetMapping("/country/{id}")
    public ResponseEntity<Object> getCountryCallingCode(@RequestParam String countryCode){
        try {
            String callingCode =userSvc.getCountryCallingCode(countryCode);
            if(callingCode !=null)
                return new ResponseEntity<>(callingCode, HttpStatus.OK);
            else
                return new ResponseEntity<>("User level Id Not Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Invalid User Details");
        }
    }


    @GetMapping("/role")
    public ResponseEntity<Object> getUserRoleByUserId(@RequestParam Integer userId){
        try {
            UserRole userRole =userSvc.getUserRoleByUserId(userId);
            if(userRole !=null)
                return new ResponseEntity<>(userRole, HttpStatus.OK);
            else
                return new ResponseEntity<>("User role Not Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Invalid User Details");
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addUser(@Valid @RequestBody User user){
        try {
            Integer userId = null;
            if(user.getUserId()==null|| user.getUserId().describeConstable().isEmpty()) {
                 userId = userSvc.addUser(user);
            }else{
                 userSvc.updateUser(user);
                userId = user.getUserId();
            }
            return new ResponseEntity<>(userId, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "User creation failed");
        }
    }

    @PostMapping("/email")
    public ResponseEntity<Object> addUserMail(@Valid @RequestBody UserMail user, HttpServletRequest request){
        try {
             if(user.getEmail() == null) {
                 userSvc.addUserMail(user, request);
             }else{
                 userSvc.updateUserMail(user);
             }
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "User creation failed");
        }
    }

    @GetMapping("/activateEmail")
    public ResponseEntity<Object> activateUserMail(@RequestParam String verHash, @RequestParam Integer userId){
        try {
              userSvc.activateUserMail(verHash, userId);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Failed");
        }
    }

    @GetMapping("/email")
    public ResponseEntity<Object> getUserMailDetails(@RequestParam(required = false) Integer userId,
                                                             @RequestParam(required = false)Integer verCode){
        try {
            UserMail userMail= null;
            if(userId!=null && userId>0) {
                userMail = userSvc.getUserMailDetailsByUserId(userId);
            }else if(verCode!=null && verCode>0){
                userMail = userSvc.getUserMailDetailsByVerCode(verCode);
            }
            return new ResponseEntity<>(userMail, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Failed");
        }
    }

    @PostMapping("/password")
    public ResponseEntity<Integer> updatePassword(@RequestParam Integer userId, @RequestParam String password){
        try {
            userSvc.updatePassword(userId, password);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "User creation failed");
        }
    }

    @PostMapping("/upgrade")
    public ResponseEntity<Integer> upgradeUser(@RequestParam Integer userId){
        try {
            userSvc.upgradeUser(userId);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "User upgrade failed");
        }
    }
    @PostMapping("/activateBusiness")
    public ResponseEntity<Integer> activateBusiness(@RequestParam Integer userId){
        try {
            userSvc.activateBusiness(userId);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "activateBusiness failed");
        }
    }
    @PostMapping("/paymentDetails/paypal")
    public ResponseEntity<Object> addPaymentDetails(@RequestBody UserPayments userPayments){
        try {
                userSvc.addPaymentDetails(userPayments);
            return new ResponseEntity<>(userPayments, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "activateBusiness failed");
        }
    }

    @PostMapping("/paymentDetails")
    public ResponseEntity<Object> addPaymentDetails(@RequestBody Payment payment){
        try {
             userSvc.addPaymentDetailsForUpgaradeUser(payment);
            return new ResponseEntity<>(payment, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "activateBusiness failed");
        }
    }

    @PostMapping("/userLoginDt")
    public ResponseEntity<Object> updateUserLoginDt(@RequestParam Integer userId){
        try {
            userSvc.updateUserLoginDt(userId);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "activateBusiness failed");
        }
    }

    @PostMapping("/loginAttempts")
    public ResponseEntity<Object> updateLoginAttempts(@RequestParam String email){
        try {
            userSvc.updateLoginAttempts(email);
            return new ResponseEntity<>(email, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "activateBusiness failed");
        }
    }

    @PostMapping("/loginCounter")
    public ResponseEntity<Object> resetLoginCounter(@RequestParam Integer userId){
        try {
            userSvc.resetLoginCounter(userId);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "activateBusiness failed");
        }
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<Object> resetPassword(@RequestParam String email, @RequestParam String password){
        try {
            userSvc.resetPassword(email, password);
            return new ResponseEntity<>(email, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "activateBusiness failed");
        }
    }

    @GetMapping("/randomUserSecurityQuestion")
    public ResponseEntity<Object> getRandomUserSecurityQuestion(@RequestParam String email){
        try {
            SecurityQuestion question =userSvc.getRandomUserSecurityQuestion(email);
            return new ResponseEntity<>(question, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/unregisteredUser")
    public ResponseEntity<Object> addUnregisteredUserDetails(@RequestBody UnregisteredUser unregisteredUser){
        try {
            int userDetails =userSvc.addUnregisteredUserDetails(unregisteredUser);
            return new ResponseEntity<>(userDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/updateUserRole")
    public ResponseEntity<Object> updateUserRole(@RequestParam String roleCode,@RequestParam Integer userId){
        try {
            userSvc.updateUserRole(roleCode, userId);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/sendContactUsMail")
    public ResponseEntity<Object> sendContactUsMail(@RequestBody UserMail userMail){
        try {
            //userSvc.sendContactUsMail(roleCode, userId);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/sendAlertMail")
    public ResponseEntity<Object> sendAlertMail(@RequestBody UserMail userMail){
        try {
            //userSvc.sendAlertMail(userMail);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/sendAlertSMS")
    public ResponseEntity<Object> sendAlertSMS(@RequestBody UserMail userMail){
        try {
            //userSvc.sendAlertSMS(userMail);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/sendPromtionMail")
    public ResponseEntity<Object> sendPromtionMail(@RequestBody UserMail userMail){
        try {
            //userSvc.sendPromtionMail(userMail);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/checkBusinessLimit")
    public ResponseEntity<Object> checkBusinessLimit(@RequestParam Integer userId){
        try {
            Integer userLimit = userSvc.checkBusinessLimit(userId);
            return new ResponseEntity<>(userLimit, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/businessesForPricing")
    public ResponseEntity<Object> getBusinessesForPricing(@RequestParam Integer userId){
        try {
            Integer pricing =userSvc.getBusinessesForPricing(userId);
            return new ResponseEntity<>(pricing, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/checkLocationLimit")
    public ResponseEntity<Object> checkLocationLimit(@RequestParam Integer userId){
        try {
            Integer limit = userSvc.checkLocationLimit(userId);
            return new ResponseEntity<>(limit, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/locationsForPricing")
    public ResponseEntity<Object> getLocationsForPricing(@RequestParam Integer userId){
        try {
            Integer pricing =userSvc.getLocationsForPricing(userId);
            return new ResponseEntity<>(pricing, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/checkResourceLimit")
    public ResponseEntity<Object> checkResourceLimit(@RequestParam Integer userId){
        try {
            Integer limit = userSvc.checkResourceLimit(userId);
            return new ResponseEntity<>(limit, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/resourceForPricing")
    public ResponseEntity<Object> getResourceForPricing(@RequestParam Integer userId){
        try {
            Integer pricing =userSvc.getResourceForPricing(userId);
            return new ResponseEntity<>(pricing, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/checkExpiryDate")
    public ResponseEntity<Object> checkExpiryDate(@RequestParam Integer userId){
        try {
            Integer limit = userSvc.checkExpiryDate(userId);
            return new ResponseEntity<>(limit, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @PostMapping("/expiryDateWithoutAdding")
    public ResponseEntity<Object> expiryDateWithoutAdding(@RequestParam Integer userId){
        try {
            Integer limit = userSvc.expiryDateWithoutAdding(userId);
            return new ResponseEntity<>(limit, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/acctPaymentHistory")
    public ResponseEntity<Object> acctPaymentHistory(@RequestParam Integer userId){
        try {
            List<PaymentHistory> paymentHistory =userSvc.acctPaymentHistory(userId);
            return new ResponseEntity<>(paymentHistory, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/paymentPackageDetails")
    public ResponseEntity<Object> getPaymentPackageDetails(@RequestParam Integer levelId){
        try {
            PaymentHistory paymentHistory =userSvc.getPaymentPackageDetails(levelId);
            return new ResponseEntity<>(paymentHistory, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/userBusinessUserId")
    public ResponseEntity<Object> getUserBusinessUserId(@RequestParam Integer levelId){
        try {
            List<Business> business =userSvc.getUserBusinessUserId(levelId);
            return new ResponseEntity<>(business, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/staffWorkingBizId")
    public ResponseEntity<Object> getStaffWorkingBizId(@RequestParam Integer userId){
        try {
            WeakHashMap<String, Object> business =userSvc.getStaffWorkingBizId(userId);
            return new ResponseEntity<>(business, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/userPaymentDetailsByUserId")
    public ResponseEntity<Object> getUserPaymentDetailsByUserId(@RequestParam Integer userId){
        try {
            User user =userSvc.getUserPaymentDetailsByUserId(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }


    @GetMapping("/userSubscriptionByUserId")
    public ResponseEntity<Object> getUserSubscriptionByUserId(@RequestParam Integer userId){
        try {
            List<PaymentHistory> paymentHistories =userSvc.getUserSubscriptionByUserId(userId);
            return new ResponseEntity<>(paymentHistories, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/activeBusinesses")
    public ResponseEntity<Object> getActiveBusinesses(@RequestParam Integer userId){
        try {
            HashMap<String, String> businesses =userSvc.getActiveBusinesses(userId);
            return new ResponseEntity<>(businesses, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }


    @GetMapping("/apptUserInfo")
    public ResponseEntity<Object> getApptUserInfo(@RequestParam String userTblName, @RequestParam Integer apptHolderId,
                                                  @RequestParam String colName){
        try {
            User user =userSvc.getApptUserInfo(userTblName, apptHolderId, colName);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/unregisteredUserDetails")
    public ResponseEntity<Object> getUnregisteredUserDetails(@RequestParam Integer unregisteredUserId){
        try {
            UnregisteredUser user =userSvc.getUnregisteredUserDetails(unregisteredUserId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/checkAnswer")
    public ResponseEntity<Object> checkUserSecurityAnswer(@RequestParam Integer securityQuestion1,
                                                          @RequestParam String answer1,@RequestParam String email,
                                                          HttpServletRequest request){
        try {
            Integer answer =userSvc.checkUserSecurityAnswer(securityQuestion1, answer1, email, request);
            return new ResponseEntity<>(answer, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/checkEmail")
    public ResponseEntity<Object> checkEmailIdExists(@RequestParam String email){
        try {
            Integer emailIdExists =userSvc.checkEmailIdExists(email);
            return new ResponseEntity<>(emailIdExists, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }
    @GetMapping("/registeredBusiness")
    public ResponseEntity<Object> getLatestRegisteredBusiness(){
        try {
            List<Business> business =userSvc.getLatestRegisteredBusiness();
            if(business!=null && !business.isEmpty())
                return new ResponseEntity<>(business, HttpStatus.OK);
            else
                return new ResponseEntity<>(" Not Results Found", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/paymentModes/{userId}")
    public ResponseEntity<Object> getUserPaymentDetails(@PathVariable("userId") Integer userId){
        try {
            UserPayments paymentModes =userSvc.getUserPaymentDetails(userId);
            if(paymentModes!=null)
                return new ResponseEntity<>(paymentModes, HttpStatus.OK);
            else
                return new ResponseEntity<>(" Not Results Found", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/paymentModes")
    public ResponseEntity<Object> getPaymentModes(){
        try {
            List<PaymentModes> paymentModes =userSvc.getPaymentModes();
            if(paymentModes!=null && !paymentModes.isEmpty())
                return new ResponseEntity<>(paymentModes, HttpStatus.OK);
            else
                return new ResponseEntity<>(" Not Results Found", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }
    @GetMapping("/businessExpiryDate")
    public ResponseEntity<Object> getBusinessExpiryDate(@RequestParam Integer userId){
        try {
            String expiryDate =userSvc.getBusinessExpiryDate(userId);
            if(expiryDate!=null && !expiryDate.isEmpty())
                return new ResponseEntity<>(expiryDate, HttpStatus.OK);
            else
                return new ResponseEntity<>(" Not Results Found", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/incrementedExpiryDate")
    public ResponseEntity<Object> getIncrementedExpiryDate(@RequestParam Integer userId){
        try {
            String expiryDate =userSvc.getIncrementedExpiryDate(userId);
            if(expiryDate!=null && !expiryDate.isEmpty())
                return new ResponseEntity<>(expiryDate, HttpStatus.OK);
            else
                return new ResponseEntity<>(" Not Results Found", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/timeZones")
    public ResponseEntity<Object> getTimeZonesByCountryCode(@RequestParam String countryCode){
        try {
            List<TimeZones> timeZones =userSvc.getTimeZonesByCountryCode(countryCode);
            if(timeZones!=null && !timeZones.isEmpty())
                return new ResponseEntity<>(timeZones, HttpStatus.OK);
            else
                return new ResponseEntity<>(" Not Results Found", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    @GetMapping("/upgradeOptions")
    public ResponseEntity<Object> getUpgradeOptions(){
        try {
            List<UpgradeOptions> upgradeOptions =userSvc.getUpgradeOptions();
            if(upgradeOptions!=null && !upgradeOptions.isEmpty())
                return new ResponseEntity<>(upgradeOptions, HttpStatus.OK);
            else
                return new ResponseEntity<>(" Not Results Found", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
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
