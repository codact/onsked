package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class OnskedACL implements Serializable {
	private static final long serialVersionUID = -5836444531324597815L;
	private String isSessionNeeded;
	private String isBizRoleNeeded;
	private String isAdminRoleNeeded;
	private String isResRoleNeeded;
	private String isReDirectionUrlNeeded;
	private String isInventoryNeeded;

}