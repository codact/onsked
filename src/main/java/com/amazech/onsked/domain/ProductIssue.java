package com.amazech.onsked.domain;

import lombok.Data;

@Data
public class ProductIssue {
	private static final long serialVersionUID = -5836444531324597815L;
	
	private String productIssueId;
	private String productIssueName;
	private String productIssue;
	private String repairFormId;
	private String createdBy;
	private String createdDt;
	private String modifiedBy;
	private String modifiedDt;

}
