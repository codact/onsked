package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class GroupPackage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String groupPkgId;
	private String pkgIds;
	private Integer bizId;
	private Integer svcId;
	private Integer locId;
	private String groupPkgName;
	private String groupPkgDesc;
	private String groupPkgCost;
	private String expiryDuration;
	private String bizName;
	private String locName;
	private String stateCode;
	private String groupPkgTypeId;
	private String groupPkgTypeName;
	private Integer groupPkgPurchaseId;
	private String discountNumber;


//	private List<GroupPackageOccurence> grpPkgOccurences = ListUtils.lazyList(new ArrayList<GroupPackageOccurence>(), FactoryUtils.instantiateFactory(GroupPackageOccurence.class));
	
	// grp pkg occurence details
	private String groupPkgToPkgId;
	private String pkgId;
	private String pkgName;
	private String occurences;
	private String isActive;
	private String isSelected;
	
	private String usedPkg;
	private String remaining;

}
