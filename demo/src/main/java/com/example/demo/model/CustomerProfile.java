package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Profile")
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email; 

    @Column(name = "DOB")
    private String DOB;

    @Column(name = "address")
    private String address;
    
    @Column(name = "number")
    private String number;

    @Column( name = "gender")
    private String gender;

    @Column(name = "healthy")
    private String healthy;


    //Constructors and Getters and Setters 


    //empty constructor 
    public CustomerProfile(){

    }

    //Constructor 
    public CustomerProfile(String name, String email, String DOB, String address, String number, String gender, String healthy){
        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.address = address;
        this.number = number;
        this.gender = gender; 
        this.healthy = healthy;
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



    public String getDOB(){
        return DOB;
    }

    public void setDOB(String DOB){
        this.DOB = DOB;
    }



    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }



    public String getNumber(){
        return number;
    }

    public void setNumber (String number){
        this.number = number;
    }



    public String getGender(){
        return gender;
    }

    public void setGender (String gender){
        this.gender = gender;
    }


    public String getHealthy(){
        return healthy;
    }

    public void setHealthy(String healthy){
        this.healthy = healthy;
    }


    
}
