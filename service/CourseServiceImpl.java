package com.onlineadmission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmission.dao.CourseJpaDao;
import com.onlineadmission.entity.BranchEntity;
import com.onlineadmission.entity.CollegeEntity;
import com.onlineadmission.entity.CourseEntity;
import com.onlineadmission.exception.CourseNotFoundException;
import com.onlineadmission.pojo.BranchPojo;
import com.onlineadmission.pojo.CoursePojo;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseJpaDao courseJpaDao;
	
	public CourseServiceImpl() {
		
	}
	
	@Override
	public List<CoursePojo> getAllCourses() {
		List<CourseEntity>  allCourseEntity =  courseJpaDao.findAll();
		List<CoursePojo>  allCoursePojo = new ArrayList<>();
		
		for(CourseEntity courseEntity: allCourseEntity) {
			CoursePojo coursePojo = new CoursePojo();
			BeanUtils.copyProperties(courseEntity, coursePojo);
			
			List<BranchEntity> allBranchEntity = courseEntity.getAllBranches();
			List<BranchPojo> allBranchPojo = new ArrayList<>();
			
			for(BranchEntity branchEntity: allBranchEntity) {
				BranchPojo branchPojo = new BranchPojo();
				BeanUtils.copyProperties(branchEntity, branchPojo);
				allBranchPojo.add(branchPojo);
			}
			coursePojo.setAllBranchesPojo(allBranchPojo);
			allCoursePojo.add(coursePojo);
		}
		if(allCoursePojo.isEmpty()) {
			throw new CourseNotFoundException("No Course Found");
		}
		return allCoursePojo;
	}
	
	public CoursePojo addCourse(CoursePojo course) {
		CourseEntity courseEntity = new CourseEntity();
		BeanUtils.copyProperties(course, courseEntity); 
		
		List<BranchPojo> allBranchPojo = course.getAllBranchesPojo();
		List<BranchEntity> allBranchEntity = new ArrayList<>();
		for(BranchPojo branchPojo: allBranchPojo) {
			BranchEntity branchEntity = new BranchEntity();
			BeanUtils.copyProperties(branchPojo, branchEntity);
			allBranchEntity.add(branchEntity);
		}
		 
		courseEntity.setAllBranches(allBranchEntity); 
		CollegeEntity collegeEntity = new CollegeEntity();
		BeanUtils.copyProperties(course.getCollegePojo(), collegeEntity);
		courseEntity.setCollegeEntity(collegeEntity);
		courseEntity = courseJpaDao.saveAndFlush(courseEntity);
		BeanUtils.copyProperties(courseEntity, course); 
		
		allBranchEntity = courseEntity.getAllBranches();
		allBranchPojo = new ArrayList<>();
		for(BranchEntity branchEntity: allBranchEntity) {
			BranchPojo branchPojo = new BranchPojo();
			BeanUtils.copyProperties(branchEntity, branchPojo);
			allBranchPojo.add(branchPojo);
		}
		course.setAllBranchesPojo(allBranchPojo);
		 
		return course;
		}


	@Override
	public boolean deleteCourse(int courseId) {
		courseJpaDao.deleteById(courseId);
		return true;
	}
	
	@Override
	public CoursePojo getCourse(int courseId) {
		
		CoursePojo coursePojo = new CoursePojo();
		CourseEntity courseEntity = new CourseEntity();
		
		Optional<CourseEntity> result = courseJpaDao.findById(courseId);
		if(result.isEmpty()) {
			throw new CourseNotFoundException("No Course Found");
		}
		
		List<BranchEntity> allBranchEntity =  result.get().getAllBranches();
		List<BranchPojo> allBranchPojo = new ArrayList<>();
	for(BranchEntity branchEntity: allBranchEntity) {
		BranchPojo branchPojo = new BranchPojo();
		BeanUtils.copyProperties(branchEntity, branchPojo);
		allBranchPojo.add(branchPojo);
	} 
		 
			BeanUtils.copyProperties(result.get(), coursePojo);
			coursePojo.setAllBranchesPojo(allBranchPojo);
			return coursePojo;
	}
	

	@Override
	public CoursePojo updateCourse(CoursePojo updateCourse) {
		CourseEntity courseEntity = new CourseEntity();
		BeanUtils.copyProperties(updateCourse, courseEntity);
		 courseEntity = courseJpaDao.save(courseEntity);
		BeanUtils.copyProperties(courseEntity, updateCourse);
		return updateCourse;
	}

}
