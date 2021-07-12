package com.onlineadmission.service;

import java.util.List;

import com.onlineadmission.pojo.AdmissionPojo;


public interface AdmissionService {
	
	  public List<AdmissionPojo> getAllAdmissions();
	     
	  public AdmissionPojo getAdmission(int admissionId);
	    
}
