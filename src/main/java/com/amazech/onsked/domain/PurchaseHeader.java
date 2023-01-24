package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class PurchaseHeader implements Serializable{

	private static final long serialVersionUID = 1L;
	private String bizId; 
	private String bizName;
	private Integer purchaseId;
	private String purchaseDate;
	private String purchaseOreder;
	private String remark;
	private String totAmntIncludingTax;
	private String totTax;
	private Integer locId;
	private String locName;
	private String completed;
	private Integer matId;
	private String qty;
	private String rate;
	private String batchNumber;
	private String taxAmnt;
	private String amnt;
	private String matName;
	private String manufacturer;
	
//	protected List<PurchaseDetails> purchaseDetailsList = ListUtils.lazyList(new ArrayList<PurchaseDetails>(), FactoryUtils.instantiateFactory(PurchaseDetails.class));

}
