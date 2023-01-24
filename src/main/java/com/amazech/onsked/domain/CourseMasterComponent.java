package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseMasterComponent implements Serializable {

	private static final long serialVersionUID = 342834125567005591L;
	
	private Integer courseMasterComponentId;
	private Integer courseMasterId;
	private Integer locId;
	private String locName;
	private Integer locApptGranularity;
	private Integer svcId;
	private String svcName;
	private Integer productId;
	private String productName;
	private String productSessionType;
	private Integer productDuration;
	private String productClientLocation;

}
