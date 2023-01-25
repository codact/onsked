package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ResourceCertificate implements Serializable {
	private static final long serialVersionUID = 7566175277644621573L;
	private Integer resCertId;
	private Integer resId;
	private String certificateNumber;
	private String certificateName;
	private String certificateCompletionDate;
	private String certificateExpirationDate;
	private String certificateOrganization;

}
