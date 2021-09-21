package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Food;
import com.example.demo.model.FoodDTO;
import com.example.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @PostMapping("/save")
    public int save(@ModelAttribute FoodDTO foodDTO){
       return foodService.saveFood(foodDTO);
    }

    @GetMapping("/get/{name}")
    public List<Food> getFood(@PathVariable String name){
        return foodService.getFood(name);
    }

}
