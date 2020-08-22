package com.now.hack.repository;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.now.hack.model.User;

@Repository
public interface HackUserRepository extends CrudRepository<User, BigInteger>, Serializable {

	@Query("SELECT u FROM User u WHERE u.email = ?1 and u.password = ?2")
	User getUserDetails(String email, String password);

	@Query("Select u from User u")
	List<User> getAllUsers();

	@Modifying
	@Query("update User u set u.password = ?2 where u.email=?1")
	User updateUserPassword(String email, String newPassword);

}
