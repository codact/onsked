package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductPartsUsed implements Serializable{
	
	private static final long serialVersionUID = 4861059402831272480L;
		
	private String techFormId;
	private String partsUsedId;
	private String partsUsedName;
	private String productPartId;
	private String productPartName;
	private String bizId;
	private String locId;
	private String createdBy;
	private String createdDt;
	private String modifiedBy;
	private String modifiedDt;


}
