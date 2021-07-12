package com.onlineadmission.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class ApplicationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="APPLICATION_SEQ")
	@SequenceGenerator(sequenceName ="APPLICATION_SEQ",allocationSize = 1, name = "APPLICATION_SEQ") 
	
	@Column(name="APPLICATION_ID")
	private int applicationId;
	
	@Column(name="APPLICANT_FULL_NAME")
	private String applicantFuLLName;
	
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBrith;
	
	@Column(name="HIGHEST_QUALIFICATION")
	private String highestQualification;
	
	@Column(name="HIGHEST_QUAL_PERCENTAGE")
	private double highestQualificationPercentage;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="APPLICATION_STATUS")
	private String applicationStatus;
	
	@OneToOne
	@JoinColumn(name = "course_id")
	private CourseEntity courseEntity;
	
	@OneToOne
	@JoinColumn(name ="branch_id")
	private BranchEntity branchEntity;
	
	@ManyToOne
	@JoinColumn(name="college_reg_id")
	private CollegeEntity collegeEntity;
		
	@OneToOne(mappedBy = "applicationEntity", cascade =  CascadeType.ALL)
	private PaymentEntity paymentEntity;
	
	public void addPaymentEntity( PaymentEntity paymentEntity) {
		if(paymentEntity != null) {
			paymentEntity.setApplicationEntity(this);
		}
		this.paymentEntity= paymentEntity;
	}
	
	@OneToOne(mappedBy = "applicationEntity", cascade = CascadeType.ALL)
	private AdmissionEntity admissionEntity;
	
	public void addAdmissionEntity( AdmissionEntity admissionEntity) {
		if(admissionEntity != null) {
			admissionEntity.setApplicationEntity(this);
		}
		this.admissionEntity= admissionEntity;
	}
	public ApplicationEntity() {
		super();
	}
	public ApplicationEntity(int applicationId, String applicantFuLLName, Date dateOfBrith, String highestQualification,
			double highestQualificationPercentage, String email, String applicationStatus, CourseEntity courseEntity,
			BranchEntity branchEntity, CollegeEntity collegeEntity, PaymentEntity paymentEntity,
			AdmissionEntity admissionEntity) {
		super();
		this.applicationId = applicationId;
		this.applicantFuLLName = applicantFuLLName;
		this.dateOfBrith = dateOfBrith;
		this.highestQualification = highestQualification;
		this.highestQualificationPercentage = highestQualificationPercentage;
		this.email = email;
		this.applicationStatus = applicationStatus;
		this.courseEntity = courseEntity;
		this.branchEntity = branchEntity;
		this.collegeEntity = collegeEntity;
		this.paymentEntity = paymentEntity;
		this.admissionEntity = admissionEntity;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplicantFuLLName() {
		return applicantFuLLName;
	}
	public void setApplicantFuLLName(String applicantFuLLName) {
		this.applicantFuLLName = applicantFuLLName;
	}
	public Date getDateOfBrith() {
		return dateOfBrith;
	}
	public void setDateOfBrith(Date dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
	public double getHighestQualificationPercentage() {
		return highestQualificationPercentage;
	}
	public void setHighestQualificationPercentage(double highestQualificationPercentage) {
		this.highestQualificationPercentage = highestQualificationPercentage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public CourseEntity getCourseEntity() {
		return courseEntity;
	}
	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}
	public BranchEntity getBranchEntity() {
		return branchEntity;
	}
	public void setBranchEntity(BranchEntity branchEntity) {
		this.branchEntity = branchEntity;
	}
	public CollegeEntity getCollegeEntity() {
		return collegeEntity;
	}
	public void setCollegeEntity(CollegeEntity collegeEntity) {
		this.collegeEntity = collegeEntity;
	}
	public PaymentEntity getPaymentEntity() {
		return paymentEntity;
	}
	public void setPaymentEntity(PaymentEntity paymentEntity) {
		this.paymentEntity = paymentEntity;
	}
	public AdmissionEntity getAdmissionEntity() {
		return admissionEntity;
	}
	public void setAdmissionEntity(AdmissionEntity admissionEntity) {
		this.admissionEntity = admissionEntity;
	}
	@Override
	public String toString() {
		return "ApplicationEntity [applicationId=" + applicationId + ", applicantFuLLName=" + applicantFuLLName
				+ ", dateOfBrith=" + dateOfBrith + ", highestQualification=" + highestQualification
				+ ", highestQualificationPercentage=" + highestQualificationPercentage + ", email=" + email
				+ ", applicationStatus=" + applicationStatus + ", courseEntity=" + courseEntity + ", branchEntity="
				+ branchEntity + ", collegeEntity=" + collegeEntity + ", paymentEntity=" + paymentEntity
				+ ", admissionEntity=" + admissionEntity + "]";
	}
	
	

	

	
	
}
