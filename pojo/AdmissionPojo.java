package com.onlineadmission.pojo;

public class AdmissionPojo {
	
	private int admissionId;
	private int year;
	private ApplicationPojo applicationPojo;
	
	public AdmissionPojo() {
		super();
	}

	public AdmissionPojo(int admissionId, int year, ApplicationPojo applicationPojo) {
		super();
		this.admissionId = admissionId;
		this.year = year;
		this.applicationPojo = applicationPojo;
	}

	public int getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ApplicationPojo getApplicationPojo() {
		return applicationPojo;
	}

	public void setApplicationPojo(ApplicationPojo applicationPojo) {
		this.applicationPojo = applicationPojo;
	}

	@Override
	public String toString() {
		return "AdmissionPojo [admissionId=" + admissionId + ", year=" + year + ", applicationPojo=" + applicationPojo
				+ "]";
	}
	
}
