package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Stocks implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer matId;
	
	private Integer locId;
	private Integer qty;
	private String enteredDt;
	private String matName;
	private String manufacturer;

}