package com.foodorderingapp.controller;

import com.foodorderingapp.model.MenuItem;
import com.foodorderingapp.model.Restaurant;
import com.foodorderingapp.repository.RestaurantRepository;
import com.foodorderingapp.repository.RestaurantRepositoryImpl;
import com.foodorderingapp.utils.GlobalScanner;

import java.util.List;

public class UserController {
    RestaurantRepositoryImpl restroRepo = new RestaurantRepositoryImpl();

    public void showAllHotels(){
        List<Restaurant> restoList = restroRepo.getAllRestaurants();
        System.out.println("List of restros are: ");
        int index = 0;
        for(Restaurant resto: restoList) {
            System.out.println(index + ". " + resto.getName());
            index++;
        }
        System.out.println("Pick your restro");
        index = GlobalScanner.getInstance().nextInt();
        showRestoDetailPageByIndex(index);
    }

    public void showRestoDetailPageByIndex(int index){
        Restaurant restaurant = restroRepo.getAllRestaurants().get(index);
        System.out.println("Name:"+restaurant.getName());
        System.out.println("Location:"+restaurant.getLocation());
        System.out.println("Rating:"+restaurant.getRating());
        System.out.println("Opening:"+restaurant.getOpeningTime());
        System.out.println("Closing:"+restaurant.getClosingTime());
        System.out.println("List of menus are:");
        int menuIndex = 0;
        for(MenuItem menu: restaurant.getMenuItems()){
            System.out.println(menuIndex+". Name:"+menu.getName()+" price:"+menu.getPrice());
            menuIndex++;
        }
    }

    public void showAdminPanel(){
        showAdminPanelOptions();
        int choice= GlobalScanner.getInstance().nextInt();
        while (choice!= -1){
            if (choice == 1) {
                System.out.print("Enter name: ");
                String restName = GlobalScanner.getInstance().next();
                String location= GlobalScanner.getInstance().next();
                restroRepo.addRestaurant(new Restaurant(restName, location));
                System.out.println("Restraunt Added Successfully!!");
            }
            else if (choice == 2) {
                System.out.print("Enter Restaurant ID to remove:");
                int idtoRemove = GlobalScanner.getInstance().nextInt();
                restroRepo.removeRestaurant(idtoRemove);
                System.out.println("Restrant Removed Successfully!!");
            }
            else if (choice == 3) {
                List<Restaurant> restoList = restroRepo.getAllRestaurants();
                System.out.println("List of restros are: ");
                int index = 0;
                for(Restaurant resto: restoList) {
                    System.out.println(index + ". " + resto.getName());
                    index++;
                }
            }
            showAdminPanelOptions();
            choice = GlobalScanner.getInstance().nextInt();
        }


    }

    public void showAdminPanelOptions(){
        System.out.println("=============ADMIN PANEL OPTIONS===============");
        System.out.println("1.Add Restaurant");
        System.out.println("2.Remove Restaurant");
        System.out.println("3.Show All Restaurant");
        System.out.println("-1. TO end program");
        System.out.print("enter choice again:");
    }
}
