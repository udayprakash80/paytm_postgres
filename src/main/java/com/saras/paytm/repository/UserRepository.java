package com.saras.paytm.repository;

import com.saras.paytm.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Boolean existsByUsername(String username);
    Optional<Users> findByUsername(String username);
    Boolean existsByEmail(String email);


}
