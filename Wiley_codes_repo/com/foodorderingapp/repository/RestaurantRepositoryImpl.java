package com.foodorderingapp.repository;

import com.foodorderingapp.exception.RestaurantNotFoundException;
import com.foodorderingapp.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantRepositoryImpl implements RestaurantRepository {

    private Map<Long, Restaurant> restaurants;
    private RestaurantRepositoryImpl orderRepository;

    public RestaurantRepositoryImpl() {
        restaurants = new HashMap<>();
        init();
    }

    public void init() {
        restaurants.put(1L, new Restaurant(1L,"Desire Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(2L, new Restaurant(2L,"5star Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(3L, new Restaurant(3L,"Butterfly High Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(4L, new Restaurant(4L,"Hitchki Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(5L, new Restaurant(5L,"Desire Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(6L, new Restaurant(6L,"Desire Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(7L, new Restaurant(7L,"Desire Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(8L, new Restaurant(8L,"Desire Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(9L, new Restaurant(9L,"Desire Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(10L, new Restaurant(10L,"Desire Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(11L, new Restaurant(11L,"Desire Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(12L, new Restaurant(12L,"Desire Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
        restaurants.put(13L, new Restaurant(13L,"Desire Hotel","SYDN",List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99))));
// Adding some sample restaurants

//        restaurants.put(1L, new FastFoodRestaurant(1L, "Fast Food Restaurant 1", "Location A", CuisineType.FAST_FOOD_RESTAURANT,
//                List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99)),
//                List.of("Monday", "Tuesday"), List.of("Saturday", "Sunday")));
//        restaurants.put(3L,new FastFoodRestaurant(3L, "Fast Food Restaurant 3", "Location C", CuisineType.FAST_FOOD_RESTAURANT,
//                List.of(new MenuItem("Taco", 6.99), new MenuItem("Nachos", 3.99)),
//                List.of("Tuesday", "Thursday", "Saturday"), List.of("Monday", "Wednesday", "Friday")));
//
//        restaurants.put(4L,new FineDiningRestaurant(4L, "Fine Dining Restaurant 1", "Location D", CuisineType.FINE_DINING_RESTAURANT,
//                List.of(new MenuItem("Filet Mignon", 24.99), new MenuItem("Salmon", 21.99)),
//                List.of("Monday", "Wednesday", "Friday"), List.of("Sunday", "Tuesday")));
//        restaurants.put(5L,new FineDiningRestaurant(5L, "Fine Dining Restaurant 2", "Location E", CuisineType.FINE_DINING_RESTAURANT,
//                List.of(new MenuItem("Lobster Bisque", 18.99), new MenuItem("Caesar Salad", 14.99)),
//                List.of("Tuesday", "Thursday"), List.of("Monday", "Wednesday", "Friday", "Saturday")));
    }


    public Order getOrderById(long orderId) {
        // Assume orderRepository is a dependency injected or accessible instance of OrderRepository
        return orderRepository.getOrderById(orderId);
    }

    public void updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        if (restaurants.containsKey(restaurant.getRestaurantID())) {
            restaurants.put(restaurant.getRestaurantID(), restaurant);
        } else {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + restaurant.getRestaurantID());
        }
    }

    public void removeRestaurant(long restaurantId) throws RestaurantNotFoundException {
        if (restaurants.containsKey(restaurantId)) {
            restaurants.remove(restaurantId);
        } else {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + restaurantId);
        }
    }


    public List<Restaurant> getAllRestaurants() {
        System.out.println(restaurants.size()+" "+restaurants.values());
        return new ArrayList<>(restaurants.values());
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getRestaurantID(), restaurant);
    }


    public void setActivationStatus(long restaurantId, boolean status) {
        restaurants.values().forEach(restaurant -> restaurant.setActive(status));
    }

    public void updateMenuItem(MenuItem menuItem) {
        for (Restaurant restaurant : restaurants.values()) {
            List<MenuItem> menuItems = restaurant.getMenuItems();
            if (menuItems != null) {
                for (MenuItem existingMenuItem : menuItems) {
                    // Assuming menu item identity is determined by name
                    if (existingMenuItem.getName().equals(menuItem.getName())) {
                        existingMenuItem.setName(menuItem.getName());
                        existingMenuItem.setPrice(menuItem.getPrice());
                        return;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Menu item not found for update: " + menuItem.getName());
    }


    public Restaurant getRestaurantById(long id) {
        return restaurants.get(id);
    }


    public List<Restaurant> findRestaurantByLocation(String location) {
        List<Restaurant> foundRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants.values()) {
            if (restaurant.getLocation().equalsIgnoreCase(location)) {
                foundRestaurants.add(restaurant);
            }
        }
        return foundRestaurants;
    }


    public Restaurant findRestaurantByName(String name) {
        List<Restaurant> foundRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants.values()) {
            if (restaurant.getName().equalsIgnoreCase(name)) {
                foundRestaurants.add(restaurant);
            }
        }
        return (Restaurant) foundRestaurants;
    }


    public List<Restaurant> findRestaurantByType(CuisineType type) {
        List<Restaurant> foundRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants.values()) {
            if (restaurant.getCuisineType() == type) {
                foundRestaurants.add(restaurant);
            }
        }
        return foundRestaurants;
    }


    public List<Restaurant> findAllActiveRestaurant() {
        List<Restaurant> activeRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants.values()) {
            if (restaurant.isActive()) {
                activeRestaurants.add(restaurant);
            }
        }
        return activeRestaurants;
    }


    public List<Restaurant> findAllDeactivatedRestaurant() {
        List<Restaurant> deactivatedRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants.values()) {
            if (!restaurant.isActive()) {
                deactivatedRestaurants.add(restaurant);
            }
        }
        return deactivatedRestaurants;
    }
}
