package com.example.demo.controller;

import com.example.demo.model.Menu;
import com.example.demo.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MenuController {
    

    @Autowired
    MenuService menuService;


    @PostMapping("/createmenu")
    public int createmenu(@RequestBody Menu menu){
        try{
            menuService.createMenu(menu);
            return 1;
        }
        catch(Exception exception){
            System.out.print(exception);
            return 0;
        }
    }


    @GetMapping("/getRmenu/{email}")
    public Menu getRmenu(@PathVariable(name = "email")String email){
        return menuService.getRMenu(email);
    }


    @GetMapping("/getCmenu/{name}")
    public Menu getCmenue(@PathVariable(name = "name")String name){
        return menuService.getCMenu(name);
    }






}
