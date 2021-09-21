package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Restaurant_name")
    private String restaurantName;

    @Column(name = "Customer_name")
    private String customerName;

    @Column(name = "Rating")
    private String rating;

    @Column(name = "Comment")
    private String comment;

    //Contructors and Getters and Setters

    //empty constructor
    public Feedback(){

    }

    //constructor
    public Feedback(String restaurantName, String customerName, String rating, String comment){
        this.restaurantName = restaurantName;
        this.customerName = customerName;
        this.rating = rating;
        this.comment = comment;  
    }

    //Getters and setters

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

}
