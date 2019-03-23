package com.controller;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.service.RoleService;
import com.service.RoleServiceImpl;
import com.service.SecurityService;
import com.service.UserService;
import com.validator.UserValidator;

@Controller
public class UserController {
	
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
	RoleRepository roleRepo;
    
    
    @Autowired(required=true)
    private RoleService roleService;
    

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
    	System.out.println("login");
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
    
    @GetMapping("/userDetails")
    public String getUserdeatisl(Model model) {
    	User user = new User();
        user.setDob(new Date());
    	/*SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    	String date = sdf.format(new Date()); */
    	System.out.println(new Date());
    	model.addAttribute("userDetailsForm", user);
        model.addAttribute("rolesNameList", roleService.getAllRolesName());
    	model.addAttribute("userList", userService.getAllUsers());
    	return "userdetails";
    }
    
    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute("userDetailsForm") User userForm){
    	System.out.println("Adding user");
    	userService.save(userForm);
    	return "redirect:/";
    }
    @GetMapping("/userHome/{userId}")
    public String getUserHomePage(@PathVariable("userId") String userId ,Model model) {
    	User user = userService.findUserById(Long.valueOf(userId));
    	model.addAttribute("user", user );
    	/*List <String> rolesName =  roleRepo.getListOfRoleNamesByUserId(Long.valueOf(userId));
    	model.addAttribute("rolesName", rolesName);*/
    	return "userhomepage";
    }
	private String getCurrentUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		System.out.println(username);
		return username;
	}
}