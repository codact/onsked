package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductHardwareIssue implements Serializable{
	
	private static final long serialVersionUID = 4861059402831272480L;
		
	private String techFormId;
	private String techFormIssueId;
	private String productHardwareIssueName;
	private String issueId;
	private String isPresentBefore;
	private String isPresentAfter;
	private String createdBy;
	private String createdDt;
	private String modifiedBy;
	private String modifiedDt;

}
