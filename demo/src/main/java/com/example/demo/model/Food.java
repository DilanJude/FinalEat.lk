package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Food")
public class Food {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "Restaurant_Name")
    private String restaurantName;

    @Column(name = "Food_Name")
    private String foodName;

    @Column(name = "Price")
    private String price;

    @Column(name = "Image_Url")
    private String imageURL;



    //empty constructor 
    public Food(){

    }

    //Constructor 
    public Food(String restaurantName, String foodName, String price, String imageURL){
        this.restaurantName = restaurantName;
        this.foodName = foodName;
        this.price = price;
        this.imageURL = imageURL;
    }

    //getters and setters
    public String getRestaurantName(){
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName){
        this.restaurantName = restaurantName;
    }



    public String getFoodName(){
        return foodName;
    }

    public void setFoodName(String foodName){
        this.foodName = foodName;
    }



    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }


    
    public String getImageURL(){
        return imageURL;
    }

    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }

}
