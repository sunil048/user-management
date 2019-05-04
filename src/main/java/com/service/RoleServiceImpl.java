package com.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Role;
import com.repository.RoleRepository;
import com.repository.dao.RoleDao;

@Component
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<String> getAllRolesName() {
		return roleRepo.getListOfRoleNames();
	}

	@Override
	public boolean updateUserRoles(Long userId, List<Long> roles) {
		return roleDao.updateRolesForTheUser(userId, roles);
	}

	@Override
	public boolean saveRole(Role role) {
		
		roleRepo.save(role);
		return true;
	}

}
