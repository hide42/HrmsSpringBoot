package com.jpa.practice.jpaPractice.hrms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.practice.jpaPractice.authentication.model.security.Authority;
import com.jpa.practice.jpaPractice.authentication.model.security.User;
import com.jpa.practice.jpaPractice.hrms.JobRequests;
import com.jpa.practice.jpaPractice.hrms.enums.ApproverStatus;
import com.jpa.practice.jpaPractice.hrms.enums.JobStatus;

@Repository
@Transactional
public class JobRepository {

	@Autowired
	private EntityManager em;
	
	public List<JobRequests> findAllJobs(){
		TypedQuery<JobRequests> createQuery = em.createQuery("Select j from JobReq j", JobRequests.class);
		List<JobRequests> resultList = createQuery.getResultList();
		return resultList;
	}

	public JobRequests createJob(JobRequests jobReq) {
		em.persist(jobReq);
		int reqid = jobReq.getReqId();
		jobReq.setJobreqid("JOB_REQ_" + Integer.toString(reqid));
		
		return jobReq;
	}

	public List<JobRequests> findUserJobs(String userid) {
	
			User find = em.find(User.class, Long.parseLong(userid));
			List<Authority> authorities = find.getAuthorities();		
			Authority find2 = em.find(Authority.class, 2L);
			if(authorities.contains(find2)){
				TypedQuery<JobRequests> createQuery = em.createQuery("select j from JobReq j", JobRequests.class);
				List<JobRequests> resultList = createQuery.getResultList();
				return resultList;
			}
			else {  
			TypedQuery<JobRequests> createQuery = em.createQuery("select j from JobReq j where j.requestorId.id=:reqId or j.mgrAuthId.id=:mgrId or j.finAuthId.id=:finId or j.mgmAuthId.id=:mgmId", JobRequests.class);
			createQuery.setParameter("reqId", Long.parseLong(userid));
			createQuery.setParameter("mgrId", Long.parseLong(userid));
			createQuery.setParameter("finId", Long.parseLong(userid));
			createQuery.setParameter("mgmId", Long.parseLong(userid));
			List<JobRequests> resultList = createQuery.getResultList();
			return resultList;
			}
	}

	public JobRequests findJobUsingId(String jobid) {
		JobRequests find = em.find(JobRequests.class, Integer.parseInt(jobid));
		return find;
	}

	public JobRequests upd(JobRequests job) {
		if(job.getMastatus()== ApproverStatus.Approved &&
				job.getFinstatus() == ApproverStatus.Approved
				&& job.getMgmstatus() == ApproverStatus.Approved)
		{
			job.setJobstatus(JobStatus.Approved);
		}	
		em.merge(job);
		
		return job;
	}
}
