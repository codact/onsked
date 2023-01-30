package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name="user_upgrade_levels")
public class UpgradeOptionsEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
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