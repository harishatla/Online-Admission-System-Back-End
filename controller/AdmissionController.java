package com.onlineadmission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmission.entity.AdmissionEntity;
import com.onlineadmission.pojo.AdmissionPojo;
import com.onlineadmission.service.AdmissionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class AdmissionController {
			
			@Autowired
			AdmissionService admissionService;
			
			@GetMapping("/admissions")
			public List<AdmissionPojo> getAllAdmissions(){
				List<AdmissionPojo> allAdmission = admissionService.getAllAdmissions();
				return allAdmission;
			}
			
			@GetMapping("/admissions/{admissionId}")
			public AdmissionPojo getAdmission(@PathVariable("admissionId") int admissionId) {
				
				return admissionService.getAdmission(admissionId);
			}
			 
		}
