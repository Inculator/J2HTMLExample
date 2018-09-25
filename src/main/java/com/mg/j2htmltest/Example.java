package com.mg.j2htmltest;

import java.io.Serializable;
import java.util.List;

public class Example implements Serializable {

	private static final long serialVersionUID = 1L;

	private String subType;
	private boolean timeBased;
	private boolean dataDriven;
	private Integer versionNumber;
	private List<String> steps;

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public boolean isTimeBased() {
		return timeBased;
	}

	public void setTimeBased(boolean timeBased) {
		this.timeBased = timeBased;
	}

	public boolean isDataDriven() {
		return dataDriven;
	}

	public void setDataDriven(boolean dataDriven) {
		this.dataDriven = dataDriven;
	}

	public Integer getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}
}
