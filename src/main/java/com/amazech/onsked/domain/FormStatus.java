package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class FormStatus implements Serializable{
	
	private static final long serialVersionUID = 4861059402831272480L;
	
	private String formStatusCode;
	private String formStatusName;
	private String resRoleCode;
	

}
