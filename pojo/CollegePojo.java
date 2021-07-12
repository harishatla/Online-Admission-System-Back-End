package com.onlineadmission.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

 

public class CollegePojo {
	
	private int collegeRegId;
	@NotNull(message="College Name Is Not Null")
	private String collegeName;
	private String collegeCity;
	private String collegeState;
	private List<CoursePojo> allCoursesPojo = new ArrayList<>();
	private List<ApplicationPojo> applicationPojo = new ArrayList<>();
	
	public CollegePojo() {
		super();
	}

	public CollegePojo(int collegeRegId, String collegeName, String collegeCity,
			String collegeState, List<CoursePojo> allCoursesPojo, List<ApplicationPojo> applicationPojo) {
		super();
		this.collegeRegId = collegeRegId;
		this.collegeName = collegeName;
		this.collegeCity = collegeCity;
		this.collegeState = collegeState;
		this.allCoursesPojo = allCoursesPojo;
		this.applicationPojo = applicationPojo;
	}

	public int getCollegeRegId() {
		return collegeRegId;
	}

	public void setCollegeRegId(int collegeRegId) {
		this.collegeRegId = collegeRegId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public String getCollegeCity() {
		return collegeCity;
	}

	public void setCollegeCity(String collegeCity) {
		this.collegeCity = collegeCity;
	}

	public String getCollegeState() {
		return collegeState;
	}

	public void setCollegeState(String collegeState) {
		this.collegeState = collegeState;
	}

	public List<CoursePojo> getAllCoursesPojo() {
		return allCoursesPojo;
	}

	public void setAllCoursesPojo(List<CoursePojo> allCoursesPojo) {
		this.allCoursesPojo = allCoursesPojo;
	}

	public List<ApplicationPojo> getApplicationPojo() {
		return applicationPojo;
	}

	public void setApplicationPojo(List<ApplicationPojo> applicationPojo) {
		this.applicationPojo = applicationPojo;
	}

	@Override
	public String toString() {
		return "CollegePojo [collegeRegId=" + collegeRegId + ", collegeName=" + collegeName + ", collegeCity="
				+ collegeCity + ", collegeState=" + collegeState + ", allCoursesPojo=" + allCoursesPojo
				+ ", applicationPojo=" + applicationPojo + "]";
	}

	
}
