package com.jpa.practice.jpaPractice.hrms;

import com.jpa.practice.jpaPractice.hrms.enums.InterviewStatus;
import com.jpa.practice.jpaPractice.hrms.enums.InterviewType;

public class HttpInterviewPanel {

	private int tableid;
	
	private int candidateid;
	
	private String candidateName;
	
	private String jobreqid;
	
	private InterviewType interviewType;
	
	private String intComments;
	
	private int intRating;
	
	private InterviewStatus intStatus;

	public int getTableid() {
		return tableid;
	}

	public void setTableid(int tableid) {
		this.tableid = tableid;
	}

	public int getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(int candidateid) {
		this.candidateid = candidateid;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getJobreqid() {
		return jobreqid;
	}

	public void setJobreqid(String jobreqid) {
		this.jobreqid = jobreqid;
	}

	public InterviewType getInterviewType() {
		return interviewType;
	}

	public void setInterviewType(InterviewType interviewType) {
		this.interviewType = interviewType;
	}

	public String getIntComments() {
		return intComments;
	}

	public void setIntComments(String intComments) {
		this.intComments = intComments;
	}

	public int getIntRating() {
		return intRating;
	}

	public void setIntRating(int intRating) {
		this.intRating = intRating;
	}

	public InterviewStatus getIntStatus() {
		return intStatus;
	}

	public void setIntStatus(InterviewStatus intStatus) {
		this.intStatus = intStatus;
	}
}
