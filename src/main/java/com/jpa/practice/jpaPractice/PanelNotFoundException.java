package com.jpa.practice.jpaPractice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class PanelNotFoundException extends RuntimeException {

	public PanelNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
