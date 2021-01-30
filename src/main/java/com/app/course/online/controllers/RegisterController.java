package com.app.course.online.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.course.online.user.AuthorizationImitation;
import com.app.course.online.user.User;
import com.app.course.online.user.UserService;

@RestController
public class RegisterController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	@CrossOrigin
    public String saveTime(@ModelAttribute User user) {
		
		try
		{
			userService.saveUser(user);
		}catch(Exception e)
		{
			return e.getMessage();
		}

        return "Rejestracja przebiegła pomyślnie.";  
     }
	
	@PostMapping(value = "/signIn")
	@CrossOrigin
	public ResponseEntity<?> login(@ModelAttribute User user) {
		try
		{
			if(user.getEmail().isEmpty())
				return ResponseEntity.status(500).build();
			
			User lUser = userService.findUserByEmail(user.getEmail());
			if(lUser == null)
				return ResponseEntity.status(500).build();
			
			BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
			if(bCrypt.matches(user.getPassword(), lUser.getPassword()))
			{
				AuthorizationImitation.setUser(lUser);
				return ResponseEntity.ok("Witaj " + lUser.getName() + " " + lUser.getSurname());
			}
				
			
			return ResponseEntity.status(500).build();
		}catch(Exception e)
		{
			return ResponseEntity.status(500).build();
		}
	}
	
	@PostMapping(value = "/signOut")
	@CrossOrigin
	public String logout(String s) {
			if(AuthorizationImitation.getUser() == null)
				return "Do wylogowania trzeba być zalogowanym.";
		
			AuthorizationImitation.setUser(null);
			return "Wylogowano";
	}
}
