package com.onlineadmission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmission.dao.AdmissionJpaDao;
import com.onlineadmission.entity.AdmissionEntity;
import com.onlineadmission.entity.ApplicationEntity;
import com.onlineadmission.exception.AdmissionNotFoundException;
import com.onlineadmission.pojo.AdmissionPojo;
import com.onlineadmission.pojo.ApplicationPojo;

@Service
public class AdmissionServiceImpl implements AdmissionService{
		
		@Autowired
		AdmissionJpaDao admissionJpaDao;
		
		public AdmissionServiceImpl() {
		}

		@Override
		public List<AdmissionPojo> getAllAdmissions() {
			
			  List<AdmissionEntity> allAdmissions =  admissionJpaDao.findAll();
			  List<AdmissionPojo> allAdmissionPojo = new ArrayList<>();
			  for(AdmissionEntity admissionEntity: allAdmissions) {
				  
				  AdmissionPojo admissionPojo = new AdmissionPojo();
				  BeanUtils.copyProperties(admissionEntity, admissionPojo);
				  
				  ApplicationEntity applicationEntity = admissionEntity.getApplicationEntity();
				  ApplicationPojo applicationPojo= new ApplicationPojo();
				  BeanUtils.copyProperties(applicationEntity, applicationPojo);
				  admissionPojo.setApplicationPojo(applicationPojo);
				  allAdmissionPojo.add(admissionPojo);
				  
			  }
		        if(allAdmissions.isEmpty()) {
		            throw new AdmissionNotFoundException("No Admissions Found");
		        }
				return allAdmissionPojo;
			  }

		@Override
		public AdmissionPojo getAdmission(int admissionId) {
			AdmissionEntity admissionEntity = new AdmissionEntity();
			AdmissionPojo admissionPojo = new AdmissionPojo();
			Optional<AdmissionEntity> result = admissionJpaDao.findById(admissionId);
			
			if(result.isPresent()) {
				ApplicationEntity applicationEntity = result.get().getApplicationEntity();
				ApplicationPojo applicationPojo = new ApplicationPojo();
				BeanUtils.copyProperties(applicationEntity, applicationPojo);
				BeanUtils.copyProperties(result.get(),  admissionPojo);
				 
				admissionPojo.setApplicationPojo(applicationPojo);
			}
			return admissionPojo;
		}
	}

