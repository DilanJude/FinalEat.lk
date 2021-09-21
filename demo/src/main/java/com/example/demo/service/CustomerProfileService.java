package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repo.CustomerProfileRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerProfileService {
    
    @Autowired
    CustomerProfileRepo customerProfileRepo;

    public void createprofile(CustomerProfile customerProfile){
        customerProfileRepo.save(customerProfile);
    }



    public CustomerProfile getCustomerProfile(String email){
        CustomerProfile customerProfile = customerProfileRepo.findByEmail(email);
        return customerProfile;
    }

    public int updateCustomer(CustomerProfile customerProfile) {
        try{
            CustomerProfile currentCustomer = customerProfileRepo.findByEmail(customerProfile.getEmail());

            if(currentCustomer != null){

               currentCustomer.setName(customerProfile.getName());
               currentCustomer.setAddress(customerProfile.getAddress());
               currentCustomer.setDOB(customerProfile.getDOB());
               currentCustomer.setGender(customerProfile.getGender());
               currentCustomer.setNumber(customerProfile.getNumber());

               customerProfileRepo.save(currentCustomer);
               return 1;
            }

            else{
                // User not found
                return -1;
            }
        }

        catch(Exception exception){
            return 0;
        }
    }


    //get all customers for admin view 
    public List<CustomerProfile> getAllCustomers(){
        return customerProfileRepo.findAll();
    }









}
