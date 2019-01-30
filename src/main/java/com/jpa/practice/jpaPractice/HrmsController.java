package com.jpa.practice.jpaPractice;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import com.jpa.practice.jpaPractice.authentication.model.security.User;
import com.jpa.practice.jpaPractice.authentication.security.repository.UserRepository;
import com.jpa.practice.jpaPractice.hrms.Candidate;
import com.jpa.practice.jpaPractice.hrms.HttpInterviewPanel;
import com.jpa.practice.jpaPractice.hrms.IndividualInterviews;
import com.jpa.practice.jpaPractice.hrms.InterviewPanel2;
import com.jpa.practice.jpaPractice.hrms.JobRequests;
import com.jpa.practice.jpaPractice.hrms.dao.CandidateRepository;
import com.jpa.practice.jpaPractice.hrms.dao.InterviewPanelRepository;
import com.jpa.practice.jpaPractice.hrms.dao.JobRepository;
import com.jpa.practice.jpaPractice.microservices.CandidateAddr;
import com.jpa.practice.jpaPractice.microservices.CandidateAddress;

@RestController
@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
public class HrmsController {

	@Autowired
	private JobRepository jobrepo;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private CandidateRepository canrepo;
	
	@Autowired
	private InterviewPanelRepository ipr;
	
	@Autowired
	private CandidateAddress ca;
	
	@GetMapping(value="/allUsers")
	public List<User> findAllUsers(){
		return userrepo.findAll();
	}
	
	@GetMapping(value="/jobs")
	public List<JobRequests> findAllJobReq(){
		return jobrepo.findAllJobs();
	}
	
	@GetMapping(value="/job")
	public JobRequests findJobById(@RequestParam String jobid){
		return jobrepo.findJobUsingId(jobid);
	}
	
	@PostMapping("/addJob")
	public JobRequests addJob(@RequestBody JobRequests jobReq){
		System.out.println(jobReq.getJobResp());
		return jobrepo.createJob(jobReq);
	}
	
	@GetMapping("/userjobs")
	public List<JobRequests> userJobs(@RequestParam String userid){
		return jobrepo.findUserJobs(userid);
	}
	
	@PutMapping(value="/updjob")
	public JobRequests updJob(@RequestBody JobRequests job){
		System.out.println(job.getReqId());
		return jobrepo.upd(job);
	}
	
	@PostMapping(value="/addCand")
	public Candidate addCandidate(@RequestBody Candidate cand){
		return canrepo.addCandidateRecord(cand);
	}
	
	@GetMapping("/allCand")
	public List<Candidate> allCandidates(){
		//@RequestHeader("Authorization") String token
//		System.out.println(" TOKEN =" + token);
		return canrepo.findAll();
	}
	
	@GetMapping("/interviews")
	public List<InterviewPanel2> allInterviews() {
		return ipr.findAll();
	}
	
	@PostMapping("/addPanel")
	public InterviewPanel2 addInterviewpanel(@RequestBody InterviewPanel2 ip2){
		System.out.println(ip2.getTableid());
		System.out.println(ip2.getCandidate().getFirstName());
		return ipr.addPanel(ip2);
	}
	
	@GetMapping("/getPanel/{candidateid}")
	public List<InterviewPanel2> getPanel(@PathVariable String candidateid){
		List<InterviewPanel2> candidatePanel = ipr.getCandidatePanel(candidateid);
			if (candidatePanel.size() == 0){
				throw new PanelNotFoundException("Candidate Id=" + candidateid);
			}
		return candidatePanel;
	}
	
	@GetMapping("/inter_list")
	public List<InterviewPanel2> userInterviewList(@RequestParam String userid){
		List<InterviewPanel2> rtnList = new ArrayList<InterviewPanel2>();
		List<InterviewPanel2> lip2 = ipr.getUserInterviewList(userid);
		for(InterviewPanel2 i: lip2){
			InterviewPanel2 ip2 = new InterviewPanel2();
			ip2.setCandidate(i.getCandidate());
			ip2.setTableid(i.getTableid());
			List<IndividualInterviews> indInterviews = i.getIndInterviews();
			List<IndividualInterviews> tempII = new ArrayList<IndividualInterviews>();
			for(IndividualInterviews ii: indInterviews){
				   if (userid.equals(ii.getIntPanel().getId().toString())){
					   tempII.add(ii);
				   }
			}
			if(tempII.size()>0){
			ip2.setIndInterviews(tempII);
			}
			rtnList.add(ip2);
		}
		return rtnList;
	}
	
	@GetMapping("/interview_list")
	public List<HttpInterviewPanel> empInterviewList(@RequestParam String userid){
		List<InterviewPanel2> lip2 = ipr.getUserInterviewList(userid);
		List<HttpInterviewPanel> hip = new ArrayList<HttpInterviewPanel>();
		for (InterviewPanel2 i: lip2){
			
			for(IndividualInterviews ii: i.getIndInterviews()){
				   if (userid.equals(ii.getIntPanel().getId().toString())){
					  
					   HttpInterviewPanel temp_hip = new HttpInterviewPanel();
					   temp_hip.setTableid(i.getTableid());
					   temp_hip.setCandidateid(i.getCandidate().getCandidateId());
					   temp_hip.setCandidateName(i.getCandidate().getFirstName());
					   temp_hip.setJobreqid(i.getCandidate().getJobreqid().getJobreqid());
					   temp_hip.setInterviewType(ii.getInterviewType());
					   temp_hip.setIntRating(ii.getIntRating());
					   temp_hip.setIntStatus(ii.getIntStatus());
					   temp_hip.setIntComments(ii.getIntComments());
					   hip.add(temp_hip);
				   }
			}
		}
		return hip;
	}
	
	@PostMapping("/updinterview")
	public HttpInterviewPanel updInterview(@RequestBody HttpInterviewPanel hip){
		return ipr.updInterviewPanelRound(hip);
	}
	
	@GetMapping("/candidate_address/{id}")
	public CandidateAddr getAddress(@PathVariable String id){
		return ca.getAddress(id);
	}
}


