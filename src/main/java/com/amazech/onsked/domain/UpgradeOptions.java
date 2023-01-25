package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpgradeOptions implements Serializable{
	private static final long serialVersionUID = 8205655836817770393L;
	private Integer levelId;
	private String levelDesc;
	private String levelTitle;
	private String cost;
	private Integer periodYears;
	private Integer periodMonths;
	private Integer periodDays;
	private Integer limitResources;
	private Integer limitBusinesses;
	private Integer limitLocations;
	private char isActive;

}