package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;


@Data
public class Materials implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer matId;
	private String matName;
	private Integer bizId;
	private String manufacturer;
	private Boolean disposableFlag;
	private String disposable;
	private String cost;
	private String createdDate;
	private String modifiedDate;
	private Map<Integer, String> matList = null;
	
//	private List<MatToPackage> matToPackage = ListUtils.lazyList(new ArrayList<MatToPackage>(), FactoryUtils.instantiateFactory(MatToPackage.class));


}