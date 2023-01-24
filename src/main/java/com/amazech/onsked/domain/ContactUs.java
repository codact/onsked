package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class ContactUs implements Serializable{
	private static final long serialVersionUID = 4233687461047904862L; 
	private String name;
	private String emailId;
	private String phoneNumber;
	private String reason;
	private String comment;
	
}