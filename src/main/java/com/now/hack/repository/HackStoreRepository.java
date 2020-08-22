package com.now.hack.repository;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.now.hack.model.Store;

@Repository
public interface HackStoreRepository extends CrudRepository<Store, BigInteger>, Serializable {

}
