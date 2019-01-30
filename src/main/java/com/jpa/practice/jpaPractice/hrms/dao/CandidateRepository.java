package com.jpa.practice.jpaPractice.hrms.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.practice.jpaPractice.hrms.Candidate;
import com.jpa.practice.jpaPractice.hrms.JobRequests;
import com.jpa.practice.jpaPractice.hrms.enums.InterviewStatus;

@Repository
@Transactional
public class CandidateRepository {

	@Autowired
	private EntityManager em;
	
	public List<Candidate> findAll(){
		TypedQuery<Candidate> createQuery = em.createQuery("Select c from Candidate c", Candidate.class);
		List<Candidate> resultList = createQuery.getResultList();
		return resultList;
	}
	
	public Candidate findCandidate(int candidateId){
		Candidate candidate = em.find(Candidate.class, candidateId);
		return candidate;
	}
	
	public void addCandidates(){
		Candidate c = new Candidate();
		JobRequests jobReq = em.find(JobRequests.class, 1);
		c.setJobreqid(jobReq);
		c.setFirstName("First Name 1");
		c.setLastName("Last Name 1");
		c.setEmailId("emailid@email.com");
		c.setTelephone("9876543210");
		c.setCanResume("Resume Path location");
		c.setTelStatus(InterviewStatus.NotDecided);
		c.setTech1Status(InterviewStatus.NotDecided);
		c.setTech2Status(InterviewStatus.NotDecided);
		c.setMgrStatus(InterviewStatus.NotDecided);
		c.setHrStatus(InterviewStatus.NotDecided);
		c.setOfrRls(InterviewStatus.NotDecided);
		c.setOfrAccept(InterviewStatus.NotDecided);
		c.setBckgVerify(InterviewStatus.NotDecided);
		c.setJoinedOrg(InterviewStatus.NotDecided);
		c.setJoinDate(new Date());
		em.persist(c);
	}
	
	public Candidate addCandidateRecord(Candidate c){
		em.persist(c);
		return c;
	}
}
