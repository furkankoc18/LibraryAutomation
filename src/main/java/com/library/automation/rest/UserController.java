package com.library.automation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.automation.service.UserService;

@RequestMapping(value = "/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
}
