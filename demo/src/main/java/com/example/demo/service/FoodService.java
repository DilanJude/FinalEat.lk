package com.example.demo.service;

import com.example.demo.model.Food;
import com.example.demo.model.FoodDTO;
import com.example.demo.repo.FoodRepo;
import com.example.demo.utils.FileStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoodService {
    
    @Autowired
    FoodRepo foodRepo;

    @Autowired
    FileStorage fileStorage;

    public int saveFood(FoodDTO foodDTO){
        try{
            foodDTO.setRestaurantId(UUID.randomUUID());
            String url = fileStorage.storeFile(foodDTO.getRestaurantId().toString(), foodDTO.getImage());

            Food food = new Food(
                    foodDTO.getRestaurantName(),
                    foodDTO.getFoodName(),
                    foodDTO.getPrice(),
                    url
            );

            foodRepo.save(food);
            return 1;
        }

        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }




    public List<Food> getFood(String restaurantName){
        return foodRepo.findAllByRestaurantName(restaurantName);
    }
}