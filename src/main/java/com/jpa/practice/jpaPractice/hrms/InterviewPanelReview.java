package com.jpa.practice.jpaPractice.hrms;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import com.jpa.practice.jpaPractice.hrms.enums.ApproverStatus;

@Embeddable
public class InterviewPanelReview {

	@OneToOne
	private AuthorityH interviewer;
	
	@Enumerated(EnumType.STRING)
	private ApproverStatus status;
	
	private String comments;

	public AuthorityH getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(AuthorityH interviewer) {
		this.interviewer = interviewer;
	}

	public ApproverStatus getStatus() {
		return status;
	}

	public void setStatus(ApproverStatus status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
