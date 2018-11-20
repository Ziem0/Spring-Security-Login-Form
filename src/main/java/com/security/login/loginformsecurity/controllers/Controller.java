package com.security.login.loginformsecurity.controllers;

import com.security.login.loginformsecurity.models.LoginObject;
import com.security.login.loginformsecurity.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping("")
public class Controller {

	final
	MainService service;

	@Autowired
	public Controller(MainService service) {
		this.service = service;
	}

	@GetMapping(value = {"/all/**","/"})
	public String getAll(Model model) {
		model.addAttribute("title", "all");
		return "all";
	}

	@GetMapping("/admin")
	public String getAdmin(Model model) {
		model.addAttribute("title", "admin");
//		Optional<LoginObject> person = service.checkUsernameAndPassword("ziemo", "1212");
//		if (person.isPresent()) {
		return "admin";
//		}
//		return "anonim";
	}

	@GetMapping("/user/**")
	public String getUser(Model model) {
		model.addAttribute("title", "user");
		return "user";
	}

	@GetMapping("/anonim/**")
	public String getAnonim(Model model) {
		model.addAttribute("title", "anonim");
		return "anonim";
	}

	@GetMapping("/result/**")
	public String getResult(Model model, LoginObject loginObject) {
		model.addAttribute("title", "result");
		model.addAttribute(loginObject);
		return "result";
	}

	@GetMapping("/login")
	public String getLogin(Model model, @ModelAttribute LoginObject loginObject, @RequestParam(value = "error",required = false) String messageOrNull) {
		model.addAttribute("title", "login");
		model.addAttribute("message", messageOrNull);
		return "login";
	}
}
