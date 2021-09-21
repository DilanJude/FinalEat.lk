package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Restaurant_Profile")
public class RestaurantProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "cuisine")
    private String cuisine;

    @Column(name = "type")
    private String type;


    @Column(name = "number")
    private String number;

    @Column(name = "website")
    private String website;

    @Column(columnDefinition = "boolean")
    private boolean verified;





    //Contstructors and Getters and Setters

    //empty constructor
    public RestaurantProfile(){

    }

    public RestaurantProfile(String name) {
        this.name = name;
    }

    //constructor
    public RestaurantProfile(String name, String email, String address, String description, String cuisine, String type,  String number, String website ){
        this.name = name;
        this.email = email;
        this.address = address;
        this.description = description;
        this.cuisine = cuisine;
        this.type = type;
        this.number = number;
        this.website = website;
        this.verified = false;
    }


    //getters and setters

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }



    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }





    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }





    
    public String getCuisine(){
        return cuisine;
    }

    public void setCuisine(String cuisine){
        this.cuisine = cuisine;
    }






    
    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }



    public String getNumber(){
        return number;
    }

    public void setNumber(String number){
        this.number = number;
    }






    public String getWebsite(){
        return website;
    }

    public void setWebsite(String website){
        this.website = website;
    }


    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
