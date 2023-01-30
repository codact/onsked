package com.amazech.onsked.dao.mapper;

import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.DataAccessException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

@Mapper
public interface UserMapper {
    // Get user details for given email and password
    User getUser(String email, String password) throws DataAccessException;


    // Get user details for given email
    User getUserByfbEmail(String email) throws DataAccessException;

    // Add new user to database
    void addUser(User user) throws DataAccessException;

    String getLevelId(int userId) throws DataAccessException;

    String getCountryCallingCode(String countryCode) throws DataAccessException;

    // Update user's details
    void updateUser(User user) throws DataAccessException;

    // Update user's password
    void updatePassword(Integer userId, String newPassword) throws DataAccessException;

    //Get User Mail details by userId
    UserMail getUserMailDetailsByUserId(Integer userId) throws DataAccessException;

    //Get User Mail details by verCode
    UserMail getUserMailDetailsByVerCode(Integer verCode) throws DataAccessException;

    // Get user Role details by UserId
    UserRole getUserRoleByUserId(Integer userId) throws DataAccessException;

    //	 Add new user to database
    void addUserMail(UserMail user, HttpServletRequest request) throws DataAccessException;


    // Update user's details
    void updateUserMail(UserMail user);

    // Update user's details
    void activateUserMail(String verHash,Integer userId);

    //	 Get user Role details by UserId
    User getUserByUserId(Integer userId) throws DataAccessException;

    //Get all User Sign Up Security Qusetions
    List<SecurityQuestion> getAllSecurityQuestions() throws DataAccessException;

    // get the timezones of country by country code
    List<TimeZones> getTimeZonesByCountryCode(String countryCode) throws DataAccessException;

    //Request for the Payment to PayPal
    String paymentRequest(Payment payment) throws DataAccessException, IOException;

    //Upgrade User (Change User Role)
    void upgradeUser(Integer userId) throws DataAccessException;

    void activateBusiness(Integer userId) throws DataAccessException;

    String getBusinessExpiryDate(Integer userId) throws DataAccessException;

    String getIncrementedExpiryDate(Integer userId) throws DataAccessException;

    //Get user Upgrade Options
    List<UpgradeOptions> getUpgradeOptions() throws DataAccessException;

    //Add Payment details for the User
    void addPaymentDetailsForUpgaradeUser(Payment payment) throws DataAccessException;

    //Get the Payment Modes available for User Upgrade
    List<PaymentModes> getPaymentModes() throws DataAccessException;

    //Get User Payment details by User Id
    UserPayments getUserPaymentDetails(Integer userId) throws DataAccessException;

    //Add Payment details for the User using PayPal as the Payment Mode
    void addPaymentDetails(UserPayments userPayments) throws DataAccessException;

    //Get all User Sign Up Security Qusetions
    List<Business> getLatestRegisteredBusiness() throws DataAccessException;

    //Check User Security Question ,answer with respect to the email Id
    Integer checkUserSecurityAnswer(Integer securityQuestion1, String answer1,String email, HttpServletRequest request) throws DataAccessException;

    //Update Current Login Date for User
    void updateUserLoginDt(Integer userId) throws DataAccessException;

    //Update login attempts information for user, by emailId
    Integer updateLoginAttempts(String email) throws DataAccessException;

    //Reset Failed Login attempts counter
    void resetLoginCounter(Integer userId) throws DataAccessException;

    //Reset user password by email Id
    void resetPassword(String email, String password) throws DataAccessException;

    //Get Random Security Question for the User
    SecurityQuestion getRandomUserSecurityQuestion(String email) throws DataAccessException;

    //Check if a user exists with the email Id entered
    Integer checkEmailIdExists(String email) throws DataAccessException;

    //Add Unregistered user details
    int addUnregisteredUserDetails(UnregisteredUser unregisteredUser) throws DataAccessException;

    //Get the user details using email id
    User getUserByEmailId(String email) throws DataAccessException;

    //Update user role
    void updateUserRole(String roleCode,Integer userId) throws DataAccessException;


    void sendContactUsMail(String[] recepientIds, String name,
                           String userEmailId, String phoneNumber, String reason,
                           String comment,String requestPath);


    void sendAlertMail(List<AppointmentSchedule> appts,String requestPath);

    void sendAlertSMS(List<AppointmentSchedule> appts);

    //send Promotion mail
    void sendPromtionMail(String[] recipientIds, Promotion promotion, int noOfRecipientIds, String requestPath);


    Integer checkBusinessLimit(int userId);

    Integer getBusinessesForPricing(int userId);

    Integer checkLocationLimit(Integer userId);

    Integer getLocationsForPricing(Integer userId);


    Integer checkResourceLimit(Integer userId);

    Integer getResourceForPricing(Integer userId);

    Integer checkExpiryDate(Integer userId);

    Integer expiryDateWithoutAdding(Integer userId);

    List<PaymentHistory> acctPaymentHistory(Integer userId);


    PaymentHistory getPaymentPackageDetails(int levelId);

    //Get all the business owned by the user
    List<Business> getUserBusinessUserId(Integer userId);

    //Get the business user working for
    WeakHashMap<String, Object> getStaffWorkingBizId(Integer userId);

    //get user details and current plan
    User getUserPaymentDetailsByUserId(Integer userId);

    //get user subscription
    List<PaymentHistory> getUserSubscriptionByUserId(Integer userId);


    HashMap<String, String> getActiveBusinesses(Integer userId);

    //get appointment user info
    User getApptUserInfo(String userTblName, int apptHolderId, String colName);

    //get unregistered user details
    UnregisteredUser getUnregisteredUserDetails(Integer unregisteredUserId);
}
