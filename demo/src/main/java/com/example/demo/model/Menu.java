package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "item1")
    private String item1;

    @Column(name = "item2")
    private String item2;

    @Column(name = "item3")
    private String item3;

    @Column(name = "item4")
    private String item4;

    @Column(name = "item5")
    private String item5;



    //Constructors and Getters and Setters

    //Empty constructor
    
    public Menu(){

    }


    //constructor 
    public Menu(String name, String email, String item1, String item2, String item3, String item4, String item5 ){
        this.name = name;
        this.email = email;
        this.item1 = item1;
        this.item2 = item2; 
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
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



    public String getItem1(){
        return item1;
    }

    public void setItem1(String item1){
        this.item1 = item1;
    }





    public String getItem2(){
        return item2;
    }

    public void setItem2(String item2){
        this.item2 = item2;
    }




    public String getItem3(){
        return item3;
    }

    public void setItem3(String item3){
        this.item3 = item3;
    }





    public String getItem4(){
        return item4;
    }

    public void setItem4(String item4){
        this.item4 = item4;
    }





    public String getItem5(){
        return item5;
    }

    public void setItem5(String item5){
        this.item5 = item5;
    }











}
