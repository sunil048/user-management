/**
 * 
 */
package com.repository.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

/**
 * @author Sunil
 *
 * EnvironmentDao.java Feb 28, 2021 12:01:12 PM
 */
@Repository
public class EnvironmentDao extends DBUtil{
private static final String List_By_Environment_RefNo ="select name from environments where ref_no=?";
	
	public String getEnvironmentNameByRefNo(Long envRefNo) throws SQLException{
		start();
		String envName = null;
		try
		{
			if (connection != null) {
				PreparedStatement prstmt = connection.prepareStatement(List_By_Environment_RefNo);
				prstmt.setLong(1, envRefNo);
				ResultSet rs = prstmt.executeQuery();
				while(rs.next()) {
					envName = rs.getString(1);
				}
			}
			return envName;
		} catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally {
			stop();
			
		}
	}
}
