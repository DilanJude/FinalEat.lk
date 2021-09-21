package com.example.demo.controller;

import com.example.demo.model.Feedback;
import com.example.demo.service.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class FeedbackController {
    
    @Autowired
    FeedbackService feedbackService;

    @PostMapping("/submitFeedback")
    public int submitFeedback(@RequestBody Feedback feedback){
        try{
            feedbackService.submitFeedback(feedback);
            return 1;
        }
        catch(Exception exception){
            System.out.println(exception);
            return 0;
        }
    }
    
    @GetMapping("/comments/get/{name}")
    public List<Feedback> getComments(@PathVariable String name){
        return feedbackService.getComments(name);
    }
}