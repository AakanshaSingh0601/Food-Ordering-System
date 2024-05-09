package com.foodorderingapp.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private long restaurantID;
    private String name;

    private String Location;
    private CuisineType cuisineType;
   //private Map<String,MenuItem> menu;
    private List<MenuItem> menuItems;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private boolean isActive;
    private double rating;

    public Restaurant(long restaurantID, String name, String location, List<MenuItem> menuItems) {
        this.restaurantID = restaurantID;
        this.name = name;
        Location = location;
        this.menuItems = menuItems;
    }

    public Restaurant(long restaurantID, String name, String location, CuisineType cuisineType, List<MenuItem> menuItems, LocalTime openingTime, LocalTime closingTime, boolean isActive, double rating) {
        this.restaurantID = restaurantID;
        this.name = name;
        Location = location;
        this.cuisineType = cuisineType;
        this.menuItems = menuItems;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.isActive = isActive;
        this.rating = rating;
    }

    public Restaurant(String name, String location) {
        this.restaurantID = restaurantID;
        this.name = name;
        Location = location;
        this.cuisineType = cuisineType;
        this.menuItems = menuItems;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.isActive = true;
        this.rating = 0.0;
    }

    public Restaurant() {

    }


    public Restaurant(List<MenuItem> menuItems) {
        this.menuItems = menuItems != null ? menuItems : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(long restaurantID) {
        this.restaurantID = restaurantID;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //    public Map<String, MenuItem> getMenu() {
//        return menu;
//    }
//
//   public void addItemMenu(MenuItem item){
//        menu.put(item.getName(), item);
//   }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

//    public String getCuisineType() {
//        return cuisineType;
//    }
//
//    public void setCuisineType(String cuisineType) {
//        this.cuisineType = cuisineType;
//    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
