package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Role;
import com.repository.RoleRepository;
import com.service.UserService;

@Controller
@RequestMapping(value = "/role/**")
public class RoleController {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserService userService;

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
	}

	@GetMapping("/role")
	public String welcome(Model model) {
		model.addAttribute("roleList", roleRepo.findAll());
		return "role";
	}

	@GetMapping("/list")
	@ResponseBody
	public List<Role> ajaxCallList(Model model) {
		return roleRepo.findAll();
	}

	@GetMapping("/update")
	public String getUpdateUserList(@RequestParam("roleList") String roleList,Model model) {
        System.out.println(roleList);
        String [] roles = roleList.split("-");
        boolean res = userService.upadateRolesForUser(roles);
        System.out.println(res);
		return "redirect:/";
	}
}