package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name="user_master")
public class UserEntity {
    @Id
    private Integer userId;
    private String email;
    private String password;
    private String passwordConfirm;
    private String firstName;
    private String stateName;
    private String countryName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String dateOfBirthAsYYYYMMDD;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String stateCode;
    private String zipCode;
    private String countryCode;
    private String timeZoneCode;
    private String timezone;
    private String cellPhone;
    private String homePhone;
    private String workPhone;
    private String workPhoneExt;
    private Integer securityQuestion1;
    private Integer securityQuestion2;
    private Date appointmentLastSync;
    private String answer1;
    private String answer2;
    private String verificationCode;
    private String isVerified;
    private String verificationDt;
    private String isActive;
    private Date lastLoginDt;
    private Date createdDt;
    private Date modifiedDt;
    private Integer newBizId;
    // Fields needed for 'Change Password' screen
    private String isPasswordScreen;
    private String isAddOrEditScreen;
    private String oldPassword;
    // Fields required for 'Forgot Password' Screen
    private String isResetPasswordScreen;
    //Fields required for 'Add Business Client Screen'
    private String isAddClientScreen;


    //From UserRole
    private String roleCode;

    //	fields for email verification
    //private String userName;
    private String verCode;
    private String verificationType;
    private String registrationDt;
    private String lastLoginDate;
    private String activated;
    private String activationDt;
    private Integer bizId;
    private String acceptTerms;
    private Boolean acceptTermsFlag;

    //upgrade option
    private String levelTitle;
    private Integer periodYears;
    private Integer periodMonths;
    private Integer periodDays;
    private String paymentDt;
    private Integer limitResources;
    private Integer limitBusinesses;
    private Integer limitLocations;
    private Integer limitAppointments;
    private Integer levelId;


    //user appt payment
    private Integer amount;

}
