package com.jpa.practice.jpaPractice.hrms;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpa.practice.jpaPractice.hrms.enums.InterviewStatus;

@Entity(name="Candidate")
@Table(name="candidate")
public class Candidate {

	@Id 
	@TableGenerator(name="CandidateSequence", pkColumnName="pkCol", pkColumnValue="CandidateSeq", table="Table_Seq")
	@GeneratedValue(generator="CandidateSequence")
	private int candidateId;
	
	@OneToOne
	private JobRequests jobreqid;
	
	@NotNull(message="cannot be null")
	@NotBlank(message="cannot by blanks")
	private String firstName;
	
	@NotNull(message="cannot be null")
	@NotBlank(message="cannot by blanks")
	private String lastName;
	
	@Email(message="Invalid email")
	@NotNull(message="cannot be null")
	@NotBlank(message="cannot by blanks")
	private String emailId;
	
	@Pattern(regexp="^[0-9]{10}",message="Only digits allowed" )
	@Size(min=10, max=12, message="Enter valid phone number")
	private String telephone;
	
	private String canResume;
	
	@Enumerated(EnumType.STRING)
	private InterviewStatus onHold;
	@Enumerated(EnumType.STRING)
	private InterviewStatus telStatus;
	@Enumerated(EnumType.STRING)
	private InterviewStatus tech1Status;
	@Enumerated(EnumType.STRING)
	private InterviewStatus tech2Status;
	@Enumerated(EnumType.STRING)
	private InterviewStatus mgrStatus;
	@Enumerated(EnumType.STRING)
	private InterviewStatus hrStatus;
	@Enumerated(EnumType.STRING)
	private InterviewStatus ofrRls;
	@Enumerated(EnumType.STRING)
	private InterviewStatus ofrAccept;
	@Enumerated(EnumType.STRING)
	private InterviewStatus bckgVerify;
	@Enumerated(EnumType.STRING)
	private InterviewStatus joinedOrg;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date joinDate;
	
	@Transient
	@JsonIgnore
	private LinkedHashMap<String, String> yesno;
	
	@Transient
	@JsonIgnore
	private String jobname;
	
	public Candidate() {
		yesno = new LinkedHashMap<String, String>();
		yesno.put("YES", "YES");
		yesno.put("NO", "NO");
		yesno.put("NA", "NA");
	}

	public JobRequests getJobreqid() {
		return jobreqid;
	}

	public void setJobreqid(JobRequests jobreqid) {
		this.jobreqid = jobreqid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCanResume() {
		return canResume;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public void setCanResume(String canResume) {
		this.canResume = canResume;
	}

	public InterviewStatus getOnHold() {
		return onHold;
	}

	public void setOnHold(InterviewStatus onHold) {
		this.onHold = onHold;
	}

	public InterviewStatus getTelStatus() {
		return telStatus;
	}

	public void setTelStatus(InterviewStatus telStatus) {
		this.telStatus = telStatus;
	}

	public InterviewStatus getTech1Status() {
		return tech1Status;
	}

	public void setTech1Status(InterviewStatus tech1Status) {
		this.tech1Status = tech1Status;
	}

	public InterviewStatus getTech2Status() {
		return tech2Status;
	}

	public void setTech2Status(InterviewStatus tech2Status) {
		this.tech2Status = tech2Status;
	}

	public InterviewStatus getMgrStatus() {
		return mgrStatus;
	}

	public void setMgrStatus(InterviewStatus mgrStatus) {
		this.mgrStatus = mgrStatus;
	}

	public InterviewStatus getHrStatus() {
		return hrStatus;
	}

	public void setHrStatus(InterviewStatus hrStatus) {
		this.hrStatus = hrStatus;
	}

	public InterviewStatus getOfrRls() {
		return ofrRls;
	}

	public void setOfrRls(InterviewStatus ofrRls) {
		this.ofrRls = ofrRls;
	}

	public InterviewStatus getOfrAccept() {
		return ofrAccept;
	}

	public void setOfrAccept(InterviewStatus ofrAccept) {
		this.ofrAccept = ofrAccept;
	}

	public InterviewStatus getBckgVerify() {
		return bckgVerify;
	}

	public void setBckgVerify(InterviewStatus bckgVerify) {
		this.bckgVerify = bckgVerify;
	}

	public InterviewStatus getJoinedOrg() {
		return joinedOrg;
	}

	public void setJoinedOrg(InterviewStatus joinedOrg) {
		this.joinedOrg = joinedOrg;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public LinkedHashMap<String, String> getYesno() {
		return yesno;
	}

	public void setYesno(LinkedHashMap<String, String> yesno) {
		this.yesno = yesno;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
	
}
