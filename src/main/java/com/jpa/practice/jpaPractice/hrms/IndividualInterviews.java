package com.jpa.practice.jpaPractice.hrms;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import com.jpa.practice.jpaPractice.authentication.model.security.User;
import com.jpa.practice.jpaPractice.hrms.enums.InterviewStatus;
import com.jpa.practice.jpaPractice.hrms.enums.InterviewType;

@Embeddable
public class IndividualInterviews {

	private InterviewType interviewType;
	@OneToOne
	private User intPanel;
	private String intComments;
	private int intRating;
	@Enumerated(EnumType.STRING)
	private InterviewStatus intStatus;
	public InterviewType getInterviewType() {
		return interviewType;
	}
	public void setInterviewType(InterviewType interviewType) {
		this.interviewType = interviewType;
	}
	
	public User getIntPanel() {
		return intPanel;
	}
	public void setIntPanel(User intPanel) {
		this.intPanel = intPanel;
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
	public IndividualInterviews() {
		super();
	}

	
	
}
