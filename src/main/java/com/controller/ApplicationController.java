/**
 * 
 */
package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exception.EnvironmentException;
import com.model.Application;
import com.service.ApplicationService;

/**
 * @author Sunil
 *
 * ApplicationController.java Feb 22, 2021 12:05:07 AM
 */
@Controller
@RequestMapping("/application")
public class ApplicationController {

	@Autowired
	private ApplicationService appSer;
	
	@PostMapping("/save")
	public String saveApplication(@ModelAttribute("application") Application application,Model model) throws EnvironmentException {
		model.addAttribute("application", appSer.addApplication(application));
		model.addAttribute("envList",appSer.getEnvRefNameList());
		model.addAttribute("applications", appSer.getAllApplications());
		return "application";
	}
	
	@GetMapping("home")
	public String appHomePage(Model model) throws EnvironmentException {
		Application app = new Application();
		app.setId(appSer.getSequenceNumber());
		model.addAttribute("application", app);
		model.addAttribute("envList",appSer.getEnvRefNameList());
		model.addAttribute("applications", appSer.getAllApplications());
		return "application";
	}
}
