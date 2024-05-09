package com.foodorderingapp.model;

import java.time.LocalTime;
import java.util.List;

public class FineDiningRestaurant extends Restaurant {
    public FineDiningRestaurant(long restaurantID, String name, String location, CuisineType cuisineType, List<MenuItem> menuItems, LocalTime openingTime, LocalTime closingTime, boolean isActive, double rating) {
        super(name, location);
    }

    public FineDiningRestaurant(long restaurantID, String name, String locationD, CuisineType cuisineType, List<MenuItem> menuItems, List<String> monday, List<String> sunday) {
    }
}
