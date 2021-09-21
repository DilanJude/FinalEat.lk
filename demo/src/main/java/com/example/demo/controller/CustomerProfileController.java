package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class CustomerProfileController {
    
    @Autowired
    CustomerProfileService customerProfileService;

    @PostMapping("/createprofile")
    public int createprofile(@RequestBody CustomerProfile customerProfile){
        try{
            customerProfileService.createprofile(customerProfile);
            return 1;
        }
        catch(Exception exception){
            System.out.print(exception);
            return 0;
        }
    }

    @GetMapping("/getprofile/{email}")
    public CustomerProfile getCustomerProfile(@PathVariable(name = "email") String email){
        return customerProfileService.getCustomerProfile(email);
    }

    @PutMapping("/updateProfile")
    public int updateCustomerProfile(@RequestBody CustomerProfile customerProfile){
        return customerProfileService.updateCustomer(customerProfile);
    }



    //get all for admin view
    @GetMapping("/getAllCustomers")
    public List<CustomerProfile> getAllCustomers(){
        return customerProfileService.getAllCustomers();
    }
    
}
