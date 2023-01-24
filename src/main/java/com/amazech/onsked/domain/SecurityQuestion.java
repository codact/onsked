package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SecurityQuestion implements Serializable {
	private static final long serialVersionUID = 5578931296495124011L;
	private Integer questionId;
	private String question;

}