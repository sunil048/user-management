/**
 * 
 */
package com.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.EnvironmentException;
import com.model.Application;
import com.model.Environment;
import com.repository.ApplicationRepository;
import com.service.ApplicationService;
import com.service.EnvironmentService;

/**
 * @author Sunil
 *
 * ApplicationServiceImpl.java Feb 21, 2021 11:50:32 PM
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

	/* (non-Javadoc)
	 * @see com.service.ApplicationService#addApplication(com.model.Application)
	 */
	@Autowired
	private ApplicationRepository appRepo;
	
	@Autowired
	private EnvironmentService envService;
	
	@Override
	public Application addApplication(Application app) throws EnvironmentException {
	//	app.setEnvRef(Long.valueOf(getEnvRefNameList().get(app.getEnvRef())));
		app.setEnvRef(app.getEnvRef());
		return appRepo.save(app);
	}

	/* (non-Javadoc)
	 * @see com.service.ApplicationService#getAllApplications()
	 */
	@Override
	public List<Application> getAllApplications() {
		return appRepo.findAll();
	}
	
	public Map <Long,String>  getEnvRefNameList() throws EnvironmentException{
		Map <Long,String>  envRefNameList = new LinkedHashMap <Long,String>();
		for (Environment env : envService.getEnvironmentList()) {
			envRefNameList.put(env.getRefNo(), env.getName());
		}
		return envRefNameList;
	}

	/* (non-Javadoc)
	 * @see com.service.ApplicationService#getSequenceNumber()
	 */
	@Override
	public Long getSequenceNumber() {
		Long seq = appRepo.count();
		if (seq == null && seq == 0)
				return 1L;
			else
				return ++seq;
	}

	/* (non-Javadoc)
	 * @see com.service.ApplicationService#getApplicationsList(java.lang.String)
	 */
	@Override
	public List<Application> getApplicationsList(Long envRefNo) {
		return appRepo.getApplicationListByEnvironmentRefNo(envRefNo);
	}

}
