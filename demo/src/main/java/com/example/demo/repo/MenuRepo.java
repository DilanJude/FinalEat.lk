package com.example.demo.repo;

import com.example.demo.model.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {
    

    Menu findByName(String name);

    Menu findByEmail(String email);
}
