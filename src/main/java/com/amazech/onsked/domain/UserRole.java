package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {
	private static final long serialVersionUID = 3304375501668875196L;
	private Integer userId;
	private String roleCode;

}
