package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.util.IDGenerator;

@RestController
public class UtilController {

	@Value("${spring.message}")
	private String message;
	
	@GetMapping("/test")
	public String test() {
		return message;
	}
	
	@GetMapping("/rest/generateTaskId")
	public ResponseEntity<Object> getTaskId() {
		try {
			return new ResponseEntity<Object>(HttpStatus.OK).ok(String.valueOf(IDGenerator.generateTaskId()));
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.OK).ok(e.getMessage());
		}
		
	}
	
	@GetMapping("/generateTaskId")
	public ResponseEntity<Object> getTaskId1() {
		try {
			return new ResponseEntity<Object>(HttpStatus.OK).ok(String.valueOf(IDGenerator.generateTaskId()));
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.OK).ok(e.getMessage());
		}
		
	}
	
}
