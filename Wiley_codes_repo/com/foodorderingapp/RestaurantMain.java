package com.foodorderingapp;

import com.foodorderingapp.exception.RestaurantNotFoundException;
import com.foodorderingapp.model.Restaurant;
import com.foodorderingapp.repository.RestaurantRepository;
import com.foodorderingapp.repository.RestaurantRepositoryImpl;

public class RestaurantMain {
    public static void main(String[] args) {
        // Create an instance of the restaurant repository
        RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();

        try {
            // Initialize the repository with sample data
            ((RestaurantRepositoryImpl) restaurantRepository).init();

            // Add a restaurant
            Restaurant newRestaurant = new Restaurant("Burger Palace", "Location A");
            restaurantRepository.addRestaurant(newRestaurant);

            // Find a restaurant by name
            String restaurantName = "Burger Palace";
            Restaurant foundRestaurant = restaurantRepository.findRestaurantByName(restaurantName);

            if (foundRestaurant != null) {
                System.out.println("Found Restaurant:");
                System.out.println("Name: " + foundRestaurant.getName());
                System.out.println("Location: " + foundRestaurant.getLocation());
            } else {
                System.out.println("Restaurant not found.");
            }
        } catch (RestaurantNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
