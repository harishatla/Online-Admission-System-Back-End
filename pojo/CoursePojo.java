package com.onlineadmission.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class CoursePojo {
	
	
	private  int courseId;
	
	@NotNull(message="Course Name Is Not Null")
	private String courseName;
	private  String eligibility;
	private CollegePojo collegePojo;
	private List<BranchPojo> allBranchesPojo = new ArrayList<>();
	
	public CoursePojo() {
		super();
	}

	public CoursePojo(int courseId, @NotNull(message = "Course Name Is Not Null") String courseName, String eligibility,
			CollegePojo collegePojo, List<BranchPojo> allBranchesPojo) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.eligibility = eligibility;
		this.collegePojo = collegePojo;
		this.allBranchesPojo = allBranchesPojo;
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

	public CollegePojo getCollegePojo() {
		return collegePojo;
	}

	public void setCollegePojo(CollegePojo collegePojo) {
		this.collegePojo = collegePojo;
	}

	public List<BranchPojo> getAllBranchesPojo() {
		return allBranchesPojo;
	}

	public void setAllBranchesPojo(List<BranchPojo> allBranchesPojo) {
		this.allBranchesPojo = allBranchesPojo;
	}

	@Override
	public String toString() {
		return "CoursePojo [courseId=" + courseId + ", courseName=" + courseName + ", eligibility=" + eligibility
				+ ", collegePojo=" + collegePojo + ", allBranchesPojo=" + allBranchesPojo + "]";
	}
	
	

	 
}
