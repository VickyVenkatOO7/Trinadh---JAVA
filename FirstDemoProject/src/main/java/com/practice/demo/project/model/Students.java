package com.practice.demo.project.model;

public class Students {
	private int stdId;
	private String stdName;
	private String stdTech;
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdTech() {
		return stdTech;
	}
	public void setStdTech(String stdTech) {
		this.stdTech = stdTech;
	}
	@Override
	public String toString() {
		return "Students [stdId=" + stdId + ", stdName=" + stdName + ", stdTech=" + stdTech + "]";
	}
}
