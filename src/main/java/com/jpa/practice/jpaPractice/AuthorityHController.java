package com.jpa.practice.jpaPractice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.practice.jpaPractice.hrms.AuthorityH;
import com.jpa.practice.jpaPractice.hrms.dao.AuthorityHRepository;

@RestController
@CrossOrigin()
public class AuthorityHController {

	
	@Autowired
	private AuthorityHRepository ar;
	
	@GetMapping(value="/users")
	@Secured("ROLE_ADMIN")
	public List<AuthorityH> getUsers(){
		return ar.getAllUsers();
	}
	
	@GetMapping(value="/users/{id}")
	public AuthorityH getUser(@PathVariable int id){
		AuthorityH user = ar.getUser(id);
		if (user == null) { 
			throw new UserNotFoundException("User Id - "+id);
		}
		return user;
	}
}
