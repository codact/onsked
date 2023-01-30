package com.amazech.onsked.service.impl;

import com.amazech.onsked.dao.entity.CategoryEntity;
import com.amazech.onsked.dao.entity.CountryEntity;
import com.amazech.onsked.dao.entity.UserEntity;
import com.amazech.onsked.dao.entity.UserRoleEntity;
import com.amazech.onsked.dao.mapper.UserMapper;
import com.amazech.onsked.dao.repo.CountryRepository;
import com.amazech.onsked.dao.repo.UserRepository;
import com.amazech.onsked.dao.repo.UserRoleRepository;
import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.DataAccessException;
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

    @Autowired
    UserMapper userMapper;
    @Override
    public User getUser(String email, String password) throws GenericBusinessException{
        log.debug("Before calling DAO method getUser()");
        User user = null;
        Optional<UserEntity> opUserEntity = userRepository.findByEmailAndPassword(email, password);
        if(opUserEntity.isPresent()){
             user = modelMapper.map(opUserEntity.get(), User.class);
        }
        log.debug("After calling DAO method getUser()");
        return user;
    }

    @Override
    public User getUserByfbEmail(String email) throws GenericBusinessException {
        return null;
    }

    @Override
    public User getUserByEmailId(String email) throws GenericBusinessException{

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
    public Integer addUser(User user) throws GenericBusinessException
    {
        if(user == null){
            log.debug("User is null");
            throw new GenericBusinessException("User is Null");
        }
        log.debug("Before calling DAO method addUser()");
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity = userRepository.save(userEntity);
        log.debug("After calling DAO method getUser()");
        return userEntity.getUserId();

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
    public void addUserMail(UserMail user, HttpServletRequest request) throws DataAccessException {
        log.debug("Before calling DAO method addUserMail");
        userMapper.addUserMail(user, request);

    }

    @Override
    public void updateUserMail(UserMail user) {
        log.debug("Before calling DAO method updateUserMail");
        userMapper.updateUserMail(user);
    }

    @Override
    public void activateUserMail(String verHash, Integer userId) {
        log.debug("Before calling DAO method activateUserMail");
        userMapper.activateUserMail(verHash, userId);
    }

    @Override
    public UserMail getUserMailDetailsByUserId(Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method getUserMailDetailsByUserId");
        return userMapper.getUserMailDetailsByUserId(userId);
    }

    @Override
    public UserMail getUserMailDetailsByVerCode(Integer verCode) throws DataAccessException {
        log.debug("Before calling DAO method getUserMailDetailsByVerCode");
        return userMapper.getUserMailDetailsByVerCode(verCode);
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
    public List<SecurityQuestion> getAllSecurityQuestions() throws DataAccessException {
        log.debug("Before calling DAO method getAllSecurityQuestions");
        return userMapper.getAllSecurityQuestions();
    }

    @Override
    public SMSInterface getSmsInterface() {
        log.debug("Before calling DAO method getSmsInterface");
        return null;
    }

    @Override
    public void setSmsInterface(SMSInterface smsInterface) {
        log.debug("Before calling DAO method setSmsInterface");
    }

    @Override
    public String paymentRequest(Payment payment) throws IOException {
        log.debug("Before calling DAO method paymentRequest");
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
    public void activateBusiness(Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method activateBusiness");
        userMapper.activateBusiness(userId);
        log.debug("After calling DAO method activateBusiness");
    }

    @Override
    public String getBusinessExpiryDate(Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method getBusinessExpiryDate");
        return userMapper.getBusinessExpiryDate(userId);
    }

    @Override
    public String getIncrementedExpiryDate(Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method getIncrementedExpiryDate");
        return userMapper.getIncrementedExpiryDate(userId);
    }

    @Override
    public List<TimeZones> getTimeZonesByCountryCode(String countryCode) throws DataAccessException {
        log.debug("Before calling DAO method getIncrementedExpiryDate");
        return userMapper.getTimeZonesByCountryCode(countryCode);
    }

    @Override
    public List<UpgradeOptions> getUpgradeOptions() throws DataAccessException {
        log.debug("Before calling DAO method getUpgradeOptions");
        return userMapper.getUpgradeOptions();
    }

    @Override
    public void addPaymentDetailsForUpgaradeUser(Payment payment) throws DataAccessException {
        log.debug("Before calling DAO method addPaymentDetailsForUpgaradeUser");
         userMapper.addPaymentDetailsForUpgaradeUser(payment);
        log.debug("After calling DAO method getUpgradeOptions");

    }

    @Override
    public List<PaymentModes> getPaymentModes() throws DataAccessException {
        log.debug("Before calling DAO method addPaymentDetailsForUpgaradeUser");
        return userMapper.getPaymentModes();
    }

    @Override
    public UserPayments getUserPaymentDetails(Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method addPaymentDetailsForUpgaradeUser");
        return userMapper.getUserPaymentDetails(userId);
    }

    @Override
    public void addPaymentDetails(UserPayments userPayments) throws DataAccessException {
        log.debug("Before calling DAO method addPaymentDetailsForUpgaradeUser");
         userMapper.addPaymentDetails(userPayments);
        log.debug("After calling DAO method addPaymentDetailsForUpgaradeUser");
    }

    @Override
    public List<Business> getLatestRegisteredBusiness() throws DataAccessException {
        log.debug("Before calling DAO method getLatestRegisteredBusiness");
        return userMapper.getLatestRegisteredBusiness();
    }

    @Override
    public Integer checkEmailIdExists(String email) throws DataAccessException {
        log.debug("Before calling DAO method getLatestRegisteredBusiness");
        return userMapper.checkEmailIdExists(email);
    }

    @Override
    public Integer checkUserSecurityAnswer(Integer securityQuestion1, String answer1, String email, HttpServletRequest request) throws DataAccessException {
        log.debug("Before calling DAO method checkUserSecurityAnswer");
        return userMapper.checkUserSecurityAnswer(securityQuestion1, answer1, email, request);
    }


    @Override
    public void updateUserLoginDt(Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method updateUserLoginDt");
        userMapper.updateUserLoginDt(userId);
    }

    @Override
    public Integer updateLoginAttempts(String email) throws DataAccessException {
        log.debug("Before calling DAO method updateLoginAttempts");
        return userMapper.updateLoginAttempts(email);
    }

    @Override
    public void resetLoginCounter(Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method resetLoginCounter");
        userMapper.resetLoginCounter(userId);
    }

    @Override
    public void resetPassword(String email, String password) throws DataAccessException {
        log.debug("Before calling DAO method resetPassword");
        userMapper.resetPassword(email, password);
    }

    @Override
    public SecurityQuestion getRandomUserSecurityQuestion(String email) throws DataAccessException {
        log.debug("Before calling DAO method getRandomUserSecurityQuestion");
        return userMapper.getRandomUserSecurityQuestion(email);
    }

    @Override
    public int addUnregisteredUserDetails(UnregisteredUser unregisteredUser) throws DataAccessException {
        log.debug("Before calling DAO method addUnregisteredUserDetails");
        return userMapper.addUnregisteredUserDetails(unregisteredUser);
    }



    @Override
    public void updateUserRole(String roleCode, Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method updateUserRole");
         userMapper.updateUserRole(roleCode, userId);
    }

    @Override
    public void sendContactUsMail(String[] recipientIds, String name, String userEmailId, String phoneNumber, String reason, String comment, String requestPath) {
        log.debug("Before calling DAO method sendContactUsMail");
        userMapper.sendContactUsMail(recipientIds, name, userEmailId, phoneNumber, reason, comment, requestPath);
    }

    @Override
    public void sendAlertMail(List<AppointmentSchedule> appts, String requestPath) {
        log.debug("Before calling DAO method sendAlertMail");
        userMapper.sendAlertMail(appts,  requestPath);
    }

    @Override
    public void sendAlertSMS(List<AppointmentSchedule> appts) {
        log.debug("Before calling DAO method sendAlertSMS");
        userMapper.sendAlertSMS(appts);
    }

    @Override
    public void sendPromtionMail(String[] recipientIds, Promotion promotion, int noOfRecipientIds, String requestPath) {
        log.debug("Before calling DAO method sendPromtionMail");
        userMapper.sendPromtionMail(recipientIds, promotion, noOfRecipientIds, requestPath);
    }

    @Override
    public int checkBusinessLimit(int userId) {
        log.debug("Before calling DAO method checkBusinessLimit");
       return userMapper.checkBusinessLimit(userId);
    }

    @Override
    public int getBusinessesForPricing(int userId) {
        log.debug("Before calling DAO method getBusinessesForPricing");
        return userMapper.getBusinessesForPricing(userId);
    }

    @Override
    public Integer checkLocationLimit(Integer userId) {
        log.debug("Before calling DAO method checkLocationLimit");
        return userMapper.checkLocationLimit(userId);
    }

    @Override
    public Integer getLocationsForPricing(Integer userId) {
        log.debug("Before calling DAO method getLocationsForPricing");
        return userMapper.getLocationsForPricing(userId);
    }

    @Override
    public Integer checkResourceLimit(Integer userId) {
        log.debug("Before calling DAO method checkResourceLimit");
        return userMapper.checkResourceLimit(userId);
    }

    @Override
    public Integer getResourceForPricing(Integer userId) {
        log.debug("Before calling DAO method getResourceForPricing");
        return userMapper.getResourceForPricing(userId);
    }

    @Override
    public Integer checkExpiryDate(Integer userId) {
        log.debug("Before calling DAO method checkExpiryDate");
        return userMapper.checkExpiryDate(userId);
    }

    @Override
    public Integer expiryDateWithoutAdding(Integer userId) {
        log.debug("Before calling DAO method expiryDateWithoutAdding");
        return userMapper.expiryDateWithoutAdding(userId);
    }

    @Override
    public List<PaymentHistory> acctPaymentHistory(Integer userId) {
        log.debug("Before calling DAO method acctPaymentHistory");
        return userMapper.acctPaymentHistory(userId);
    }

    @Override
    public PaymentHistory getPaymentPackageDetails(int levelId) {
        log.debug("Before calling DAO method getPaymentPackageDetails");
        return userMapper.getPaymentPackageDetails(levelId);
    }

    @Override
    public List<Business> getUserBusinessUserId(Integer userId) {
        log.debug("Before calling DAO method getUserBusinessUserId");
        return userMapper.getUserBusinessUserId(userId);
    }

    @Override
    public WeakHashMap<String, Object> getStaffWorkingBizId(Integer userId) {
        log.debug("Before calling DAO method getStaffWorkingBizId");
        return userMapper.getStaffWorkingBizId(userId);
    }

    @Override
    public User getUserPaymentDetailsByUserId(Integer userId) {
        log.debug("Before calling DAO method getUserPaymentDetailsByUserId");
        return userMapper.getUserPaymentDetailsByUserId(userId);
    }

    @Override
    public List<PaymentHistory> getUserSubscriptionByUserId(Integer userId) {
        log.debug("Before calling DAO method getUserSubscriptionByUserId");
        return userMapper.getUserSubscriptionByUserId(userId);
    }

    @Override
    public HashMap<String, String> getActiveBusinesses(Integer userId) {
        log.debug("Before calling DAO method getActiveBusinesses");
        return userMapper.getActiveBusinesses(userId);
    }

    @Override
    public User getApptUserInfo(String userTblName, int apptHolderId, String colName) {
        log.debug("Before calling DAO method getApptUserInfo");
        return userMapper.getApptUserInfo(userTblName, apptHolderId, colName);
    }

    @Override
    public UnregisteredUser getUnregisteredUserDetails(Integer unregisteredUserId) {
        log.debug("Before calling DAO method getUnregisteredUserDetails");
        return userMapper.getUnregisteredUserDetails(unregisteredUserId);
    }
}
