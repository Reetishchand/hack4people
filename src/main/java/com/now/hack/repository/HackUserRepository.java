package com.now.hack.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface HackUserRepository extends CrudRepository<User,Integer> {
	

}
