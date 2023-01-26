package com.amazech.onsked.service.impl;

import com.amazech.onsked.dao.entity.CategoryEntity;
import com.amazech.onsked.dao.entity.CountryEntity;
import com.amazech.onsked.dao.entity.UserEntity;
import com.amazech.onsked.dao.entity.UserRoleEntity;
import com.amazech.onsked.dao.repo.CountryRepository;
import com.amazech.onsked.dao.repo.UserRepository;
import com.amazech.onsked.dao.repo.UserRoleRepository;
import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.GenericBusinessException;
import com.amazech.onsked.service.UserSvc;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.WeakHashMap;
@Slf4j
@Service
public class UserSvcImpl implements UserSvc {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public User getUser(String email, String password) throws GenericBusinessException{
        log.debug("Before calling DAO method getUser()");
        User user = null;
        Optional<UserEntity> opUserEntity = userRepository.findByEmailAndPassword(email, password);
        if(opUserEntity.isPresent()){
             user = modelMapper.map(opUserEntity.get(), User.class);
        }else{
            throw new GenericBusinessException("User not found");
        }
        log.debug("After calling DAO method getUser()");
        return user;
    }

    @Override
    public User getUserByfbEmail(String email) throws GenericBusinessException{

        log.debug("Before calling DAO method getUser()");
        User user = null;
        Optional<UserEntity> opUserEntity = userRepository.findByEmail(email);
        if(opUserEntity.isPresent()){
            user = modelMapper.map(opUserEntity.get(), User.class);
        }else{
            throw new GenericBusinessException("User not found");
        }
        log.debug("After calling DAO method getUser()");
        return user;
    }

    @Override
    public void addUser(User user) throws GenericBusinessException
    {
        if(user == null){
            log.debug("User is null");
            throw new GenericBusinessException("User is Null");
        }
        log.debug("Before calling DAO method addUser()");
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity = userRepository.save(userEntity);
        log.debug("After calling DAO method getUser()");

    }

    @Override
    public String getLevelId(int userId) throws GenericBusinessException{
        log.debug("Before calling DAO method getUser()");
        User user = null;
        Optional<UserEntity> opUserEntity = userRepository.findById(userId);
        if(opUserEntity.isPresent()){
            user = modelMapper.map(opUserEntity.get(), User.class);
            return user.getLevelTitle();
        }else{
            throw new GenericBusinessException("User not found");
        }
    }

    @Override
    public String getCountryCallingCode(String countryCode) {
        log.debug("Before calling DAO method getUser()");

       Optional<CountryEntity> countryEntity =  countryRepository.findById(countryCode);
        if(countryEntity.isPresent()){
            return countryEntity.get().getCountryName();
        }
        return  null;
    }

    @Override
    public void updateUser(User user) throws GenericBusinessException{
        log.debug("Before calling DAO method getUser()");
        Optional<UserEntity> optionalUser = userRepository.findById(user.getUserId());
        if(optionalUser.isPresent()){
            UserEntity newUser = modelMapper.map(user, UserEntity.class);
            newUser.setUserId(optionalUser.get().getUserId());
            userRepository.save(newUser);
        }else{
            throw new GenericBusinessException("User not Exists");
        }
        log.debug("Before calling DAO method getUser()");
    }

    @Override
    public void updatePassword(Integer userId, String newPassword) {
        log.debug("Before calling DAO method updatePassword()");
       Optional<UserEntity> optionalUser = userRepository.findById(userId);
       if(optionalUser.isPresent()){
           UserEntity userEntity = optionalUser.get();
           userEntity.setPassword(newPassword);
           userRepository.save(userEntity);
       }
        log.debug("After calling DAO method updatePassword()");

    }

    @Override
    public UserRole getUserRoleByUserId(Integer userId) {
        log.debug("Before calling DAO method updatePassword()");
        Optional<UserRoleEntity> optionalUserRole = userRoleRepository.findById(userId);
        if(optionalUserRole.isPresent()){
            UserRole userRole = modelMapper.map(optionalUserRole.get(),UserRole.class);
            return userRole;
        }
        log.debug("After calling DAO method updatePassword()");
        return null;
    }

    @Override
    public void addUserMail(UserMail user, HttpServletRequest request) {

    }

    @Override
    public void updateUserMail(UserMail user) {

    }

    @Override
    public void activateUserMail(String verHash, Integer userId) {

    }

    @Override
    public UserMail getUserMailDetailsByUserId(Integer userId) {
        return  null;
    }

    @Override
    public UserMail getUserMailDetailsByVerCode(Integer verCode) {
        return null;
    }

