package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MasterIllness implements Serializable {
	private static final long serialVersionUID = 2313663245479072264L;
	private String illnessId;
	private String illnessName; 
	private String isActive;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;

}
