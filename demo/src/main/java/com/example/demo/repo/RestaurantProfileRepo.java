package com.example.demo.repo;

import com.example.demo.model.RestaurantProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantProfileRepo extends JpaRepository<RestaurantProfile, Long> {
    
    RestaurantProfile findByEmail(String email);
    RestaurantProfile findByName(String name);

    List<RestaurantProfile> findAllByCuisine(String cuisine);
    List<RestaurantProfile> findAllByType(String type);
    List<RestaurantProfile> findAllByVerified(boolean verified);
}
