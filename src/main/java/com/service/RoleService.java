package com.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface RoleService {
  List <String> getAllRolesName();
}
