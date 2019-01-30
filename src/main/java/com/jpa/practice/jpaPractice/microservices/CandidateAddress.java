package com.jpa.practice.jpaPractice.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="candidate-personal")
@RibbonClient(name="candidate-personal")
public interface CandidateAddress {
	
	@GetMapping("/address/{id}")
	public CandidateAddr getAddress(@PathVariable("id") String candidateId);
}
