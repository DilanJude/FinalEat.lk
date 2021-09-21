package com.example.demo.controller;

import com.example.demo.model.RestaurantProfile;
import com.example.demo.service.RestaurantProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RestaurantProfileController {
    

    @Autowired
    RestaurantProfileService restaurantProfileService;


    @PostMapping("/createRprofile")
    public int createprofile(@RequestBody RestaurantProfile restaurantProfile){
        try{
            restaurantProfileService.createprofile(restaurantProfile);
            return 1;
        }
        catch(Exception exception){
            System.out.print(exception);
            return 0;
        }
    }

    @GetMapping("/getRprofile/{email}")
    public RestaurantProfile getRestaurantProfile(@PathVariable(name = "email")String email){
        return restaurantProfileService.getRestaurantProfile(email);
    }

    //get all
    @GetMapping("/getAll")
    public List<RestaurantProfile> getAll(){
        return restaurantProfileService.getAll();
    }

    //get by name

    @GetMapping("/get/{name}")
    public RestaurantProfile getRestaurant(@PathVariable String name){
        return restaurantProfileService.getProfile(name);
    }

    //get by cuisine
    @GetMapping("/get/cuisine/{cuisine}")
    public List<RestaurantProfile> getRestaurantsByCuisine(@PathVariable String cuisine){
        return restaurantProfileService.getAllByCuisine(cuisine);
    }

    //get by type
    @GetMapping("/get/type/{type}")
    public List<RestaurantProfile> getRestaurantsByType(@PathVariable String type){
        return restaurantProfileService.getAllByType(type);
    }


    //return unverified
    @GetMapping("/get/unverified")
    public List<RestaurantProfile> getUnverifiedRestaurants(){
        return restaurantProfileService.getUnverifiedRestaurants();
    }

    //verify

    @PutMapping("/verify/{name}")
    public int verify(@PathVariable String name){
        return restaurantProfileService.verifyRestaurant(name);
    }



    @PutMapping("/updateRestaurantProfile")
    public int updateRestaurantProfile(@RequestBody RestaurantProfile restaurantProfile){
        return restaurantProfileService.updateRestaurant(restaurantProfile);
    }
}