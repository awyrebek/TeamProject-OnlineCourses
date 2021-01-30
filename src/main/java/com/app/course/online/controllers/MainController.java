package com.app.course.online.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.course.online.user.AuthorizationImitation;

@RestController
public class MainController
{
	@GetMapping(value = "/")
	@CrossOrigin
	public String index()
	{
		if(AuthorizationImitation.getUser() == null)
			return "0";
		return "1";
	}
}
