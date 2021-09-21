package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food, Long> {
    
    List<Food> findAllByRestaurantName(String restaurantName);
}
