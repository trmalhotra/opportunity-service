package com.ventura.opportunity.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ventura.opportunity.model.Opportunity;

@Repository
public class OpportunityRepositoryImpl implements OpportunityRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public OpportunityRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Opportunity addNewOpportunity(Opportunity opportunity) {
		return mongoTemplate.save(opportunity);
	}

	@Override
	public List<Opportunity> getAllOpportunities() {
		Query query = new Query();
		return mongoTemplate.find(query, Opportunity.class);
	}

}
