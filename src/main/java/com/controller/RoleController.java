package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
	 @GetMapping("/role")
	    public String welcome(Model model) {
	        return "role";
	    }
}
