package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessEnhancementLog implements Serializable {
	private static final long serialVersionUID = -3837948809131379467L;
	
	private Integer bizEnhanId;
	private String bizEnhanName;
	private Integer bizId;
	private Integer userId;
	private String modifiedDt;
	private String flag;


}
