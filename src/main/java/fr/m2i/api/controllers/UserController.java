package fr.m2i.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/user/{username}")
	public String getUserPage(@PathVariable("username") String username) {
		System.out.println("Page for " + username);
		return "Ok";
	}
	
	
	@PostMapping("/user")
	public String postUser(@RequestBody String username){
		System.out.println(username + "is created");
		return "Ok";
	}
}
