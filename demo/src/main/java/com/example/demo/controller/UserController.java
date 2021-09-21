package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController           //specifies the type of API (rest api)
@CrossOrigin              //Solves error in chrome
@RequestMapping("/api")  //localhost:8085/api (adds "api" to the url)


//The controller class deploys the functionality of the service class

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")           //defines the url for the register function 
    public int register(@RequestBody User user){              //Applies the register method to the information received via the application 
        try{
            userService.register(user);
            return 1;
        }
        catch(Exception exception){
            System.out.println(exception);
            return 0;
        }
    }




    @PostMapping("/login")               //defines the url for the register function 
    public int login(@RequestBody User user){        //Applies the login method to the information received via the application 
        try{
            return userService.login(user);
        
        }
        catch(Exception exception){
            System.out.println(exception);
            return 0;
        }
    }
    
}
