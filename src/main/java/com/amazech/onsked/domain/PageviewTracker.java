package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageviewTracker implements Serializable {
	private static final long serialVersionUID = 4861059402831272480L;
	private String pageName;
	private Integer userId;
	private String visitedOn;
	private String bizId;
	
	// Business
	private String bizName;
	private Integer count;

}