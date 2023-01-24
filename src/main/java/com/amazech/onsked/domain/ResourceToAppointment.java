package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class ResourceToAppointment implements Serializable {
	private static final long serialVersionUID = 2904038699109899796L;
	private Integer resId;
	private String name;
	private Integer isAllDays;

}