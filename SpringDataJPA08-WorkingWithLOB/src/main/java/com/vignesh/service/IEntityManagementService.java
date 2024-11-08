package com.vignesh.service;

import com.vignesh.entity.MarriageSeeker1;

public interface IEntityManagementService {
	
	public String registerMarriageSeeker(MarriageSeeker1 marriageSeeker);
	public MarriageSeeker1 getMarriageSeekerById(Long id);

}
