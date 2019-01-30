package com.jpa.practice.jpaPractice.hrms;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.jpa.practice.jpaPractice.hrms.enums.InterviewStatus;

@Entity
public class InterviewPanel2 {

	@Id 
	@TableGenerator(name="InterviewPanelSequence", pkColumnName="pkCol", pkColumnValue="InterviewPanel2Seq", table="Table_Seq")
	@GeneratedValue(generator="InterviewPanelSequence")
	private int tableid;
	
	@OneToOne
	private Candidate candidate;
	
	@ElementCollection
	@CollectionTable(name="Panel_Rating")
	private List<IndividualInterviews> indInterviews;
	
	public int getTableid() {
		return tableid;
	}

	public void setTableid(int tableid) {
		this.tableid = tableid;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public List<IndividualInterviews> getIndInterviews() {
		return indInterviews;
	}

	public void setIndInterviews(List<IndividualInterviews> indInterviews) {
		this.indInterviews = indInterviews;
	}

	public InterviewPanel2() {
		super();
	}
}
