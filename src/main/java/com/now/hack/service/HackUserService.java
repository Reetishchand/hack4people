package com.now.hack.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.now.hack.Hack4PeopleApplication;
import com.now.hack.repository.HackUserRepository;

@Service
public class HackUserService {
	private static final Logger logger = LogManager.getLogger(Hack4PeopleApplication.class);
	@Autowired
private   HackUserRepository hackUserRepository;

}
