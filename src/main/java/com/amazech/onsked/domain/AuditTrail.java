package com.amazech.onsked.domain;

import java.io.Serializable;

import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Data
public class AuditTrail implements Serializable {
	protected final Log logger = LogFactory.getLog(getClass());
	private static final long serialVersionUID = -2658809376558646712L;
	
	private String fromValue;
	private String toValue;
	private String description;
	private String modifiedBy;
	private String modifiedDt;

}
