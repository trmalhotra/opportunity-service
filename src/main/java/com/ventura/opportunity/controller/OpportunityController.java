package com.ventura.opportunity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ventura.opportunity.model.Opportunity;
import com.ventura.opportunity.service.OpportunityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/ventura/opportunity")
@Api(value = "Opportunity Management")
public class OpportunityController {

	@Autowired
	private OpportunityService opportunityService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	 
	@ApiOperation(value = "Add an Opportunity")
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ResponseEntity<Opportunity> addNewOpportunity(
			@ApiParam(value = "Opportunity object store in database table", required = true) @Valid @RequestBody Opportunity opportunity) {
		Opportunity opportunityAdded = null;
		try {
			opportunityAdded = opportunityService.addNewOpportunity(opportunity);
		}  catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (opportunityAdded == null || opportunityAdded.getPosition() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(opportunityAdded, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Get all Opportunities", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved opportunities"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = "application/json")
	public ResponseEntity<List<Opportunity>> getAllOpportunities() {
		List<Opportunity> opportunityList = new ArrayList<Opportunity>();
		try {
			opportunityList = opportunityService.getAllOpportunities();
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (opportunityList.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(opportunityList, HttpStatus.OK);
		}
	}

}
