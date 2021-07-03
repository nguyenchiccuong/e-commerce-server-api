package com.rookies.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rookies.ecommerceapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
