package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupPackagePurchase implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer groupPkgPurchaseId;
	private String groupPkgId;
	private String userId;
	private String expiryDt;
	private String purchaseDt;

}
