package com.example.demo.repo;

import com.example.demo.model.CustomerProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProfileRepo extends JpaRepository<CustomerProfile, Long> {
    
    CustomerProfile findByEmail(String email);
}
