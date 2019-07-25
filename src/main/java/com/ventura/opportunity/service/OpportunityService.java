package com.ventura.opportunity.service;

import java.util.List;

import com.ventura.opportunity.model.Opportunity;

public interface OpportunityService {

	public Opportunity addNewOpportunity(Opportunity opportunity);
	
	public List<Opportunity> getAllOpportunities();
	
}
