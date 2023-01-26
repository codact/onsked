package com.amazech.onsked.service;

import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.GenericBusinessException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

public interface UserSvc {
    // Get user details from the database given email and password
    User getUser(String email, String password) throws GenericBusinessException;

    // Get user details from the database given email
    User getUserByfbEmail(String email) throws GenericBusinessException;

    // Add a new user to the database
    void addUser(User user) throws GenericBusinessException;

    String getLevelId(int userId) throws GenericBusinessException;

    String getCountryCallingCode(String countryCode);

    // Update user's details
    void updateUser(User user) throws GenericBusinessException;

    // Update user's password
    void updatePassword(Integer userId, String newPassword);

    // Get user Role details by UserId
    UserRole getUserRoleByUserId(Integer userId);

    //	 Add a new user to the database
    void addUserMail(UserMail user, HttpServletRequest request);

    // Update user's details
    void updateUserMail(UserMail user);

    // Update user's details
    void activateUserMail(String verHash,Integer userId);

    //Get User Mail details by userId
    UserMail getUserMailDetailsByUserId(Integer userId);

    //Get User Mail details by verification Code
    UserMail getUserMailDetailsByVerCode(Integer verCode);

    //	 Get user Role details by UserId
    User getUserByUserId(Integer userId);

    //Get all User Sign Up Security Questions
    List<SecurityQuestion> getAllSecurityQuestions();

    //For User SMS verification

    //Get SMS interface
    public SMSInterface getSmsInterface();

    //Set SMS Interface
    public void setSmsInterface(SMSInterface smsInterface);

    //------For User Payment-----------

    //Request for the Payment to PayPal
    String paymentRequest(Payment payment) throws IOException;

    //Upgrade User (Change User Role)
    void upgradeUser(Integer userId);

    void activateBusiness(Integer userId);

    String getBusinessExpiryDate(Integer userId);

    String getIncrementedExpiryDate(Integer userId);

    // get the latest registered business
    List<TimeZones> getTimeZonesByCountryCode(String countryCode);

    //Get user Upgrade Options
    List<UpgradeOptions> getUpgradeOptions();

    //Add Payment details for the User
    void addPaymentDetailsForUpgaradeUser(Payment payment);

    //Get the Payment Modes available for User Upgrade
    List<PaymentModes> getPaymentModes();

    //Get User Payment details by User Id
    UserPayments getUserPaymentDetails(Integer userId);

    //Add Payment details for the User using PayPal as the Payment Mode
    void addPaymentDetails(UserPayments userPayments);

    //Get all User Sign Up Security Qusetions
    List<Business> getLatestRegisteredBusiness() ;

    //Check if a user exists with the email Id entered
    Integer checkEmailIdExists(String email);

    //Check User Security Question ,answer with respect to the email Id
    Integer checkUserSecurityAnswer(Integer securityQuestion1, String answer1,String email, HttpServletRequest request);

    //Update Current Login Date for User
    void updateUserLoginDt(Integer userId);

    //Update login attempts information for user, by emailId
    Integer updateLoginAttempts(String email);

    //Reset Failed Login attempts counter
    void resetLoginCounter(Integer userId);

    //Reset user password by email Id
    void resetPassword(String email, String password);

    //Get Random Security Question for the User
    SecurityQuestion getRandomUserSecurityQuestion(String email);

    //Add Unregistered user details
    int addUnregisteredUserDetails(UnregisteredUser unregisteredUser);

    //Get the user details using email id
    User getUserByEmailId(String email);

    //Update user role
    void updateUserRole(String roleCode,Integer userId);

    //Method to send user's contact us mail to the business admin
    void sendContactUsMail(String[] recipientIds, String name, String userEmailId,
                           String phoneNumber, String reason, String comment,String requestPath);

    void sendAlertMail(List<AppointmentSchedule> appts,String requestPath);

    void sendAlertSMS(List<AppointmentSchedule> appts);

    //send promotion Mail
    void sendPromtionMail(String[] recipientIds, Promotion promotion, int noOfRecipientIds, String requestPath);

    int checkBusinessLimit(int userId);

    int getBusinessesForPricing(int userId);

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

    //Get the business the user working for
    WeakHashMap<String, Object> getStaffWorkingBizId(Integer userId);

    //get user details and current plan
    User getUserPaymentDetailsByUserId(Integer userId);

    //get user subscription
    List<PaymentHistory> getUserSubscriptionByUserId(Integer userId);

    HashMap<String, String> getActiveBusinesses(Integer userId);

    //get appointment user info
    User getApptUserInfo(String userTblName, int apptHolderId, String colName);

    //get Unregistered User Details
    UnregisteredUser getUnregisteredUserDetails(Integer unregisteredUserId);
}

