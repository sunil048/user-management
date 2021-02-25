/**
 * 
 */
package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exception.EnvironmentException;
import com.model.Application;

/**
 * @author Sunil
 *
 * ApplicationService.java Feb 21, 2021 11:49:44 PM
 */
@Repository
public interface ApplicationService {

	public Application addApplication(Application app) throws EnvironmentException;
	public List<Application> getAllApplications();
	public Map <Long,String>  getEnvRefNameList() throws EnvironmentException;
	public Long getSequenceNumber();
	public List <Application> getApplicationsList(Long env_ref);
}
