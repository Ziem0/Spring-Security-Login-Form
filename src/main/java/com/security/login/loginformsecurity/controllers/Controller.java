package com.security.login.loginformsecurity.controllers;

import com.security.login.loginformsecurity.models.LoginObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping("")
public class Controller {

	@GetMapping("/all/**")
	public String getAll(Model model) {
		model.addAttribute("title", "all");
		return "all";
	}

	@GetMapping("/admin/**")
	public String getAdmin(Model model) {
		model.addAttribute("title", "admin");
		return "admin";
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
	public String getResult(Model model) {
		model.addAttribute("title", "result");
		return "result";
	}

	@GetMapping("/login")
	public String getLogin(Model model, @ModelAttribute LoginObject loginObject, @RequestParam(value = "error",required = false) String messageOrNull) {
		model.addAttribute("title", "login");
		model.addAttribute("message",messageOrNull);
		return "login";
	}

}
