package com.onlineadmission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmission.dao.BranchJpaDao;
import com.onlineadmission.entity.BranchEntity;
import com.onlineadmission.entity.CourseEntity;
import com.onlineadmission.exception.BranchNotFoundException;
import com.onlineadmission.pojo.BranchPojo;
import com.onlineadmission.pojo.CoursePojo;

@Service
public class BranchServiceImpl implements BranchService{

	@Autowired
	BranchJpaDao branchJpaDao;
	
	@Override
	public List<BranchPojo> getAllBranches() {
		
		List<BranchEntity>  allBranchEntity =  branchJpaDao.findAll();
		List<BranchPojo>  allBranchPojo = new ArrayList<>();
		
		for(BranchEntity branchEntity: allBranchEntity) {
			BranchPojo branchPojo = new BranchPojo();
			BeanUtils.copyProperties(branchEntity, branchPojo);
			List<CourseEntity> allCourseEntity = branchEntity.getCourse();
			List<CoursePojo> allCoursePojo = new ArrayList<>();
			
			for(CourseEntity courseEntity: allCourseEntity) {
				CoursePojo coursePojo = new CoursePojo();
				BeanUtils.copyProperties(courseEntity, coursePojo);
				allCoursePojo.add(coursePojo);
			}
			branchPojo.setCoursePojo(allCoursePojo);
			allBranchPojo.add(branchPojo);
		}
	        if(allBranchPojo.isEmpty()) {
	            throw new BranchNotFoundException("No Branch Found");
	        }
	        return allBranchPojo;
	}

	@Override
	public BranchPojo addBranch(BranchPojo branch) {
		BranchEntity branchEntity = new BranchEntity();
		BeanUtils.copyProperties(branch, branchEntity);
		 branchEntity =branchJpaDao.save(branchEntity);
		 BeanUtils.copyProperties(branchEntity, branch);
		 return branch;
	}
	
	@Override
	public BranchPojo getBranch(int branchId){
		
		BranchPojo branchPojo = new BranchPojo();
		
		Optional<BranchEntity> result = branchJpaDao.findById(branchId);
		if(result.isEmpty()) {
			throw new BranchNotFoundException("No Branches Found");
		}
		else {
			
			BranchEntity branchEntity = new BranchEntity();
			List<CourseEntity> allcourseEntity =    result.get().getCourse();
			List<CoursePojo> allCoursePojo = new ArrayList<>();
			for(CourseEntity courseEntity: allcourseEntity) {
				CoursePojo coursePojo = new CoursePojo();
				BeanUtils.copyProperties(courseEntity, coursePojo);
				allCoursePojo.add(coursePojo);
		}	
			BeanUtils.copyProperties(result.get(), branchPojo);
			branchPojo .setCoursePojo(allCoursePojo);
		}
		return branchPojo;
}
	
	
	@Override
	public BranchPojo updateBranch(BranchPojo updateBranch) {
		BranchEntity branchEntity = new BranchEntity();
		BeanUtils.copyProperties(updateBranch, branchEntity);
		branchEntity = branchJpaDao.save(branchEntity);
		BeanUtils.copyProperties(branchEntity, updateBranch);
		return updateBranch;
	}
	
	@Override
	public boolean deleteBranch(int branchId) {
		branchJpaDao.deleteById(branchId);
		return true;
	}

}
