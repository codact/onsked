package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class LeaveReason implements Serializable {
	private static final long serialVersionUID = 1212327877876893616L;
	private String leaveCode;
	private String description;

	
}
