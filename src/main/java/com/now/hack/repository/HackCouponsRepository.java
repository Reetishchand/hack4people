package com.now.hack.repository;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.now.hack.model.Coupons;

@Repository
public interface HackCouponsRepository extends CrudRepository<Coupons, BigInteger>, Serializable {

}
