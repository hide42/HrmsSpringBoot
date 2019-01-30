package com.jpa.practice.jpaPractice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.practice.jpaPractice.hrms.AuthorityH;
import com.jpa.practice.jpaPractice.hrms.Candidate;
import com.jpa.practice.jpaPractice.hrms.InterviewPanel;
import com.jpa.practice.jpaPractice.hrms.JobRequests;
import com.jpa.practice.jpaPractice.hrms.dao.CandidateRepository;
import com.jpa.practice.jpaPractice.hrms.dao.InterviewPanelRepository;
import com.jpa.practice.jpaPractice.hrms.dao.TestPersist;

@RestController
@CrossOrigin
public class JPAController {

//	@Autowired
//	private PersistTable pt;
	
	@Autowired
	private TestPersist tp;
	
	@Autowired
	private CandidateRepository candidateRepo;
	
	@Autowired
	private InterviewPanelRepository ipr;
	
	@GetMapping("/")
	public void persistData(){
		tp.addJobRequests();
		candidateRepo.addCandidates();
		ipr.addInterviewPanelRecords();
		ipr.addPanel2Records();
	}
	
	@PostMapping(value="/addUser")
	public AuthorityH addUser(@RequestBody AuthorityH authUser){
		System.out.println("Received - " + authUser.getUsername());
		return tp.addAuthUser(authUser);
	}
	
	@GetMapping(value="/roles")
	public List<AuthorityH> getAuth() {
		return tp.findAllAuthorities();
	}
	
	@GetMapping(value="/candidates")
	public List<Candidate> getCandidates() {
		return candidateRepo.findAll();
	}
	
	@GetMapping(value="/candidates/{id}")
	public Candidate getOneCandidate(@PathVariable int id){
		return candidateRepo.findCandidate(id);
	}
	
	@GetMapping(value="/interviews/{panelId}")
	public List<InterviewPanel> individualInterviews(@PathVariable int panelId){
		return ipr.individualInterviews(panelId);
	}
}
