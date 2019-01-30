package com.jpa.practice.jpaPractice.hrms.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.practice.jpaPractice.hrms.enums.ApproverStatus;
import com.jpa.practice.jpaPractice.hrms.enums.EmploymentType;
import com.jpa.practice.jpaPractice.hrms.enums.JobStatus;
import com.jpa.practice.jpaPractice.hrms.enums.UserRoles;
import com.jpa.practice.jpaPractice.authentication.model.security.User;
import com.jpa.practice.jpaPractice.hrms.AuthorityH;
import com.jpa.practice.jpaPractice.hrms.JobRequests;

@Repository
@Transactional
public class TestPersist {

	@Autowired
	private EntityManager em;
	
	public void addJobRequests(){
		User requestorId = em.find(User.class, 3L);
		
		JobRequests jobReq = new JobRequests();
		jobReq.setJobreqid("JOB_REQ_1");
		jobReq.setRequestorId(requestorId);
		jobReq.setReqDept("IT");
		jobReq.setReqDate(new Date());
		jobReq.setPosTitle("Technical Analyst");
		jobReq.setJobDesc("Software Programming");
		jobReq.setJobResp("Software Job Responsibilities");
		jobReq.setSkills("AS400");
		jobReq.setReqEdu("MCA or B.Tech");
		jobReq.setJobExp("2 to 4 years");
		jobReq.setComments("Permanent Role");
		jobReq.setVacancies(2);
		
		User authH2 = em.find(User.class, 4L);
		jobReq.setMgrAuthId(authH2);
		jobReq.setMastatus(ApproverStatus.Approved);
		jobReq.setMgrComm("Approved Danny");
		
		User authH4 = em.find(User.class, 5L);
		jobReq.setFinAuthId(authH4);
		jobReq.setFinstatus(ApproverStatus.Approved);
		jobReq.setFinComm("Finance Approved");
		
		User authH5 = em.find(User.class, 7L);
		jobReq.setMgmAuthId(authH5);
		jobReq.setMgmComm("Management Approved");
		jobReq.setMgmstatus(ApproverStatus.Approved);
		jobReq.setEmpType(EmploymentType.Permanent);
		jobReq.setJobstatus(JobStatus.Approved);
		
		em.persist(jobReq);
	}
	
	public List<AuthorityH> findAllAuthorities() {
		TypedQuery<AuthorityH> createQuery = em.createQuery("Select a from AuthorityH a", AuthorityH.class);
		List<AuthorityH> resultList = createQuery.getResultList();
		return resultList;
	}
	
	public List<JobRequests> findAllJobRequests() {
		TypedQuery<JobRequests> createQuery = em.createQuery("Select j from JobReq j", JobRequests.class);
		List<JobRequests> resultList = createQuery.getResultList();
		return resultList;
	}

	public AuthorityH addAuthUser(AuthorityH authUser) {
		
		em.persist(authUser);
		return authUser;
	}
}
