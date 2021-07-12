package com.onlineadmission.service;

import java.util.List;

import com.onlineadmission.pojo.BranchPojo;

public interface BranchService {
	
	  public List<BranchPojo> getAllBranches();
	    
	    public BranchPojo addBranch(BranchPojo branch);
	    
	    public BranchPojo getBranch(int branchId);
	    
	    public BranchPojo updateBranch(BranchPojo updateBranch);

		public boolean deleteBranch(int branchId);
}
