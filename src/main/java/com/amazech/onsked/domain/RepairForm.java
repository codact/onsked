package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RepairForm implements Serializable{
	
	private static final long serialVersionUID = 4861059402831272480L;
	
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private String addressLine1;
	private String serviceName;
	private String cellPhone;
	private String phoneCarrierId;
	private String optDeviceUnlock;
	private String passcode;
	private String unlockPattern;
	private Integer technicianId;
	private String phoneCarrierOtherName;
	private String productModelOtherName;
	private String createdBy;
	private String createdDt;
	private String modifiedBy;
	private String modifiedDt;
	private String productModelId;
	private String productRepairId;
	private String productModelType;
	private String apptId;
	private String custAuthEstimate;
	private String productPassword;
	private String productAddOn;
	private String imei;
	private String comments;
	private String deliveryDate;
	private String deliveryTime;
	private String deliveryDateTime;
	
//	private List<ProductIssue> productIssueList = ListUtils.lazyList(new ArrayList<ProductIssue>(), FactoryUtils.instantiateFactory(ProductIssue.class));
	
	private String isActive;
	private String pickUp;
	private String signatureJson;	
	private byte[] sigJson;
	

}
