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

import com.onlineadmission.pojo.BranchPojo;
import com.onlineadmission.service.BranchService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	@GetMapping("/branches")
	public List<BranchPojo> getAllBranches(){
		return branchService.getAllBranches();
	}
	
	@GetMapping("/branches/{branchId}")
	public BranchPojo getBranch(@PathVariable("branchId") int branchId) {
		return branchService.getBranch(branchId);
	}
	
	@PostMapping("/branches")
	public BranchPojo addBranch(@Valid @RequestBody BranchPojo branch) {
		return branchService.addBranch(branch);
	}
	
	@PutMapping("/branches")
	public BranchPojo updateBranch(@RequestBody BranchPojo branch) {
		return branchService.updateBranch(branch);
	}
	
	@DeleteMapping("/branches/{branchId}")
	public boolean deleteBranch(@PathVariable("branchId") int branchId){
		return branchService.deleteBranch(branchId);
	}
	
	

}
