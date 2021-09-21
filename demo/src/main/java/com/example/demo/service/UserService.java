package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Used to provide the functionality, and uses the repo class in methods

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;


    public void register(User user){              //Registration method
        userRepo.save(user);                 
    }




    public int login(User user){                  //Login method

        User currentUser = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());

        

        if(currentUser != null){

            
            if(currentUser.getType().equals("Customer")){
                return 1; 
            }
            else if(currentUser.getType().equals("Restaurant")) {
                return 2;
            }
            else {
                return 3;
            }
        }
        else{
            return 0;
        }
    }

}
