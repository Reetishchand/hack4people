package com.now.hack.repository;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.now.hack.model.UserTransactions;

@Repository
public interface HackUserTransactionRepository extends CrudRepository<UserTransactions, BigInteger>, Serializable {

}
