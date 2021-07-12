package com.onlineadmission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmission.dao.ApplicationJpaDao;
import com.onlineadmission.entity.AdmissionEntity;
import com.onlineadmission.entity.ApplicationEntity;
import com.onlineadmission.entity.BranchEntity;
import com.onlineadmission.entity.CollegeEntity;
import com.onlineadmission.entity.CourseEntity;
import com.onlineadmission.entity.PaymentEntity;
import com.onlineadmission.exception.ApplicationNotFoundException;
import com.onlineadmission.pojo.AdmissionPojo;
import com.onlineadmission.pojo.ApplicationPojo;
import com.onlineadmission.pojo.BranchPojo;
import com.onlineadmission.pojo.CollegePojo;
import com.onlineadmission.pojo.CoursePojo;
import com.onlineadmission.pojo.PaymentPojo;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	ApplicationJpaDao applicationJpaDao;
	
	public ApplicationServiceImpl() {
	}
	
	@Override
	public ApplicationPojo updateApplication(ApplicationPojo application) {
		
		ApplicationEntity applicationEntity = new ApplicationEntity();
		BeanUtils.copyProperties(application, applicationEntity);
		
		CourseEntity courseEntity = new CourseEntity();
		BranchEntity branchEntity = new BranchEntity();
		
		PaymentEntity paymentEntity = new PaymentEntity();
		AdmissionEntity admissionEntity = new AdmissionEntity();
		
		BeanUtils.copyProperties(application.getPaymentPojo(), paymentEntity);
		
		BeanUtils.copyProperties(application.getCoursePojo(), courseEntity);
		System.out.println(application.getCoursePojo());
		BeanUtils.copyProperties(application.getBranchPojo(), branchEntity);
		
		
		
		if (application.getAdmissionPojo() != null) {
			System.out.println("admissionPojo" +application.getAdmissionPojo());
			
		BeanUtils.copyProperties(application.getAdmissionPojo(), admissionEntity);
		applicationEntity.addAdmissionEntity(admissionEntity);
		}
		applicationEntity.setPaymentEntity(paymentEntity);
		applicationEntity.addPaymentEntity(paymentEntity);
		
		applicationEntity.setCourseEntity(courseEntity);
		applicationEntity.setBranchEntity(branchEntity);

		CollegePojo allCollegePojo = application.getCollegePojo();
		CollegeEntity allCollegeEntity = new CollegeEntity();
		BeanUtils.copyProperties(allCollegePojo, allCollegeEntity);
		
		allCollegePojo = new CollegePojo();
		 
		List<CoursePojo> allCoursePojo = allCollegePojo.getAllCoursesPojo();
		List<CourseEntity> allCourseEntity = new ArrayList<CourseEntity>();
		for (CoursePojo coursePojo1 : allCoursePojo) {
			
			CourseEntity courseEntity1 = new CourseEntity();
			BeanUtils.copyProperties(coursePojo1, courseEntity1);
		
		List<BranchPojo> allBranchPojo = coursePojo1.getAllBranchesPojo();
		List<BranchEntity> allBranchEntity = new ArrayList<BranchEntity>();
		for (BranchPojo branchPojo1 : allBranchPojo) {
			BranchEntity branchEntity1 = new BranchEntity();
			BeanUtils.copyProperties(branchPojo1, branchEntity1);
			allBranchEntity.add(branchEntity1);
			}
		courseEntity.setAllBranches(allBranchEntity);
		allCourseEntity.add(courseEntity);
		}
		allCollegeEntity.setAllCourses(allCourseEntity);
		applicationEntity.setCollegeEntity(allCollegeEntity);
		
		applicationEntity = applicationJpaDao.saveAndFlush(applicationEntity);
		
		
		BeanUtils.copyProperties(applicationEntity, application);
		if(applicationEntity.getAdmissionEntity() != null) {
			AdmissionPojo admissionPojo = new AdmissionPojo();
			BeanUtils.copyProperties(applicationEntity.getAdmissionEntity(), admissionPojo);
			
			application.setAdmissionPojo(admissionPojo);
		}
		
		
		
		CoursePojo coursePojo =new CoursePojo();
		BranchPojo branchPojo = new BranchPojo();
	
		PaymentPojo paymentPojo = new PaymentPojo();
		BeanUtils.copyProperties(applicationEntity.getPaymentEntity(), paymentPojo);
		
		BeanUtils.copyProperties(applicationEntity.getCourseEntity(),  coursePojo);
		BeanUtils.copyProperties(applicationEntity.getBranchEntity(), branchPojo);
		
		
		application.setPaymentPojo(paymentPojo);
		application.setCoursePojo(coursePojo);
		application.setBranchPojo(branchPojo);

		allCollegeEntity = applicationEntity.getCollegeEntity();
		BeanUtils.copyProperties(allCollegeEntity, allCollegePojo);
		allCoursePojo = new ArrayList<>();
		allCourseEntity = allCollegeEntity.getAllCourses();

		for (CourseEntity courseEntity1 : allCourseEntity) {
			
			CoursePojo coursePojo1 = new CoursePojo();
			BeanUtils.copyProperties(courseEntity1, coursePojo1);
		
		List<BranchEntity> allBranchEntity = courseEntity.getAllBranches();
		List<BranchPojo> allBranchPojo = new ArrayList<>();
		
		for (BranchEntity branchEntity1 : allBranchEntity) {
			
			BranchPojo branchPojo1 = new BranchPojo();
			BeanUtils.copyProperties(branchEntity1, branchPojo1);
			allBranchPojo.add(branchPojo1);
		}
		
		coursePojo.setAllBranchesPojo(allBranchPojo);
		allCoursePojo.add(coursePojo1);
		
		}
		allCollegePojo.setAllCoursesPojo(allCoursePojo);
		application.setCollegePojo(allCollegePojo);
		return application;
	}

	@Override
	public List<ApplicationPojo> getAllApplications() {
		List<ApplicationEntity> allApplicationEntity = applicationJpaDao.findAll();
		List<ApplicationPojo> allApplicationPojo = new  ArrayList<>();
		
		for(ApplicationEntity applicationEntity: allApplicationEntity) {
			
			ApplicationPojo applicationPojo = new ApplicationPojo();
			PaymentPojo paymentPojo = new PaymentPojo();
			AdmissionPojo admissionPojo = new AdmissionPojo();
			CoursePojo coursePojo1 = new CoursePojo();
			BranchPojo branchPojo1 = new BranchPojo();
			
			BeanUtils.copyProperties(applicationEntity.getCourseEntity(), coursePojo1);
			BeanUtils.copyProperties(applicationEntity.getBranchEntity(), branchPojo1);
			BeanUtils.copyProperties(applicationEntity.getPaymentEntity(), paymentPojo);
			applicationPojo.setCoursePojo(coursePojo1);
			applicationPojo.setBranchPojo(branchPojo1);
			
			if(applicationEntity.getAdmissionEntity() != null) {
				BeanUtils.copyProperties(applicationEntity.getAdmissionEntity(), admissionPojo);
				applicationPojo.setAdmissionPojo(admissionPojo);
			}
			else {
				applicationPojo.setAdmissionPojo(null);
			}
			applicationPojo.setPaymentPojo(paymentPojo);
			
			CollegeEntity collegeEntity = applicationEntity.getCollegeEntity();
			CollegePojo collegePojo = new CollegePojo();
			BeanUtils.copyProperties(collegeEntity, collegePojo);
			
			List<CourseEntity> allCourseEntity = collegeEntity.getAllCourses();
			List<CoursePojo> allCoursePojo = new ArrayList<>();
			for(CourseEntity courseEntity: allCourseEntity) {
				CoursePojo coursePojo = new CoursePojo();
				BeanUtils.copyProperties(courseEntity, coursePojo);
				allCoursePojo.add(coursePojo);
					
				List<BranchEntity> allBranchEntity = courseEntity.getAllBranches();
				List<BranchPojo> allBranchPojo = new ArrayList<>();
				for(BranchEntity branchEntity: allBranchEntity) {
					BranchPojo branchPojo = new BranchPojo();
					BeanUtils.copyProperties(branchEntity, branchPojo);
					allBranchPojo.add(branchPojo);
				}
				coursePojo.setAllBranchesPojo(allBranchPojo);
			}
			collegePojo.setAllCoursesPojo(allCoursePojo);
			applicationPojo.setCollegePojo(collegePojo);
			BeanUtils.copyProperties(applicationEntity, applicationPojo);
			allApplicationPojo.add(applicationPojo);
		}
		return  allApplicationPojo;
	}

	@Override
	public ApplicationPojo addApplication(ApplicationPojo application) {
		
		ApplicationEntity applicationEntity = new ApplicationEntity();
		BeanUtils.copyProperties(application, applicationEntity);
		
		CourseEntity courseEntity = new CourseEntity();
		BranchEntity branchEntity = new BranchEntity();
		
		PaymentEntity paymentEntity = new PaymentEntity();
		AdmissionEntity admissionEntity = new AdmissionEntity();
		
		BeanUtils.copyProperties(application.getPaymentPojo(), paymentEntity);
		
		BeanUtils.copyProperties(application.getCoursePojo(), courseEntity);
		System.out.println(application.getCoursePojo());
		BeanUtils.copyProperties(application.getBranchPojo(), branchEntity);
		
		
		
		if (application.getAdmissionPojo() != null) {
		BeanUtils.copyProperties(application.getAdmissionPojo(), admissionEntity);
		}
		applicationEntity.setPaymentEntity(paymentEntity);
		applicationEntity.addPaymentEntity(paymentEntity);
		
		applicationEntity.setCourseEntity(courseEntity);
		applicationEntity.setBranchEntity(branchEntity);

		CollegePojo allCollegePojo = application.getCollegePojo();
		CollegeEntity allCollegeEntity = new CollegeEntity();
		BeanUtils.copyProperties(allCollegePojo, allCollegeEntity);
		
		allCollegePojo = new CollegePojo();
		 
		List<CoursePojo> allCoursePojo = allCollegePojo.getAllCoursesPojo();
		List<CourseEntity> allCourseEntity = new ArrayList<CourseEntity>();
		for (CoursePojo coursePojo1 : allCoursePojo) {
			
			CourseEntity courseEntity1 = new CourseEntity();
			BeanUtils.copyProperties(coursePojo1, courseEntity1);
		
		List<BranchPojo> allBranchPojo = coursePojo1.getAllBranchesPojo();
		List<BranchEntity> allBranchEntity = new ArrayList<BranchEntity>();
		for (BranchPojo branchPojo1 : allBranchPojo) {
			BranchEntity branchEntity1 = new BranchEntity();
			BeanUtils.copyProperties(branchPojo1, branchEntity1);
			allBranchEntity.add(branchEntity1);
			}
		courseEntity.setAllBranches(allBranchEntity);
		allCourseEntity.add(courseEntity);
		}
		allCollegeEntity.setAllCourses(allCourseEntity);
		applicationEntity.setCollegeEntity(allCollegeEntity);
		
		applicationEntity = applicationJpaDao.saveAndFlush(applicationEntity);
		
		BeanUtils.copyProperties(applicationEntity, application);
		
		CoursePojo coursePojo =new CoursePojo();
		BranchPojo branchPojo = new BranchPojo();
	
		PaymentPojo paymentPojo = new PaymentPojo();
		BeanUtils.copyProperties(applicationEntity.getPaymentEntity(), paymentPojo);
		
		BeanUtils.copyProperties(applicationEntity.getCourseEntity(),  coursePojo);
		BeanUtils.copyProperties(applicationEntity.getBranchEntity(), branchPojo);
		
		
		application.setPaymentPojo(paymentPojo);
		application.setCoursePojo(coursePojo);
		application.setBranchPojo(branchPojo);

		allCollegeEntity = applicationEntity.getCollegeEntity();
		BeanUtils.copyProperties(allCollegeEntity, allCollegePojo);
		allCoursePojo = new ArrayList<>();
		allCourseEntity = allCollegeEntity.getAllCourses();

		for (CourseEntity courseEntity1 : allCourseEntity) {
			
			CoursePojo coursePojo1 = new CoursePojo();
			BeanUtils.copyProperties(courseEntity1, coursePojo1);
		
		List<BranchEntity> allBranchEntity = courseEntity.getAllBranches();
		List<BranchPojo> allBranchPojo = new ArrayList<>();
		
		for (BranchEntity branchEntity1 : allBranchEntity) {
			
			BranchPojo branchPojo1 = new BranchPojo();
			BeanUtils.copyProperties(branchEntity1, branchPojo1);
			allBranchPojo.add(branchPojo1);
		}
		
		coursePojo.setAllBranchesPojo(allBranchPojo);
		allCoursePojo.add(coursePojo1);
		
		}
		allCollegePojo.setAllCoursesPojo(allCoursePojo);
		application.setCollegePojo(allCollegePojo);
		return application;
	}
	
	public ApplicationPojo getApplication(int applicationId) {

		ApplicationPojo allApplicationPojo = new  ApplicationPojo();
		ApplicationEntity applicationEntity = new ApplicationEntity();
	      
	        Optional<ApplicationEntity> result = applicationJpaDao.findById(applicationId);
	        
	        if(result.isEmpty()) {
	        	throw new ApplicationNotFoundException("No Applications Found");
	        }
	        
	        
	        CollegeEntity collegeEntity =  result.get().getCollegeEntity();
	        CollegePojo collegePojo = new CollegePojo();
	        CourseEntity courseEntity1 = result.get().getCourseEntity();
	        BranchEntity branchEntity1 = result.get().getBranchEntity();
	        CoursePojo coursePojo1 = new CoursePojo();
	        BranchPojo branchPojo1 = new BranchPojo();
	        
	        BeanUtils.copyProperties(collegeEntity, collegePojo);
	        BeanUtils.copyProperties(courseEntity1, coursePojo1);
	        BeanUtils.copyProperties(branchEntity1, branchPojo1);

	        List<CourseEntity> allCourseEntity =   collegeEntity.getAllCourses();
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
			     allApplicationPojo.setCoursePojo(coursePojo1);
			     allApplicationPojo.setBranchPojo(branchPojo1);
			     collegePojo.setAllCoursesPojo(allCoursePojo);
			     
	                }
	        
	        if(result.isPresent()){
	        	
	        	PaymentPojo paymentPojo = new PaymentPojo();
	        	PaymentEntity paymentEntity = result.get().getPaymentEntity();
	        	
	        	BeanUtils.copyProperties(paymentEntity, paymentPojo);
	        	allApplicationPojo.setPaymentPojo(paymentPojo);

	        	AdmissionPojo admissionPojo = new AdmissionPojo();
	        	AdmissionEntity admissionEntity = result.get().getAdmissionEntity();
	        	if(admissionEntity != null) {
	        		BeanUtils.copyProperties(admissionEntity, admissionPojo);
	        	}
	        	//BeanUtils.copyProperties(admissionEntity, admissionPojo);
	        	
	        	allApplicationPojo.setAdmissionPojo(admissionPojo);
	                
	        	BeanUtils.copyProperties(result.get(), allApplicationPojo);
	        	allApplicationPojo.setCollegePojo(collegePojo);
	        	
	         }
	        return allApplicationPojo;
		} 
	
	
}
