package com.now.hack.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.now.hack.Hack4PeopleApplication;
import com.now.hack.service.HackUserService;

@RestController
@RequestMapping(path = "/user")
public class HackUserController {
	private static final Logger logger = LogManager.getLogger(Hack4PeopleApplication.class);
	@Autowired
	private HackUserService hackUserService;

	@GetMapping("/test")
	public String index() {
		return "Hello! Welcome to Hack4People !";
	}

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestParam String input)

	{
		try {
			logger.info("User details {}", input);
			JSONObject inputJson = new JSONObject(input);
			if (inputJson.getString("email") == null || inputJson.getString("password") == null) {
				throw new Exception("Email or password is null");
			}
			String output = hackUserService.createNewUser(inputJson);
			return new ResponseEntity<String>(output, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Couldn't create new user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/signin")
	public ResponseEntity<String> signIn(@RequestParam String input)

	{
		try {
			logger.info("User details {}", input);
			JSONObject inputJson = new JSONObject(input);
			if (inputJson.getString("email") == null || inputJson.getString("password") == null) {
				throw new Exception("Email or password is null");
			}
			String output = hackUserService.userLogIn(inputJson);
			return new ResponseEntity<String>(output, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid Credentials", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/resetPassword")
	public ResponseEntity<String> resetPassword(@RequestParam String input)

	{
		try {
			logger.info("User details {}", input);
			JSONObject inputJson = new JSONObject(input);
			if (inputJson.getString("email") == null || inputJson.getString("password") == null) {
				throw new Exception("Email or password is null");
			}
			String output = hackUserService.changePassword(inputJson);
			return new ResponseEntity<String>(output, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid Credentials", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<String> getAllUsers(){
		try {
			String output = hackUserService.fetchAllUsers();
			return new ResponseEntity<String>(output,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/changePassword")
	public ResponseEntity<String> changePasswordsetPassword(@RequestParam String input) {
		try {
			logger.info("User details {}", input);
			JSONObject inputJson = new JSONObject(input);
			if (inputJson.getString("email") == null || inputJson.getString("oldPassword") == null
					|| inputJson.getString("password") == null) {
				throw new Exception("Email or password is null");
			}
			String output = hackUserService.checkAndchangePassword(inputJson);
			return new ResponseEntity<String>(output, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Check your Credentials and try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
