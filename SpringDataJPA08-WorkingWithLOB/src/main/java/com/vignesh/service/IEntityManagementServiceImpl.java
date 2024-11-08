package com.vignesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.dao.IEntityRepository;
import com.vignesh.entity.MarriageSeeker1;

@Service
public class IEntityManagementServiceImpl implements IEntityManagementService {
	@Autowired
	IEntityRepository entityRepository;
	
	@Override
	public String registerMarriageSeeker(MarriageSeeker1 marriageSeeker) {
		// TODO Auto-generated method stub
		marriageSeeker = entityRepository.save(marriageSeeker);
		return "The Marriage Seeker with id: "+marriageSeeker.getId()+" is registered.";
	}

	@Override
	public MarriageSeeker1 getMarriageSeekerById(Long id) {
		// TODO Auto-generated method stub
		return entityRepository.findById(id).get();
	}

}
