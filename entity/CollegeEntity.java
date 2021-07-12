package com.onlineadmission.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="college")
public class CollegeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="college_regd_id")
	@SequenceGenerator(name="college_regd_id",sequenceName="COLLEGE_SEQ",allocationSize=1)
	@Column(name="college_reg_id")
	private int collegeRegId;
	
	@Column(name="college_name")
	private String collegeName;
	
	@Column(name = "college_city")
	private String collegeCity;
	
	@Column(name = "college_state")
	private String collegeState;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "college_reg_id")
	private List<CourseEntity> allCourses = new ArrayList<>();
	
	@OneToMany(mappedBy = "collegeEntity", cascade = CascadeType.ALL)
	private List<ApplicationEntity> applicationEntities = new ArrayList<>();

	public CollegeEntity() {
		super();
	}

	public CollegeEntity(int collegeRegId, String collegeName, String collegeCity,
			String collegeState, List<CourseEntity> allCourses, List<ApplicationEntity> applicationEntities) {
		super();
		this.collegeRegId = collegeRegId;
		this.collegeName = collegeName;
		this.collegeCity = collegeCity;
		this.collegeState = collegeState;
		this.allCourses = allCourses;
		this.applicationEntities = applicationEntities;
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

	public List<CourseEntity> getAllCourses() {
		return allCourses;
	}

	public void setAllCourses(List<CourseEntity> allCourses) {
		this.allCourses = allCourses;
	}

	public List<ApplicationEntity> getApplicationEntities() {
		return applicationEntities;
	}

	public void setApplicationEntities(List<ApplicationEntity> applicationEntities) {
		this.applicationEntities = applicationEntities;
	}

	@Override
	public String toString() {
		return "CollegeEntity [collegeRegId=" + collegeRegId + ", collegeName=" + collegeName  + ", collegeCity=" + collegeCity + ", collegeState=" + collegeState + ", allCourses="
				+ allCourses + ", applicationEntities=" + applicationEntities + "]";
	}
	 

}
