package com.jpa.practice.jpaPractice.hrms;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpa.practice.jpaPractice.authentication.model.security.User;
import com.jpa.practice.jpaPractice.hrms.enums.ApproverStatus;
import com.jpa.practice.jpaPractice.hrms.enums.EmploymentType;
import com.jpa.practice.jpaPractice.hrms.enums.JobStatus;

@Entity(name="JobReq")
@Table(name="jobreq")
public class JobRequests {

	@Id
	@TableGenerator(name="JobReqSequence", pkColumnName="pkCol", pkColumnValue="JobReqSeq", table="Table_Seq")
	@GeneratedValue(generator="JobReqSequence")
	private int reqId;
	
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	private String jobreqid;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User requestorId;
	
	@NotNull(message="cannot be null")
	@NotBlank(message="cannot be blank")
	private String reqDept;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date reqDate;
	
	@NotBlank(message="cannot be blank")
	private String posTitle;
	
	@NotBlank(message="cannot be blank")
	private String jobDesc;
	
	@NotBlank(message="cannot be blank")
	private String jobResp;
	
	@NotBlank(message="cannot be blank")
	private String skills;
	
	@NotBlank(message="cannot be blank")
	private String reqEdu;
	
	@NotBlank(message="cannot be blank")
	private String jobExp;
	
	@NotBlank(message="cannot be blank")
	private String comments;
	
	@NotNull(message="cannot br null")
	private Integer vacancies;
	
	@OneToOne(fetch=FetchType.EAGER)
	private User mgrAuthId;
	
	private ApproverStatus mastatus;
	
	@Transient
	@JsonIgnore
	private LinkedHashMap<String, String> mgrApprover;
	
	private String mgrComm;
	
	@OneToOne(fetch=FetchType.EAGER)
	private User finAuthId;
	
	private ApproverStatus finstatus;
	
	private String finComm;
	
	@OneToOne(fetch=FetchType.EAGER)
	private User mgmAuthId;
	
	private ApproverStatus mgmstatus;
	
	private String mgmComm;
	
	private EmploymentType empType;
	
	private JobStatus jobstatus;
	@OneToOne(mappedBy="jobreqid")
	@JsonIgnore
	private Candidate candidate;
	
	@Transient
	@JsonIgnore
	private LinkedHashMap<String, String> pendingStatus;
	@Transient
	@JsonIgnore
	private String Status;
		
	@Transient
	@JsonIgnore
	private LinkedHashMap<String, String> department;
	
	public int getReqId() {
		return reqId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public JobRequests() {		
	}

	public String getJobreqid() {
		return jobreqid;
	}

	public void setJobreqid(String jobreqid) {
		this.jobreqid = jobreqid;
	}

	public String getReqDept() {
		return reqDept;
	}

	public void setReqDept(String reqDept) {
		this.reqDept = reqDept;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public String getPosTitle() {
		return posTitle;
	}

	public void setPosTitle(String posTitle) {
		this.posTitle = posTitle;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobResp() {
		return jobResp;
	}

	public void setJobResp(String jobResp) {
		this.jobResp = jobResp;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getReqEdu() {
		return reqEdu;
	}

	public void setReqEdu(String reqEdu) {
		this.reqEdu = reqEdu;
	}

	public String getJobExp() {
		return jobExp;
	}

	public void setJobExp(String jobExp) {
		this.jobExp = jobExp;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getVacancies() {
		return vacancies;
	}

	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}

	public ApproverStatus getMastatus() {
		return mastatus;
	}

	public void setMastatus(ApproverStatus mastatus) {
		this.mastatus = mastatus;
	}

	public LinkedHashMap<String, String> getMgrApprover() {
		return mgrApprover;
	}

	public void setMgrApprover(LinkedHashMap<String, String> mgrApprover) {
		this.mgrApprover = mgrApprover;
	}

	public String getMgrComm() {
		return mgrComm;
	}

	public void setMgrComm(String mgrComm) {
		this.mgrComm = mgrComm;
	}

	public ApproverStatus getFinstatus() {
		return finstatus;
	}

	public void setFinstatus(ApproverStatus finstatus) {
		this.finstatus = finstatus;
	}

	public String getFinComm() {
		return finComm;
	}

	public void setFinComm(String finComm) {
		this.finComm = finComm;
	}

	
	public User getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(User requestorId) {
		this.requestorId = requestorId;
	}

	public User getMgrAuthId() {
		return mgrAuthId;
	}

	public void setMgrAuthId(User mgrAuthId) {
		this.mgrAuthId = mgrAuthId;
	}

	public User getFinAuthId() {
		return finAuthId;
	}

	public void setFinAuthId(User finAuthId) {
		this.finAuthId = finAuthId;
	}

	public User getMgmAuthId() {
		return mgmAuthId;
	}

	public void setMgmAuthId(User mgmAuthId) {
		this.mgmAuthId = mgmAuthId;
	}

	public ApproverStatus getMgmstatus() {
		return mgmstatus;
	}

	public void setMgmstatus(ApproverStatus mgmstatus) {
		this.mgmstatus = mgmstatus;
	}

	public String getMgmComm() {
		return mgmComm;
	}

	public void setMgmComm(String mgmComm) {
		this.mgmComm = mgmComm;
	}

	public EmploymentType getEmpType() {
		return empType;
	}

	public void setEmpType(EmploymentType empType) {
		this.empType = empType;
	}

	public JobStatus getJobstatus() {
		return jobstatus;
	}

	public void setJobstatus(JobStatus approved) {
		this.jobstatus = approved;
	}

	public LinkedHashMap<String, String> getPendingStatus() {
		return pendingStatus;
	}

	public void setPendingStatus(LinkedHashMap<String, String> pendingStatus) {
		this.pendingStatus = pendingStatus;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public LinkedHashMap<String, String> getDepartment() {
		return department;
	}

	public void setDepartment(LinkedHashMap<String, String> department) {
		this.department = department;
	}	
	
}

