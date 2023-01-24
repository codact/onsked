package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class GenerateCalendar implements Serializable {
	private static final long serialVersionUID = -8849677601676103172L;
	private Integer resId;
	private Integer dayOfWeek;
	private String cellId;
	private String cellStyle;

	
}