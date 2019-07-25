package com.ventura.opportunity.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "opportunity")
public class Opportunity {

	@Id
	private String id;
	private String sfId;
	private Date positionStartDate;
	private String portfolio;
	private String clientOwner;
	private String programName;
	private String position;
	private String ltiPoc;
	private String recruitmentPoc;
	private Integer numberOfPositions;
	private Integer candidatesIdentified;
	private Date dateCreated;

	public Opportunity() {
	}

	public Opportunity(String sfId, Date positionStartDate, String portfolio, String clientOwner, String programName,
			String position, String ltiPoc, String recruitmentPoc, Integer numberOfPositions,
			Integer candidatesIdentified, Date dateCreated) {
		super();
		this.sfId = sfId;
		this.positionStartDate = positionStartDate;
		this.portfolio = portfolio;
		this.clientOwner = clientOwner;
		this.programName = programName;
		this.position = position;
		this.ltiPoc = ltiPoc;
		this.recruitmentPoc = recruitmentPoc;
		this.numberOfPositions = numberOfPositions;
		this.candidatesIdentified = candidatesIdentified;
		this.dateCreated = dateCreated;
	}

	public Date getPositionStartDate() {
		return positionStartDate;
	}

	public void setPositionStartDate(Date positionStartDate) {
		this.positionStartDate = positionStartDate;
	}

	public String getSfId() {
		return sfId;
	}

	public void setSfId(String sfId) {
		this.sfId = sfId;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public String getClientOwner() {
		return clientOwner;
	}

	public void setClientOwner(String clientOwner) {
		this.clientOwner = clientOwner;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLtiPoc() {
		return ltiPoc;
	}

	public void setLtiPoc(String ltiPoc) {
		this.ltiPoc = ltiPoc;
	}

	public String getRecruitmentPoc() {
		return recruitmentPoc;
	}

	public void setRecruitmentPoc(String recruitmentPoc) {
		this.recruitmentPoc = recruitmentPoc;
	}

	public Integer getNumberOfPositions() {
		return numberOfPositions;
	}

	public void setNumberOfPositions(Integer numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}

	public Integer getCandidatesIdentified() {
		return candidatesIdentified;
	}

	public void setCandidatesIdentified(Integer candidatesIdentified) {
		this.candidatesIdentified = candidatesIdentified;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String toString() {
		return String.format(
				"Oportunity [SF ID=%s, Position Start Date=%s, Portfolio=%s, Client Owner=%s, Program Name=%s, Position=%s, LTI POC=%s, Recruitment POC=%s, Number of Positions=%s, Candidates Identified=%s]",
				sfId, positionStartDate, portfolio, clientOwner, programName, position, ltiPoc, recruitmentPoc,
				numberOfPositions, candidatesIdentified, dateCreated);
	}

}
