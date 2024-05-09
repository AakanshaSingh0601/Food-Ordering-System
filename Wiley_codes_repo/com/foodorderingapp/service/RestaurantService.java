package com.foodorderingapp.service;

import com.foodorderingapp.model.CuisineType;
import com.foodorderingapp.model.MenuItem;
import com.foodorderingapp.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public void activateRestaurant(long restaurantId);

    public void deActivateRestaurant(long restaurantId);

    public void updateMenuItem(MenuItem item);

    public Restaurant getRestaurantById(long id);

    public List<Restaurant> findRestaurantByLocation(String location);

    public List<Restaurant> findRestaurantByName(String name);

    public List<Restaurant> findRestaurantByType(CuisineType type);

    public List<Restaurant> findAllActiveRestaurant();

    public List<Restaurant> findAllDeactivatedRestaurant();}
