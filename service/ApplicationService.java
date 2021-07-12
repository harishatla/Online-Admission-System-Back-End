package com.onlineadmission.service;

import java.util.List;

import com.onlineadmission.pojo.ApplicationPojo;

public interface ApplicationService {
	
	    public List<ApplicationPojo> getAllApplications();
	    
	    public ApplicationPojo getApplication(int applicationId);
	    
		public ApplicationPojo addApplication(ApplicationPojo application);

		public ApplicationPojo updateApplication(ApplicationPojo application);

		 
}
