package com.onlineadmission.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmission.pojo.CollegePojo;
import com.onlineadmission.service.CollegeService;


	@CrossOrigin
	@RestController
	@RequestMapping("/api")
	public class CollegeController  {
		
		@Autowired
		CollegeService collegeService;
		
		@PostMapping("/colleges")
		public CollegePojo addCollege(@Valid @RequestBody CollegePojo college) {
			return collegeService.addCollege(college);
		}
		
		@GetMapping("/colleges")
		public List<CollegePojo> getAllColleges(){
			return collegeService.getAllColleges();
		}
		
		@DeleteMapping("/colleges/{collegeId}")
		public boolean deleteCollege(@PathVariable("collegeId") int collegeId){
			return collegeService.deleteCollege(collegeId);
		}
		
		@GetMapping("/colleges/{collegeId}")
		public CollegePojo getCollege(@PathVariable("collegeId") int collegeId) {
			return collegeService.getCollege(collegeId);
		}
		
		@PutMapping("/colleges")
		public CollegePojo updateCollege(@Valid @RequestBody CollegePojo updateCollege) {
			return collegeService.updateCollege(updateCollege);
		}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
