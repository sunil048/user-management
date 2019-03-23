package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Role;
import com.repository.RoleRepository;

@Component
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepo;
	
	@Override
	public List<String> getAllRolesName() {
		System.out.println("********Getting user name list ");
		return roleRepo.getListOfRoleNames();
	}

}
