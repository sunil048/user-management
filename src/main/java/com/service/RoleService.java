package com.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.model.Role;

@Component
public interface RoleService {
  List <String> getAllRolesName();
  boolean updateUserRoles(Long userId,List<Long> roles);
  boolean saveRole(Role role);
}
