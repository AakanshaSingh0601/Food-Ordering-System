package com.foodorderingapp;

import com.foodorderingapp.controller.AuthController;
import com.foodorderingapp.model.*;
import com.foodorderingapp.repository.*;
import com.foodorderingapp.service.OrderService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodOrderingAppMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
    private static final OrderRepository orderRepository = new OrderRepositoryImpl();
    private static final DeliveryRepository deliveryRepository = new DeliveryRepositoryImpl();

    public static void main(String[] args){
        AuthController controller = new AuthController();
        controller.signIn();
    }

    public static void mainn(String[] args) {
        boolean isAdmin = false;
        while (true) {
            System.out.println("Are you an admin? (Y/N)");
            String isAdminInput = scanner.nextLine().toUpperCase();
            if (isAdminInput.equals("Y")) {
                isAdmin = true;
                break;
            } else if (isAdminInput.equals("N")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }

        if (isAdmin) {
            adminMenu();
        } else {
            customerMenu();
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Update Restaurant");
            System.out.println("3. Remove Restaurant");
            System.out.println("4. Add Menu Item");
            System.out.println("5. Update Menu Item");
            System.out.println("6. Remove Menu Item");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addRestaurant();
                    break;
                case 2:
                    updateRestaurant();
                    break;
                case 3:
                    removeRestaurant();
                    break;
                case 4:
                    addMenuItem();
                    break;
                case 5:
                    updateMenuItem();
                    break;
                case 6:
                    removeMenuItem();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void customerMenu() {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Browse Restaurants");
            System.out.println("2. Browse Menu");
            System.out.println("3. Check Order Status");
            System.out.println("4. Place Order");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    browseRestaurants();
                    break;
                case 2:
                    browseMenu();
                    break;
                case 3:
                    checkOrderStatus();
                    break;
                case 4:
                    placeOrder();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }



    public static void initSampleRestaurants() {
        RestaurantRepositoryImpl restaurantRepoImpl = (RestaurantRepositoryImpl) restaurantRepository;

        restaurantRepoImpl.init();
        System.out.println("Sample restaurants initialized.");
    }

    private static void addRestaurant() {
        // Creating sample menu items
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Burger", 5.99));
        menuItems.add(new MenuItem("Pizza", 8.99));

        // Adding a new restaurant
        Restaurant restaurant = new FastFoodRestaurant(1L, "Fast Food Restaurant", "Location A",
                CuisineType.FAST_FOOD_RESTAURANT, menuItems, LocalTime.of(10, 0),
                LocalTime.of(22, 0), true, 0.0);
        restaurantRepository.addRestaurant(restaurant);
        System.out.println("Restaurant added successfully.");
    }

    private static void updateRestaurant() {
        System.out.println("Enter the ID of the restaurant you want to update:");
        long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        Restaurant restaurant = restaurantRepository.getRestaurantById(restaurantId);
        if (restaurant != null) {
            // Assuming you have setters for each property in the Restaurant class
            System.out.println("Enter the new name of the restaurant:");
            restaurant.setName(scanner.nextLine());

            System.out.println("Enter the new location of the restaurant:");
            restaurant.setLocation(scanner.nextLine());

            System.out.println("Enter the new opening time (HH:mm) of the restaurant:");
            restaurant.setOpeningTime(LocalTime.parse(scanner.nextLine()));

            System.out.println("Enter the new closing time (HH:mm) of the restaurant:");
            restaurant.setClosingTime(LocalTime.parse(scanner.nextLine()));

            System.out.println("Is the restaurant active? (true/false):");
            restaurant.setActive(scanner.nextBoolean());

            System.out.println("Enter the new rating of the restaurant:");
            restaurant.setRating(scanner.nextDouble());

            // Assuming you have a method to update the restaurant in the repository
            restaurantRepository.updateRestaurant(restaurant);
            System.out.println("Restaurant updated successfully.");
        } else {
            System.out.println("Restaurant not found with ID: " + restaurantId);
        }
    }

    private static void removeRestaurant() {
        System.out.println("Enter the ID of the restaurant you want to remove:");
        long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        Restaurant restaurant = restaurantRepository.getRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurantRepository.removeRestaurant(restaurantId);
            System.out.println("Restaurant removed successfully.");
        } else {
            System.out.println("Restaurant not found with ID: " + restaurantId);
        }
    }

    private static void addMenuItem() {
        System.out.println("Enter the ID of the restaurant to which you want to add the menu item:");
        long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        Restaurant restaurant = restaurantRepository.getRestaurantById(restaurantId);
        if (restaurant != null) {
            System.out.println("Enter the name of the new menu item:");
            String itemName = scanner.nextLine();

            System.out.println("Enter the price of the new menu item:");
            double itemPrice = scanner.nextDouble();

            // Create the new menu item
            MenuItem newItem = new MenuItem(itemName, itemPrice);

            // Add the menu item to the restaurant
            restaurant.getMenuItems().add(newItem);
            System.out.println("Menu item added successfully.");
        } else {
            System.out.println("Restaurant not found with ID: " + restaurantId);
        }
    }

    private static void updateMenuItem() {
        System.out.println("Enter the ID of the restaurant where the menu item is located:");
        long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        Restaurant restaurant = restaurantRepository.getRestaurantById(restaurantId);
        if (restaurant != null) {
            System.out.println("Enter the name of the menu item you want to update:");
            String itemName = scanner.nextLine();

            // Find the menu item in the restaurant's menu
            MenuItem itemToUpdate = null;
            for (MenuItem item : restaurant.getMenuItems()) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    itemToUpdate = item;
                    break;
                }
            }

            if (itemToUpdate != null) {
                System.out.println("Enter the new name of the menu item:");
                itemToUpdate.setName(scanner.nextLine());

                System.out.println("Enter the new price of the menu item:");
                itemToUpdate.setPrice(scanner.nextDouble());
                System.out.println("Menu item updated successfully.");
            } else {
                System.out.println("Menu item not found in the restaurant's menu.");
            }
        } else {
            System.out.println("Restaurant not found with ID: " + restaurantId);
        }
    }

    private static void removeMenuItem() {
        System.out.println("Enter the ID of the restaurant where the menu item is located:");
        long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        Restaurant restaurant = restaurantRepository.getRestaurantById(restaurantId);
        if (restaurant != null) {
            System.out.println("Enter the name of the menu item you want to remove:");
            String itemName = scanner.nextLine();

            // Find the menu item in the restaurant's menu
            MenuItem itemToRemove = null;
            for (MenuItem item : restaurant.getMenuItems()) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    itemToRemove = item;
                    break;
                }
            }

            if (itemToRemove != null) {
                restaurant.getMenuItems().remove(itemToRemove);
                System.out.println("Menu item removed successfully.");
            } else {
                System.out.println("Menu item not found in the restaurant's menu.");
            }
        } else {
            System.out.println("Restaurant not found with ID: " + restaurantId);
        }
    }

    private static void browseRestaurants() {
        List<Restaurant> allRestaurants = restaurantRepository.getAllRestaurants();
        if (allRestaurants.isEmpty()) {
            System.out.println("No restaurants available.");
        } else {
            System.out.println("Available Restaurants:");
            for (Restaurant restaurant : allRestaurants) {
                System.out.println("ID: " + restaurant.getRestaurantID() + ", Name: " + restaurant.getName());
            }
        }
    }

    private static void browseMenu() {
        System.out.println("Enter the ID of the restaurant whose menu you want to browse:");
        long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        Restaurant restaurant = restaurantRepository.getRestaurantById(restaurantId);
        if (restaurant != null) {
            List<MenuItem> menuItems = restaurant.getMenuItems();
            if (menuItems.isEmpty()) {
                System.out.println("No menu items available for this restaurant.");
            } else {
                System.out.println("Menu for " + restaurant.getName() + ":");
                for (MenuItem item : menuItems) {
                    System.out.println("Name: " + item.getName() + ", Price: $" + item.getPrice());
                }
            }
        } else {
            System.out.println("Restaurant not found with ID: " + restaurantId);
        }
    }


    private static void checkOrderStatus() {
        Scanner scanner = new Scanner(System.in); // Create a new scanner instance
        System.out.println("Enter the ID of the order you want to check:");
        long orderId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        OrderService orderService = (OrderService) new OrderRepositoryImpl(); // Create an instance of OrderService
        Order order = orderService.getOrderByRepository(orderId); // Call the method on the instance
        if (order != null) {
            System.out.println("Order Status: " + order.getStatus());
        } else {
            System.out.println("Order not found with ID: " + orderId);
        }
        scanner.close(); // Close the scanner to prevent resource leak
    }

    private static void placeOrder() {
        Scanner scanner = new Scanner(System.in); // Create a new scanner instance

        System.out.println("Enter your customer ID:");
        long customerId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter your delivery address:");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Enter your card number:");
        String cardNumber = scanner.nextLine();

        System.out.println("Enter expiry date of your card (MM/YY):");
        String expiryDate = scanner.nextLine();

        System.out.println("Enter CVV of your card:");
        String cvv = scanner.nextLine();

        OrderRepository orderRepository = new OrderRepositoryImpl(); // Create an instance of OrderRepository
        // Assuming customerId, deliveryAddress, cardNumber, expiryDate, and cvv are defined
        Order order = new Order(customerId, deliveryAddress, cardNumber, expiryDate, cvv);
        orderRepository.placeOrder(order); // Call the method with the Order object

        System.out.println("Order placed successfully!");

        scanner.close(); // Close the scanner to prevent resource leak
    }


}
