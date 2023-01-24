package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResourceWorkingHours implements Serializable{
	private static final long serialVersionUID = -5670955251560627829L;
	private Integer open;
	private String start;
	private String end;
	private String resHrOvrFlw;
	private Integer resHrOvrFlwUpto;

}