package com.jpa.practice.jpaPractice.hrms;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpa.practice.jpaPractice.hrms.enums.UserRoles;

@Entity
@Table(name="Authorities")
public class AuthorityH {

	@Id
	@TableGenerator(name="AuthoritySequence", pkColumnName="pkCol", pkColumnValue="AuthUsersSeq", table="Table_Seq")
	@GeneratedValue(generator="AuthoritySequence")
	private int id;
	
	@Enumerated()
	private String username;
	
	@Column(name="authority")
	@Enumerated(EnumType.STRING)
	private UserRoles roles;

	@OneToMany(mappedBy="requestorId")
	@JsonIgnore
	private List<JobRequests> jobReqId = new ArrayList<JobRequests>();

	@OneToMany(mappedBy="telPanel")
	@JsonIgnore
	private List<InterviewPanel> interview_tel_Panel;
	
	@OneToMany(mappedBy="tech1Panel")
	@JsonIgnore
	private List<InterviewPanel> interview_tech1_Panel;
	
	@OneToMany(mappedBy="tech2Panel")
	@JsonIgnore
	private List<InterviewPanel> interview_tech2_Panel;
	
	@OneToMany(mappedBy="mgrPanel")
	@JsonIgnore
	private List<InterviewPanel> interview_mgr_Panel;
	
	@OneToMany(mappedBy="hrPanel")
	@JsonIgnore
	private List<InterviewPanel> interview_hr_Panel;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	

	public AuthorityH(){}
	
	public void setUsername(String username) {
		this.username = username;
	}

	

	public UserRoles getRoles() {
		return roles;
	}

	public void setRoles(UserRoles roles) {
		this.roles = roles;
	}

	public AuthorityH(String username, UserRoles roles) {
		super();
		this.username = username;
		this.roles = roles;
	}

	public List<JobRequests> getJobReqId() {
		return jobReqId;
	}

	public void addJobReqId(JobRequests jobReqId) {
		this.jobReqId.add(jobReqId);
	}
	
	public void removeJobReqId(JobRequests jobReqId) {
		this.jobReqId.remove(jobReqId);
	}
	
}
