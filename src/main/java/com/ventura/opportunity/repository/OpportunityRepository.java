package com.ventura.opportunity.repository;

import java.util.List;

import com.ventura.opportunity.model.Opportunity;

public interface OpportunityRepository {
	
	public Opportunity addNewOpportunity(Opportunity opportunity);
	
	public List<Opportunity> getAllOpportunities();

}
