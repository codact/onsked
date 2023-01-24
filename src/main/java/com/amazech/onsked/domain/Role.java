package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
	private static final long serialVersionUID = -8837777509472209259L;
	private String roleCode;
	private String roleName;
	private String description;

}