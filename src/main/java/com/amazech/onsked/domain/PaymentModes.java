package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaymentModes implements Serializable {
	private static final long serialVersionUID = 7958214614150912447L;
	private Integer modeId;
	private String mode;
	private String isActive;

}