package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserMail implements Serializable {
	private static final long serialVersionUID = 6750292436765441032L;
	private Integer userId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String cellPhone;
	private String verificationCode;
	private String smsVerificationCode;
	private String verificationType;
	private String registrationDate;
	private String lastLoginDate;
	private String activated;
	private String activationDate;

}