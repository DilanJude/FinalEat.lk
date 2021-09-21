package com.example.demo.service;

import com.example.demo.model.Feedback;
import com.example.demo.repo.FeedbackRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepo feedbackRepo;

    public void submitFeedback(Feedback feedback){
        feedbackRepo.save(feedback);
    }

    public List<Feedback> getComments(String restaurantName){
        return feedbackRepo.findAllByRestaurantName(restaurantName);
    }
}
