package com.example.demo.service;

import com.example.demo.model.RestaurantProfile;
import com.example.demo.repo.RestaurantProfileRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantProfileService {
    

    @Autowired
    RestaurantProfileRepo restaurantProfileRepo;

    public void createprofile(RestaurantProfile restaurantProfile){
       restaurantProfile.setVerified(false);
       restaurantProfileRepo.save(restaurantProfile);
    }

    public RestaurantProfile getRestaurantProfile(String email){
        RestaurantProfile restaurantProfile = restaurantProfileRepo.findByEmail(email);
        return restaurantProfile;
    }

    //Returns all restaurant profiles
    public List<RestaurantProfile> getAll() {
        return restaurantProfileRepo.findAll();
    }

    //Get restaurant profile by name
    public RestaurantProfile getProfile(String name) {
        return restaurantProfileRepo.findByName(name);
    }

    //Get restaurants by cuisine
    public List<RestaurantProfile> getAllByCuisine(String cuisine) {
        try{
            return restaurantProfileRepo.findAllByCuisine(cuisine);
        }

        catch(Exception exception){
            System.out.println(exception);
            return null;
        }
    }

    //Get restaurants by Type
    public List<RestaurantProfile> getAllByType(String type) {
        try{
            return restaurantProfileRepo.findAllByType(type);
        }

        catch(Exception exception){
            System.out.println(exception);
            return null;
        }
    }

    public void test(RestaurantProfile restaurantProfile){

        RestaurantProfile currentProfile = restaurantProfileRepo.findByEmail(restaurantProfile.getEmail());

        currentProfile.setCuisine(restaurantProfile.getCuisine());

        restaurantProfileRepo.save(currentProfile);
    }

    public List<RestaurantProfile> getUnverifiedRestaurants(){
        return restaurantProfileRepo.findAllByVerified(false);
    }

    public int verifyRestaurant(String name){

        try{
            RestaurantProfile restaurantProfile = restaurantProfileRepo.findByName(name);
            restaurantProfile.setVerified(true);
            
            restaurantProfileRepo.save(restaurantProfile);
            return 1;
        }

        catch(Exception exception){
            System.out.println(exception);
            return 0;
        }
    }



    public int updateRestaurant(RestaurantProfile restaurantProfile){
        try{
            RestaurantProfile currentRestaurant = restaurantProfileRepo.findByEmail(restaurantProfile.getEmail());

            if(currentRestaurant != null){

                currentRestaurant.setName(restaurantProfile.getName());
                currentRestaurant.setAddress(restaurantProfile.getAddress());
                currentRestaurant.setDescription(restaurantProfile.getDescription());
                currentRestaurant.setCuisine(restaurantProfile.getCuisine());
                currentRestaurant.setType(restaurantProfile.getType());
                currentRestaurant.setNumber(restaurantProfile.getNumber());
                currentRestaurant.setWebsite(restaurantProfile.getWebsite());

                restaurantProfileRepo.save(currentRestaurant);
                return 1;
            }

            else{
                //User not found 
                return -1;
            }


        }
        catch(Exception exception){
            return 0;
        }

        
    }






}
