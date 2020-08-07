package com.controller;

import org.springframework.beans.factory.annotation.Value;
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
	
	@GetMapping("/generateTaskId")
	public String getTaskId() {
		return String.valueOf(IDGenerator.generateTaskId());
	}
	
}
