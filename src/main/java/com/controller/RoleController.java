package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Role;
import com.repository.RoleRepository;
import com.service.RoleService;
import com.service.UserService;

@Controller
@RequestMapping(value = "/role/**")
public class RoleController {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private RoleService roleService;

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}

	@GetMapping("/role")
	public String welcome(Model model) {
		model.addAttribute("roleForm", new Role());
		model.addAttribute("roleList", roleRepo.findAll());
		return "role";
	}

	@GetMapping("/list")
	@ResponseBody
	public List<Role> ajaxCallList(Model model) {
		return roleRepo.findAll();
	}

	@GetMapping("/update")
	@ResponseBody
	public String getUpdateUserList(@RequestParam("UserId") String userId,@RequestParam("roleList") String roleList,Model model) {
		System.out.println("userId "+userId);
        System.out.println(roleList);
        String [] roles = roleList.split("-");
        List <Long> rolesList = new ArrayList<Long>();
        for(String role : roles)
        	rolesList.add(Long.valueOf(role));
        if(roleService.updateUserRoles(Long.valueOf(userId), rolesList))
        	return "updated";
        else
        	return "Not Updated";
        	
        //boolean res = userService.upadateRolesForUser(Long.valueOf(userId),roles);
	}
	
	@RequestMapping(name="/save",method=RequestMethod.POST)
	public String saveRole(@ModelAttribute("roleForm") Role role) {
		roleService.saveRole(role);
		return "role";
	}
}