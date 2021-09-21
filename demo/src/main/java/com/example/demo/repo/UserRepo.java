package com.example.demo.repo;





import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



//Used to form the SQL Queries required to access the information

@Repository
public interface UserRepo extends JpaRepository<User, Long>{    //Jpa Repository allows the basic functionality of SQL queries and options to create our own 


    User findByEmailAndPassword (String email, String password);    //custom query for the login fucntion
    


}
