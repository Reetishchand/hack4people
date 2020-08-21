package com.now.hack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.now.hack.model.User;


@Repository
public interface HackUserRepository extends CrudRepository<User,Integer> {
	

}
