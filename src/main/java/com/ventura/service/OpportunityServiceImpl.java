package com.ventura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.model.Opportunity;
import com.ventura.repository.OpportunityRepository;

@Service
public class OpportunityServiceImpl implements OpportunityService {
	
	@Autowired
	private OpportunityRepository opportunityRepository;

	public Opportunity addNewOpportunity(Opportunity opportunity) {
		return opportunityRepository.addNewOpportunity(opportunity);
	}
	
	public List<Opportunity> getAllOpportunities() {
		return opportunityRepository.getAllOpportunities();
	}

}
