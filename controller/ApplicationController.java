package com.onlineadmission.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmission.pojo.ApplicationPojo;
import com.onlineadmission.service.ApplicationService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@GetMapping("/applications")
	public List<ApplicationPojo> getAllApplications(){
	return applicationService.getAllApplications();
	}

	@GetMapping("/applications/{applicationId}")
	public ApplicationPojo getApplication(@PathVariable("applicationId") int applicationId) {
		return applicationService.getApplication(applicationId);
	}
	
	@PostMapping("/applications")
	public ApplicationPojo addApplication(@Valid @RequestBody ApplicationPojo application) {
		return applicationService.addApplication(application);
	}
	
	@PutMapping("/applications")
	public ApplicationPojo updateApplication(@Valid @RequestBody ApplicationPojo application) {
		return applicationService.updateApplication(application);
	}
	
	 

}
