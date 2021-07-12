package com.onlineadmission.service;

import java.util.List;

import com.onlineadmission.pojo.CollegePojo;

public interface CollegeService {
	
    public List<CollegePojo> getAllColleges();
    
    public boolean deleteCollege(int collegeId);
    
    public CollegePojo getCollege(int collegeId);
    
    public CollegePojo updateCollege(CollegePojo updateCollege);

	public CollegePojo addCollege(CollegePojo college);
}