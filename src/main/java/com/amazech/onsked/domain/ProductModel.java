package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductModel implements Serializable{
	private static final long serialVersionUID = -5836444531324597815L;
	private String productModelId;
	private String productModelName;
	private String productModelTypeId;

}
