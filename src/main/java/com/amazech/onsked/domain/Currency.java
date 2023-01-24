package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Currency implements Serializable {
	private static final long serialVersionUID = 8516136148633671357L;
	private String countryCode;
	private String currencyCode;
	private String currencyName;
	private String symbol;


}
