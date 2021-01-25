package com.app.course.online.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController
{
	@GetMapping(value = "/register")
	public String registerForm() {
	
		return "register";
	}
}
