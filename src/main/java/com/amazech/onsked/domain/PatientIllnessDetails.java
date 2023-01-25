package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class PatientIllnessDetails implements Serializable {
	private static final long serialVersionUID = 2313663245479072264L;
	private List<String> illnessDescription; 
	private List<Integer> illnessId;
//	private List<PatientIllness> illnessList = ListUtils.lazyList(new ArrayList<PatientIllness>(), FactoryUtils.instantiateFactory(PatientIllness.class));

}