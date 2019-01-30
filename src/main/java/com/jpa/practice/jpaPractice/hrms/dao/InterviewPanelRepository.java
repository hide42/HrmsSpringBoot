package com.jpa.practice.jpaPractice.hrms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.practice.jpaPractice.authentication.model.security.User;
import com.jpa.practice.jpaPractice.hrms.AuthorityH;
import com.jpa.practice.jpaPractice.hrms.Candidate;
import com.jpa.practice.jpaPractice.hrms.HttpInterviewPanel;
import com.jpa.practice.jpaPractice.hrms.IndividualInterviews;
import com.jpa.practice.jpaPractice.hrms.InterviewPanel;
import com.jpa.practice.jpaPractice.hrms.InterviewPanel2;
import com.jpa.practice.jpaPractice.hrms.enums.InterviewStatus;
import com.jpa.practice.jpaPractice.hrms.enums.InterviewType;

@Repository
@Transactional
public class InterviewPanelRepository {

	@Autowired
	private EntityManager em;
	
	public void addInterviewPanelRecords() {
		InterviewPanel ip = new InterviewPanel();
		Candidate find = em.find(Candidate.class, 1);
		ip.setCandidate(find);
		AuthorityH telPanel = em.find(AuthorityH.class, 1);
		ip.setTelPanel(telPanel);
		ip.setTelRating(3);
		ip.setTelStatus(InterviewStatus.NotDecided);
		ip.setTelComments("Good in telephone");
		
		AuthorityH tech1Panel = em.find(AuthorityH.class, 1);
		ip.setTech1Panel(tech1Panel);
		ip.setTech1Rating(4);
		ip.setTech1Status(InterviewStatus.Pass);
		ip.setTech1Comments("Good in technical 1 round");
		
		AuthorityH tech2Panel = em.find(AuthorityH.class, 2);
		ip.setTech2Panel(tech2Panel);
		ip.setTech2Rating(4);
		ip.setTech2Status(InterviewStatus.Pass);
		ip.setTech2Comments("Good in technical 2 round");
		
		AuthorityH mgrPanel = em.find(AuthorityH.class, 2);
		ip.setMgrPanel(tech2Panel);
		ip.setMgrRating(4);
		ip.setMgrStatus(InterviewStatus.Pass);
		ip.setMgrComments("Good in Managerial round");
		
		AuthorityH hrPanel = em.find(AuthorityH.class, 3);
		ip.setHrPanel(tech2Panel);
		ip.setHrRating(4);
		ip.setHrStatus(InterviewStatus.Pass);
		ip.setHrComments("Good in HR round");
		
		em.persist(ip);
	}
	
	public List<InterviewPanel2> findAll(){
		TypedQuery<InterviewPanel2> createQuery = em.createQuery("Select i from InterviewPanel2 i", InterviewPanel2.class);
		List<InterviewPanel2> resultList = createQuery.getResultList();
		return resultList;
	}
	
	public List<InterviewPanel> individualInterviews(int panelId){
		TypedQuery<InterviewPanel> createQuery = em.createQuery("Select i from interviewPanel i where i.telPanel.id = ? or i.tech1Panel.id=? or i.tech2Panel.id = ? or i.mgrPanel.id=? or i.hrPanel.id=?", InterviewPanel.class);
		createQuery.setParameter(0, panelId);
		createQuery.setParameter(1, panelId);
		createQuery.setParameter(2, panelId);
		createQuery.setParameter(3, panelId);
		createQuery.setParameter(4, panelId);
		List<InterviewPanel> resultList = createQuery.getResultList();
		return resultList;
	}
	
	public void addPanel2Records(){
		Candidate c = em.find(Candidate.class, 1);
		InterviewPanel2 ip2 = new InterviewPanel2();
		ip2.setCandidate(c);
		
		IndividualInterviews ii = new IndividualInterviews();
		ii.setInterviewType(InterviewType.TELEPHONE);
		User telPanel = em.find(User.class, 3L);
		ii.setIntPanel(telPanel );
		ii.setIntRating(3);
		ii.setIntStatus(InterviewStatus.NotDecided);
		ii.setIntComments("Not yet decided.");
		
		IndividualInterviews ii2 = new IndividualInterviews();
		ii2.setInterviewType(InterviewType.TECHNICAL1);
		User telPanel2 = em.find(User.class, 3L);
		ii2.setIntPanel(telPanel2);
		ii2.setIntRating(3);
		ii2.setIntStatus(InterviewStatus.NotDecided);
		ii2.setIntComments("Not yet decided.");
		
		List<IndividualInterviews> indInterviews = new ArrayList<>();
		indInterviews.add(ii);
		indInterviews.add(ii2);
		ip2.setIndInterviews(indInterviews);
//		em.persist(ii);
		em.persist(ip2);
	}

	public InterviewPanel2 addPanel(InterviewPanel2 ip2) {
		// TODO Auto-generated method stub
		if (ip2.getTableid() != 0)
			em.merge(ip2);
		else
			em.persist(ip2);
		return ip2;
	}

	public List<InterviewPanel2> getCandidatePanel(String candidateid) {
		// TODO Auto-generated method stub
		TypedQuery<InterviewPanel2> createQuery = em.createQuery("Select i from InterviewPanel2 i where i.candidate.candidateId = :candidateid", InterviewPanel2.class);
		createQuery.setParameter("candidateid", Integer.parseInt(candidateid));
		List<InterviewPanel2> resultList = createQuery.getResultList();
		return resultList;
	}

	public List<InterviewPanel2> getUserInterviewList(String userid) {
		TypedQuery<InterviewPanel2> createQuery = 
				em.createQuery("Select distinct i from InterviewPanel2 i join i.indInterviews j join j.intPanel u where u.id=:userid", InterviewPanel2.class);
		createQuery.setParameter("userid", Long.parseLong(userid));
		List<InterviewPanel2> resultList = createQuery.getResultList();
		return resultList;
	}

	public HttpInterviewPanel updInterviewPanelRound(HttpInterviewPanel hip) {
		System.out.println(hip.getTableid());
		InterviewPanel2 ip2 = em.find(InterviewPanel2.class, hip.getTableid()); 
		List<IndividualInterviews> indInterviews = ip2.getIndInterviews();
		List<IndividualInterviews> dupInterviews = new ArrayList<IndividualInterviews>();
		for (IndividualInterviews ii: indInterviews){
			if(ii.getInterviewType() == hip.getInterviewType()){
				ii.setIntComments(hip.getIntComments());
				ii.setIntRating(hip.getIntRating());
				ii.setIntStatus(hip.getIntStatus());
				dupInterviews.add(ii);
			}
			else{
				dupInterviews.add(ii);
			}
		}
		ip2.setIndInterviews(dupInterviews);
		em.merge(ip2);
		return hip;
	}
}
