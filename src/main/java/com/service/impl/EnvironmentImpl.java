/**
 * 
 */
package com.service.impl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.exception.EnvironmentException;
import com.model.Environment;
import com.repository.EnvironmentRepository;
import com.repository.dao.ApplicationDao;
import com.repository.dao.EnvironmentDao;
import com.service.EnvironmentService;
import com.service.SecurityService;
import com.util.IDGenerator;
import com.util.RequestUtils;

import antlr.StringUtils;


/**
 * @author Sunil
 *
 * EnvironmentImpl.java Feb 21, 2021 8:51:53 PM
 */
@Service
public class EnvironmentImpl implements EnvironmentService {

	private String SEPERATOR = "-";
	/* (non-Javadoc)
	 * @see com.service.Environment#addEnvironment(com.service.Environment)
	 */
	@Autowired
	private EnvironmentRepository environmentRepo;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private RequestUtils req;
	
	@Autowired
	private EnvironmentDao envDao;
	

	/* (non-Javadoc)
	 * @see com.service.EnvironmentService#addEnvironment(com.service.EnvironmentService)
	 */
	@Override
	public Environment addEnvironment(Environment env) {
		 //env.setEnvId(generateEnvironmentId(env));
		 env.getMachine().setRef_no(env.getRefNo());
		 env.getOs().setRefNo(env.getRefNo());
		 env.setCreatedBy(req.getLoggedUserName());
		 env.setCreatedDate(LocalDate.now().toString());
		 env.setUpdatedBY(req.getLoggedUserName());//env.setUpdatedBY(getLoggedUserName());
		 env.setUpDatedDate(LocalDate.now().toString());
		 return environmentRepo.save(env);
	}


	/* (non-Javadoc)
	 * @see com.service.EnvironmentService#getEnvironmentList()
	 */
	@Override
	public List<Environment> getEnvironmentList() throws EnvironmentException {
		try {
			return environmentRepo.findAll();
		} catch (Exception e) {
			throw new EnvironmentException(e.fillInStackTrace());
		}
		
	}


	/* (non-Javadoc)
	 * @see com.service.EnvironmentService#getEnvironmentDetails()
	 */
	@Override
	public Environment getEnvironmentDetails(Long envRefNo) throws EnvironmentException {
		try {
			return environmentRepo.getOne(envRefNo);
		} catch (Exception e) {
			throw new EnvironmentException(e.fillInStackTrace());
		}
	}


	/* (non-Javadoc)
	 * @see com.service.EnvironmentService#getSequence()
	 */
	@Override
	public Long getSequence() {
		Long seq = environmentRepo.count();
		if (seq == null || seq == 0)
		 return	seq = 1L;
		else 
		 return seq+1;
	}

	
	/*private  String generateEnvironmentId(Environment env) {
		String envId = env.getName()+SEPERATOR+IDGenerator.getDate()+SEPERATOR+env.getOS();
		return envId;
	}*/
	
	public String getLoggedUserName() {
		return securityService.findCorrentUser();
	}


	/* (non-Javadoc)
	 * @see com.service.EnvironmentService#getEnvironmentName(java.lang.Long)
	 */
	@Override
	public String getEnvironmentName(Long envRefNo) throws SQLException {
		return envDao.getEnvironmentNameByRefNo(envRefNo);
	}
}
