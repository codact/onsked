package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class GenCalendar implements Serializable {
	private static final long serialVersionUID = -8347191328483049549L;
	private String date;
	private Integer start;
	private Integer end;
	private Integer open;
	private String dayDesc;
	private Integer dayOfWeek;
	private String tmZoneOverflow;
	private Integer overflowUpto;

}

