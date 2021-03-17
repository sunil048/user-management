/**
 * 
 */
package com.controller;

import javax.persistence.MappedSuperclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Environment;
import com.service.ApplicationService;
import com.service.EnvironmentService;

/**
 * @author Sunil
 *
 * EnvironmentController.java Feb 21, 2021 8:50:07 PM
 */
@Controller
@RequestMapping("/environment")
public class EnvironmentController {
	
	private static Logger log = LoggerFactory.getLogger(EnvironmentController.class);

	@Autowired
	private EnvironmentService envSer;
	
	@Autowired
	private ApplicationService appService;
	
	@PostMapping("/save")
	public String saveEnvironment(@ModelAttribute("environment") Environment model,Model modelUI) {
		try {
			log.info("saveEnvironment() called...");
			envSer.addEnvironment(model);
			modelUI.addAttribute("environment", model);
			modelUI.addAttribute("environments", envSer.getEnvironmentList());
			log.info("completed request");
			return "environment";
		} catch (Exception e) {
			modelUI.addAttribute("Error ",e.getMessage());
			return "error";
		}
	}
	
	@GetMapping("/home")
	public String homePage(Model model) {
		try {
			log.info("home page() called...");
			Environment env = new Environment();
			env.setRefNo(envSer.getSequence());
			model.addAttribute("environment", env);
			model.addAttribute("environments", envSer.getEnvironmentList());
			return "environment";
		} catch (Exception e) {
			model.addAttribute("Error ",e.getMessage());
			return "error";
		}
		
	}
	
	@GetMapping("/details/{refId}")
	public String getEnvironmentDetails(@PathVariable("refId") Long refId,Model model) {
		try {
			Environment env =  envSer.getEnvironmentDetails(refId);
			model.addAttribute("env",env);
			model.addAttribute("applications",appService.getApplicationsList(refId));
			return "envdetails";
		} catch (Exception e) {
			model.addAttribute("Error ",e.getMessage());
			return "error";
		}
		
	}
}
