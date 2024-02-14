package com.saras.paytm.repository;

import com.saras.paytm.entity.PaytmUser;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<PaytmUser, Integer> {

    Optional<PaytmUser> findByUserName(String userName);

}
