package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class TechnicianFormComments implements Serializable{
	
	private static final long serialVersionUID = -5836444531324597815L;
	private String commentsId;
	private String comments;
	private String apptId;
	private String techFormId;
	private String resRoleCode;
	private Integer userId;
	private String createdDate;
	private Integer createdBy;
	private String userFirstName;
	private String userLastName;
	private String formStatusCode;

}
