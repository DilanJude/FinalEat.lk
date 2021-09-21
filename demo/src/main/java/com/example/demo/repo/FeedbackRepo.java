package com.example.demo.repo;

import com.example.demo.model.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Long> {

    List<Feedback> findAllByRestaurantName(String restaurantName);
}
