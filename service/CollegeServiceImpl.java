package com.onlineadmission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmission.dao.CollegeJpaDao;
import com.onlineadmission.entity.BranchEntity;
import com.onlineadmission.entity.CollegeEntity;
import com.onlineadmission.entity.CourseEntity;
import com.onlineadmission.exception.CollegeNotFoundException;
import com.onlineadmission.pojo.BranchPojo;
import com.onlineadmission.pojo.CollegePojo;
import com.onlineadmission.pojo.CoursePojo;

@Service
public class CollegeServiceImpl implements CollegeService{
	
	@Autowired
	CollegeJpaDao collegeJpaDao;
	
	public CollegeServiceImpl() {
	}
	
	
	@Override
	public CollegePojo addCollege(CollegePojo college) {
		//CollegePojo newCollegePojo = new CollegePojo();
		CollegeEntity collegeEntity = new CollegeEntity();
		BeanUtils.copyProperties(college, collegeEntity);
		List<CoursePojo> allCoursePojo = college.getAllCoursesPojo();
		List<CourseEntity> allCourseEntity = new ArrayList<CourseEntity>();
		for(CoursePojo coursePojo: allCoursePojo) {
			CourseEntity courseEntity = new CourseEntity();
			BeanUtils.copyProperties(coursePojo, courseEntity);
			List<BranchPojo> allBranchPojo = coursePojo.getAllBranchesPojo();
			List<BranchEntity> allBranchEntity = new ArrayList<BranchEntity>();
			for(BranchPojo branchPojo: allBranchPojo) {
				BranchEntity branchEntity = new BranchEntity();
				BeanUtils.copyProperties(branchPojo, branchEntity);
				allBranchEntity.add(branchEntity);
			}
			courseEntity.setAllBranches(allBranchEntity);
			allCourseEntity.add(courseEntity);	
		}
		collegeEntity.setAllCourses(allCourseEntity);
		
		collegeEntity = collegeJpaDao.saveAndFlush(collegeEntity);
		

		BeanUtils.copyProperties(collegeEntity, college);
		 allCoursePojo = new ArrayList<>();
		 allCourseEntity = collegeEntity.getAllCourses();
		
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
		college.setAllCoursesPojo(allCoursePojo);
		return college;
	}
	

	@Override
	public List<CollegePojo> getAllColleges() {

		List<CollegeEntity> allCollegeEntity = collegeJpaDao.findAll();
		List<CollegePojo> allCollegePojo = new ArrayList<>();
		
		for(CollegeEntity collegeEntity: allCollegeEntity) {
			CollegePojo collegePojo = new CollegePojo();
			BeanUtils.copyProperties(collegeEntity, collegePojo);
			
			List<CourseEntity> allCourseEntity = collegeEntity.getAllCourses();
			List<CoursePojo> allCoursePojo = new ArrayList<>();
			
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
			collegePojo.setAllCoursesPojo(allCoursePojo);
			allCollegePojo.add(collegePojo);
		}
		if(allCollegePojo.isEmpty()) {
			throw new CollegeNotFoundException("No College Found");
		}
		return allCollegePojo;
	}

	

	@Override
	public boolean deleteCollege(int collegeId) {
		collegeJpaDao.deleteById(collegeId);
		return true;
	}


	@Override
	public CollegePojo updateCollege(CollegePojo updateCollege) {
		CollegeEntity updatedCollegeEntity = new CollegeEntity();
		BeanUtils.copyProperties(updateCollege, updatedCollegeEntity);
		 updatedCollegeEntity = collegeJpaDao.save(updatedCollegeEntity);
		BeanUtils.copyProperties(updatedCollegeEntity, updateCollege);
		return updateCollege;
	}
	
	@Override
	public CollegePojo getCollege(int collegeId) {
		
		CollegePojo collegePojo = new CollegePojo();
		CollegeEntity collegeEntity = new CollegeEntity();
		Optional<CollegeEntity> result = collegeJpaDao.findById(collegeId);
		if(result.isEmpty()) {
			throw new CollegeNotFoundException("No College Found");
		}
		else {
			List<CourseEntity> allCourseEntity =  result.get().getAllCourses();
			List<CoursePojo> allCoursePojo = new ArrayList<>();
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
		
			BeanUtils.copyProperties(result.get(),collegePojo);
			collegePojo.setAllCoursesPojo(allCoursePojo);
		}
		return collegePojo;
		
	}
}


















































