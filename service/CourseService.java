package com.onlineadmission.service;

import java.util.List;

import com.onlineadmission.entity.CourseEntity;
import com.onlineadmission.pojo.CoursePojo;

public interface CourseService {
	
	  public List<CoursePojo> getAllCourses();
	    
	    public CoursePojo addCourse(CoursePojo course);
	    
	    public boolean deleteCourse(int courseId);
	    
	    public CoursePojo getCourse(int courseId);
	    
	    public CoursePojo updateCourse(CoursePojo updatedCourse);
}
