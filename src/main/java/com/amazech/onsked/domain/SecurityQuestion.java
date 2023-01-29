package com.amazech.onsked.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityQuestion implements Serializable {
	private static final long serialVersionUID = 5578931296495124011L;
	private Integer questionId;
	private String question;

}