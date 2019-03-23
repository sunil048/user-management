package com.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.repository.dao.DBUtil;
import com.repository.dao.RoleDao;

@Component
public class RoleRepositoryImpl implements CustomRoleReposiory{

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<String> getListOfRoleNamesByUserId(Long userId) {
				System.out.println("getListOfRoleNamesByUserId starting dao");
		try {
			return roleDao.getListOfRoleNamesByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> getListOfRoleNames() {
		try {
			return roleDao.getListOfRoleNames();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
