package com.onlineadmission.pojo;

import java.util.List;

import javax.validation.constraints.NotNull;

 

public class BranchPojo {
	
	private int branchId;
	@NotNull(message="Branch Name should not ne null")
	private String branchName;
	private String branchDescription;
	private List<CoursePojo> coursePojo ;
	
	public BranchPojo() {
		super();
	}
	
	public BranchPojo(int branchId, String branchName, String branchDescription, List<CoursePojo> coursePojo) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchDescription = branchDescription;
		this.coursePojo = coursePojo;
	}
	
	public int getBranchId() {
		return branchId;
	}
	
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public String getBranchDescription() {
		return branchDescription;
	}
	
	public void setBranchDescription(String branchDescription) {
		this.branchDescription = branchDescription;
	}
	
	public List<CoursePojo> getCoursePojo() {
		return coursePojo;
	}
	
	public void setCoursePojo(List<CoursePojo> coursePojo) {
		this.coursePojo = coursePojo;
	}
	
	@Override
	public String toString() {
		return "BranchPojo [branchId=" + branchId + ", branchName=" + branchName + ", branchDescription="
				+ branchDescription + ", coursePojo=" + coursePojo + "]";
	}
	
}
