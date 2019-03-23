package com.repository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface CustomRoleReposiory {

	List <String> getListOfRoleNames();
	List <String> getListOfRoleNamesByUserId(Long userId);
	
}
