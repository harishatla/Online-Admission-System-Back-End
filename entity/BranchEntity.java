 package com.onlineadmission.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
public class BranchEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "branch_id")
	@SequenceGenerator(sequenceName ="BRANCH_SEQ",allocationSize = 1, name = "branch_id")
	@Column(name ="branch_id")
	private int branchId;
	
	@Column (name = "branch_name")
	private String branchName;
	
	@Column(name = "branch_description")
	private String branchDescription;
	
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "allBranches")
	private List<CourseEntity> course ;
	
	public BranchEntity() {
		super();
	}
	
	public BranchEntity(int branchId, String branchName, String branchDescription, List<CourseEntity> course) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchDescription = branchDescription;
		this.course = course;
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
	
	public List<CourseEntity> getCourse() {
		return course;
	}
	
	public void setCourse(List<CourseEntity> course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "BranchEntity [branchId=" + branchId + ", branchName=" + branchName + ", branchDescription="
				+ branchDescription + ", course=" + course + "]";
	}
		
}
