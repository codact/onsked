package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class TimeZones implements Serializable {
	private static final long serialVersionUID = 7767407362378390975L;
	private String timeZoneCode;
	private String description;
	private String countryCode;
	private String timeZone;

}