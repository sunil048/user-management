/**
 * 
 */
package com.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sunil
 *
 * RequestUtils.java Feb 24, 2021 6:34:43 PM
 */

@Component
public class RequestUtils {

	@Autowired
	HttpServletRequest request;
	
	public  String getLoggedUserName() {
		String user= request.getUserPrincipal().getName();
		return user;
	}
}
