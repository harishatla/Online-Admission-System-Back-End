 package com.onlineadmission.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_id")
	@SequenceGenerator(sequenceName ="COURSE_SEQ",allocationSize = 1, name = "course_id")
	@Column(name = "course_id")
	private  int courseId;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "eligibility")
	private  String eligibility;
	
	@ManyToOne
	@JoinColumn(name="college_Reg_Id")
	private CollegeEntity collegeEntity; 
	
	@ManyToMany
	@JoinTable(name = "course_branch", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = { @JoinColumn(name = "branch_id")})
	private List<BranchEntity>   allBranches = new ArrayList<>();
	
	public CourseEntity() {
		super();
	}

	public CourseEntity(int courseId, String courseName, String eligibility, CollegeEntity collegeEntity,
			List<BranchEntity> allBranches) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.eligibility = eligibility;
		this.collegeEntity = collegeEntity;
		this.allBranches = allBranches;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public CollegeEntity getCollegeEntity() {
		return collegeEntity;
	}

	public void setCollegeEntity(CollegeEntity collegeEntity) {
		this.collegeEntity = collegeEntity;
	}

	public List<BranchEntity> getAllBranches() {
		return allBranches;
	}

	public void setAllBranches(List<BranchEntity> allBranches) {
		this.allBranches = allBranches;
	}

	@Override
	public String toString() {
		return "CourseEntity [courseId=" + courseId + ", courseName=" + courseName + ", eligibility=" + eligibility
				+ ", collegeEntity=" + collegeEntity + ", allBranches=" + allBranches + "]";
	}
		 
}