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

import com.onlineadmission.pojo.CoursePojo;
import com.onlineadmission.service.CourseService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/courses")
	public List<CoursePojo> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@PostMapping("/courses")
	public CoursePojo addCourse(@Valid @RequestBody CoursePojo course) {
		return courseService.addCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public boolean deleteCourse(@PathVariable("courseId") int courseId){
		return courseService.deleteCourse(courseId);
	}
	
	@GetMapping("/courses/{courseId}")
	public CoursePojo getCourse(@PathVariable("courseId") int courseId) {
		return courseService.getCourse(courseId);
	}
	
	@PutMapping("/courses")
	public CoursePojo updateCourse(@RequestBody CoursePojo course) {
		return courseService.updateCourse(course);
	}
	
}

























































































































