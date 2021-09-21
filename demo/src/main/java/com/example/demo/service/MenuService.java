package com.example.demo.service;

import com.example.demo.model.Menu;
import com.example.demo.repo.MenuRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MenuService {
    

    @Autowired
    MenuRepo menuRepo;


    public void createMenu(Menu menu){
        menuRepo.save(menu);
    }



    public Menu getRMenu(String email){
        Menu menu = menuRepo.findByEmail(email);
        return menu;
    }


    public Menu getCMenu(String name){
        Menu menu = menuRepo.findByName(name);
        return menu;
    }
}
