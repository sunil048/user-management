/**
 * 
 */
package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.exception.EnvironmentException;
import com.model.Environment;

/**
 * @author Sunil
 *
 * Environment.java Feb 21, 2021 8:51:37 PM
 */
@Service
public interface EnvironmentService {

	public Environment addEnvironment(Environment env);
	public List<Environment> getEnvironmentList() throws EnvironmentException;
	public Environment getEnvironmentDetails(Long envRefNo) throws EnvironmentException;
	public Long getSequence();
	
}
