package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;


@Data
public class PurchaseDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer purchaseId;
	private Integer matId;
	private String qty;
	private String rate;
	private String batchNumber;
	private String taxAmnt;
	private String amnt;
	private String remark;
	private String matName;
	private String manufacturer;
	private String totAmntIncludingTax;
	private String totTax;
	private String purchaseDate;
	private String bizName;
	private String locName;
//	protected List<PurchaseDetails> purchaseDetailsList = ListUtils.lazyList(new ArrayList<PurchaseDetails>(), FactoryUtils.instantiateFactory(PurchaseDetails.class));

	

}