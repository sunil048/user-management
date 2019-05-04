package com.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.repository.role.RoleConstants;

@Repository
public class RoleDao extends DBUtil {

	public List<String> getListOfRoleNames() throws SQLException {
		List <String> roleNames = new Vector<String>();
		start();
		if (connection != null) {
			PreparedStatement ps = connection.prepareStatement(RoleConstants.SQL_GET_LIST_ROLENAMES);
			ResultSet rs = ps.executeQuery();
		
			while (rs.next())
				roleNames.add(rs.getString(1));
		}
		stop();
		return roleNames;
	}
	
	public List<String> getListOfRoleNamesByUserId(Long userId) throws SQLException {
		List <String> roleNames = new Vector<String>();
		start();
		if (connection != null) {
			System.out.println("dao strated");
			System.out.println("userId is "+userId);
			PreparedStatement ps = connection.prepareStatement(RoleConstants.SQL_GET_LIST_ROLENAMES_BY_USERID);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
		
			while (rs.next())
				roleNames.add(rs.getString(2));
		}
		stop();
		System.out.println(roleNames);
		return roleNames;
	}
	public boolean updateRolesForTheUser(Long userId,List<Long> rolesIds) {
		start();
		if (connection != null) {
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(RoleConstants.SQL_UPDATE_ROLES_FOR_USER);
				ps.setLong(1, userId);
				for (Long roleId : rolesIds) {
					ps.setLong(2, roleId);
					ps.executeUpdate();
				}
			return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally {
				stop();
			}
		}
		return false;
	}
	
}
