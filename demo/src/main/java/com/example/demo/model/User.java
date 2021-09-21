package com.example.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//This class refers to the Users table in the database

@Entity
@Table(name = "User")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)                    //Auto generating primary key
    private long id;



    @Column(name = "email")                                               //Corresponds to the columns of the table
    private String email;


    @Column(name = "password")                                      
    private String password;

    @Column(name = "type")
    private String type; 



    //empty constructor 
    public User(){

    }


    //Constructor
    public User(String email, String password, String type){
        this.email = email;
        this.password = password; 
        this.type = type;

    }


    //getters and setters - Means to access,set and modify information in the table
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }



    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }




    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }





   







}

