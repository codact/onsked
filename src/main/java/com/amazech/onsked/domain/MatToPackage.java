package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class MatToPackage implements Serializable{

	private static final long serialVersionUID = 1L;
	//package, loc_svc_id, material_id, qty_needed
	private Integer pkgNumber;
	private String materialId;
	private String matName;
	private String qtyNeeded;
	private Map<Integer, String> matList = null;


}