    @Override
    public User getUserByUserId(Integer userId) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            return modelMapper.map(optionalUser.get(), User.class);
        }
        return null;
    }

    @Override
    public List<SecurityQuestion> getAllSecurityQuestions() {
        return null;
    }

    @Override
    public SMSInterface getSmsInterface() {
        return null;
    }

    @Override
    public void setSmsInterface(SMSInterface smsInterface) {

    }

    @Override
    public String paymentRequest(Payment payment) throws IOException {
        return null;
    }

    @Override
    public void upgradeUser(Integer userId) {
        log.debug("Before calling DAO method upgradeUser");
        Optional<UserRoleEntity> optionalUserRole = userRoleRepository.findById(userId);
        if(optionalUserRole.isPresent()) {
            UserRoleEntity userRoleEntity = optionalUserRole.get();
            userRoleEntity.setRoleCode("BIZADMIN");
            userRoleRepository.save(userRoleEntity);
        }
        log.debug("After calling DAO method upgradeUser");
    }

    @Override
    public void activateBusiness(Integer userId) {

    }

    @Override
    public String getBusinessExpiryDate(Integer userId) {
        return null;
    }

    @Override
    public String getIncrementedExpiryDate(Integer userId) {
        return null;
    }

    @Override
    public List<TimeZones> getTimeZonesByCountryCode(String countryCode) {
        return null;
    }

    @Override
    public List<UpgradeOptions> getUpgradeOptions() {
        return null;
    }

    @Override
    public void addPaymentDetailsForUpgaradeUser(Payment payment) {

    }

    @Override
    public List<PaymentModes> getPaymentModes() {
        return null;
    }

    @Override
    public UserPayments getUserPaymentDetails(Integer userId) {
        return null;
    }

    @Override
    public void addPaymentDetails(UserPayments userPayments) {

    }

    @Override
    public List<Business> getLatestRegisteredBusiness() {
        return null;
    }

    @Override
    public Integer checkEmailIdExists(String email) {
        return null;
    }

    @Override
    public Integer checkUserSecurityAnswer(Integer securityQuestion1, String answer1, String email, HttpServletRequest request) {
        return null;
    }

    @Override
    public void updateUserLoginDt(Integer userId) {

    }

    @Override
    public Integer updateLoginAttempts(String email) {
        return null;
    }

    @Override
    public void resetLoginCounter(Integer userId) {

    }

    @Override
    public void resetPassword(String email, String password) {

    }

    @Override
    public SecurityQuestion getRandomUserSecurityQuestion(String email) {
        return null;
    }

    @Override
    public int addUnregisteredUserDetails(UnregisteredUser unregisteredUser) {
        return 0;
    }

    @Override
    public User getUserByEmailId(String email) {
        return null;
    }

    @Override
    public void updateUserRole(String roleCode, Integer userId) {

    }

    @Override
    public void sendContactUsMail(String[] recipientIds, String name, String userEmailId, String phoneNumber, String reason, String comment, String requestPath) {

    }

    @Override
    public void sendAlertMail(List<AppointmentSchedule> appts, String requestPath) {

    }

    @Override
    public void sendAlertSMS(List<AppointmentSchedule> appts) {

    }

    @Override
    public void sendPromtionMail(String[] recipientIds, Promotion promotion, int noOfRecipientIds, String requestPath) {

    }

    @Override
    public int checkBusinessLimit(int userId) {
        return 0;
    }

    @Override
    public int getBusinessesForPricing(int userId) {
        return 0;
    }

    @Override
    public Integer checkLocationLimit(Integer userId) {
        return null;
    }

    @Override
    public Integer getLocationsForPricing(Integer userId) {
        return null;
    }

    @Override
    public Integer checkResourceLimit(Integer userId) {
        return null;
    }

    @Override
    public Integer getResourceForPricing(Integer userId) {
        return null;
    }

    @Override
    public Integer checkExpiryDate(Integer userId) {
        return null;
    }

    @Override
    public Integer expiryDateWithoutAdding(Integer userId) {
        return null;
    }

    @Override
    public List<PaymentHistory> acctPaymentHistory(Integer userId) {
        return null;
    }

    @Override
    public PaymentHistory getPaymentPackageDetails(int levelId) {
        return null;
    }

    @Override
    public List<Business> getUserBusinessUserId(Integer userId) {
        return null;
    }

    @Override
    public WeakHashMap<String, Object> getStaffWorkingBizId(Integer userId) {
        return null;
    }

    @Override
    public User getUserPaymentDetailsByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<PaymentHistory> getUserSubscriptionByUserId(Integer userId) {
        return null;
    }

    @Override
    public HashMap<String, String> getActiveBusinesses(Integer userId) {
        return null;
    }

    @Override
    public User getApptUserInfo(String userTblName, int apptHolderId, String colName) {
        return null;
    }

    @Override
    public UnregisteredUser getUnregisteredUserDetails(Integer unregisteredUserId) {
        return null;
    }
}
