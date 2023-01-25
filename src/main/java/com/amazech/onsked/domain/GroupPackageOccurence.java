package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupPackageOccurence implements Serializable {
	private static final long serialVersionUID = -1925113716198170697L;
	private String groupPkgToPkgId;
	private String groupPkgId;
	private String pkgId;
	private String pkgName;
	private String occurences;
	private String isActive;
	private String isSelected;
	private String number;
}
