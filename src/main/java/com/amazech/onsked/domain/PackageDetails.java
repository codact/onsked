package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class PackageDetails implements Serializable {
	private static final long serialVersionUID = 2313663245479072264L;
	private List<String> duration; 
//	private List<Package> packages = ListUtils.lazyList(new ArrayList<Package>(), FactoryUtils.instantiateFactory(Package.class));
//	private List<Package> editPackages = ListUtils.lazyList(new ArrayList<Package>(), FactoryUtils.instantiateFactory(Package.class));
	private List<String> packageName;
	private String clientLocation;
	private Boolean clientLocationFlag;

	
}