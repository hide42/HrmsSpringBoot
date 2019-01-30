package com.jpa.practice.jpaPractice.hrms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.jpa.practice.jpaPractice.hrms.enums.InterviewStatus;

@Entity(name="interviewPanel")
@Table(name="interviewPanel")
public class InterviewPanel {

	@Id 
	@TableGenerator(name="InterviewPanelSequence", pkColumnName="pkCol", pkColumnValue="InterviewPanelSeq", table="Table_Seq")
	@GeneratedValue(generator="InterviewPanelSequence")
	private int tableid;
	
	@OneToOne
	private Candidate candidate;
	
	@ManyToOne
	private AuthorityH telPanel;
	private String telComments;
	private int telRating;
	private InterviewStatus telStatus;
	
	@ManyToOne
	private AuthorityH tech1Panel;
	private String tech1Comments;
	private int tech1Rating;
	private InterviewStatus tech1Status;
	
	@ManyToOne
	private AuthorityH tech2Panel;
	private String tech2Comments;
	private int tech2Rating;
	private InterviewStatus tech2Status;
	
	@ManyToOne
	private AuthorityH mgrPanel;
	private String mgrComments;
	private int mgrRating;
	private InterviewStatus mgrStatus;
	
	@ManyToOne
	private AuthorityH hrPanel;
	private String hrComments;
	private int hrRating;
	private InterviewStatus hrStatus;
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public AuthorityH getTelPanel() {
		return telPanel;
	}
	public void setTelPanel(AuthorityH telPanel) {
		this.telPanel = telPanel;
	}
	public String getTelComments() {
		return telComments;
	}
	public void setTelComments(String telComments) {
		this.telComments = telComments;
	}
	public int getTelRating() {
		return telRating;
	}
	public void setTelRating(int telRating) {
		this.telRating = telRating;
	}
	public InterviewStatus getTelStatus() {
		return telStatus;
	}
	public void setTelStatus(InterviewStatus telStatus) {
		this.telStatus = telStatus;
	}
	public AuthorityH getTech1Panel() {
		return tech1Panel;
	}
	public void setTech1Panel(AuthorityH tech1Panel) {
		this.tech1Panel = tech1Panel;
	}
	public String getTech1Comments() {
		return tech1Comments;
	}
	public void setTech1Comments(String tech1Comments) {
		this.tech1Comments = tech1Comments;
	}
	public int getTech1Rating() {
		return tech1Rating;
	}
	public void setTech1Rating(int tech1Rating) {
		this.tech1Rating = tech1Rating;
	}
	public InterviewStatus getTech1Status() {
		return tech1Status;
	}
	public void setTech1Status(InterviewStatus tech1Status) {
		this.tech1Status = tech1Status;
	}
	public AuthorityH getTech2Panel() {
		return tech2Panel;
	}
	public void setTech2Panel(AuthorityH tech2Panel) {
		this.tech2Panel = tech2Panel;
	}
	public String getTech2Comments() {
		return tech2Comments;
	}
	public void setTech2Comments(String tech2Comments) {
		this.tech2Comments = tech2Comments;
	}
	public int getTech2Rating() {
		return tech2Rating;
	}
	public void setTech2Rating(int tech2Rating) {
		this.tech2Rating = tech2Rating;
	}
	public InterviewStatus getTech2Status() {
		return tech2Status;
	}
	public void setTech2Status(InterviewStatus tech2Status) {
		this.tech2Status = tech2Status;
	}
	public AuthorityH getMgrPanel() {
		return mgrPanel;
	}
	public void setMgrPanel(AuthorityH mgrPanel) {
		this.mgrPanel = mgrPanel;
	}
	public String getMgrComments() {
		return mgrComments;
	}
	public void setMgrComments(String mgrComments) {
		this.mgrComments = mgrComments;
	}
	public int getMgrRating() {
		return mgrRating;
	}
	public void setMgrRating(int mgrRating) {
		this.mgrRating = mgrRating;
	}
	public InterviewStatus getMgrStatus() {
		return mgrStatus;
	}
	public void setMgrStatus(InterviewStatus mgrStatus) {
		this.mgrStatus = mgrStatus;
	}
	public AuthorityH getHrPanel() {
		return hrPanel;
	}
	public void setHrPanel(AuthorityH hrPanel) {
		this.hrPanel = hrPanel;
	}
	public String getHrComments() {
		return hrComments;
	}
	public void setHrComments(String hrComments) {
		this.hrComments = hrComments;
	}
	public int getHrRating() {
		return hrRating;
	}
	public void setHrRating(int hrRating) {
		this.hrRating = hrRating;
	}
	public InterviewStatus getHrStatus() {
		return hrStatus;
	}
	public void setHrStatus(InterviewStatus hrStatus) {
		this.hrStatus = hrStatus;
	}
	public InterviewPanel() {
		super();
	}
}
