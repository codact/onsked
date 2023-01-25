package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Data
public class UserSession implements Serializable {
	private static final long serialVersionUID = -4126898894772724749L;
	private User user;
	private Business business;
	private Business businessListForAppt;
	private String bizList;
	private String staffBizId;

}
