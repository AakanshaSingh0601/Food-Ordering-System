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
        // Adding some sample restaurants
        addRestaurant(new FastFoodRestaurant(1L, "Fast Food Restaurant 1", "Location A", CuisineType.FAST_FOOD_RESTAURANT,
                List.of(new MenuItem("Burger", 5.99), new MenuItem("Fries", 2.99)),
                List.of("Monday", "Tuesday"), List.of("Saturday", "Sunday")));
        addRestaurant(new FastFoodRestaurant(2L, "Fast Food Restaurant 2", "Location B", CuisineType.FAST_FOOD_RESTAURANT,
                List.of(new MenuItem("Pizza", 8.99), new MenuItem("Hot Dog", 4.99)),
                List.of("Monday", "Wednesday", "Friday"), List.of("Sunday")));
        addRestaurant(new FastFoodRestaurant(3L, "Fast Food Restaurant 3", "Location C", CuisineType.FAST_FOOD_RESTAURANT,
                List.of(new MenuItem("Taco", 6.99), new MenuItem("Nachos", 3.99)),
                List.of("Tuesday", "Thursday", "Saturday"), List.of("Monday", "Wednesday", "Friday")));

        addRestaurant(new FineDiningRestaurant(4L, "Fine Dining Restaurant 1", "Location D", CuisineType.FINE_DINING_RESTAURANT,
                List.of(new MenuItem("Filet Mignon", 24.99), new MenuItem("Salmon", 21.99)),
                List.of("Monday", "Wednesday", "Friday"), List.of("Sunday", "Tuesday")));
        addRestaurant(new FineDiningRestaurant(5L, "Fine Dining Restaurant 2", "Location E", CuisineType.FINE_DINING_RESTAURANT,
                List.of(new MenuItem("Lobster Bisque", 18.99), new MenuItem("Caesar Salad", 14.99)),
                List.of("Tuesday", "Thursday"), List.of("Monday", "Wednesday", "Friday", "Saturday")));
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
