package com.now.hack.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.now.hack.Hack4PeopleApplication;
import com.now.hack.service.HackUserService;

@RestController
@RequestMapping(path = "/user")
public class HackUserController {
    private static final Logger logger = LogManager.getLogger(Hack4PeopleApplication.class);
@Autowired
private HackUserService  hackuserService;

	@GetMapping("/test")
    public String index() {
		return "Hello! Welcome to Hack4People !";
	}
    

}
