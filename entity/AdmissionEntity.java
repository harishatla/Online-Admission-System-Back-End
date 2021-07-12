package com.onlineadmission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="admission")
public class AdmissionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admission_id")
	@SequenceGenerator(sequenceName = "ADMISSION_SEQ", allocationSize = 1, name = "admission_id")
	
	@Column(name="admission_id")
	private int admissionId;
	
	@Column(name="year")
	int year;
	
	@OneToOne
	@JoinColumn(name = "application_id")
	private ApplicationEntity applicationEntity;
	
	public AdmissionEntity() {
		super();
		
	}

	public AdmissionEntity(int admissionId, int year, ApplicationEntity applicationEntity) {
		super();
		this.admissionId = admissionId;
		this.year = year;
		this.applicationEntity = applicationEntity;
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

	public ApplicationEntity getApplicationEntity() {
		return applicationEntity;
	}

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}

	@Override
	public String toString() {
		return "AdmissionEntity [admissionId=" + admissionId + ", year=" + year + ", applicationEntity="
				+ applicationEntity + "]";
	}	
	
}
