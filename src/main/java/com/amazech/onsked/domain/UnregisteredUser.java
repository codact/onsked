package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class UnregisteredUser implements Serializable {
	private static final long serialVersionUID = -9212147997979392362L;
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private String dateOfBirthAsYYYYMMDD;
	private String email;
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
	
	private int unregId;

}