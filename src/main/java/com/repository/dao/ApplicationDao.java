/**
 * 
 */
package com.repository.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Application;

/**
 * @author Sunil
 *
 * ApplicationDao.java Feb 25, 2021 9:30:15 PM
 */
@Repository
public class ApplicationDao extends DBUtil {
	
	private static final String List_By_Environment_RefNo ="select name from environments where env_ref=?";
	
	public String getEnvironmentNameByRefNo(Long envRefNo) throws SQLException{
		start();
		try
		{
			if (connection != null) {
				PreparedStatement prstmt = connection.prepareStatement(List_By_Environment_RefNo);
				prstmt.setLong(1, envRefNo);
				ResultSet rs = prstmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
			}
		} finally {
			stop();
			return null;
		}
	}

}
