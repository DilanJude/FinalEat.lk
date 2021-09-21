package com.example.demo;

import com.example.demo.model.RestaurantProfile;
import com.example.demo.service.RestaurantProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	RestaurantProfileService restaurantProfileService;

	@Test
	void contextLoads() {

		restaurantProfileService.createprofile(new RestaurantProfile("McDonalds"));
		restaurantProfileService.createprofile(new RestaurantProfile("Pizza Hut"));
		restaurantProfileService.createprofile(new RestaurantProfile("KFC"));

	}

}
