package com.foodorderingapp.controller;

import com.foodorderingapp.model.Customer;
import com.foodorderingapp.repository.AuthRepo;

import java.util.*;

public class AuthController {
    AuthRepo repo = new AuthRepo();


    public void signIn(){
        System.out.print("Enter username:");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        System.out.print("Enter password: ");
        String password = sc.next();


        if(repo.db.containsKey(userName)){
            Customer customer = repo.db.get(userName);
            if(customer.getPassword().equals(password)){
                UserController userController = new UserController();
                if(customer.getUserType().equals("C")){
                    userController.showAllHotels();
                }
                else if(customer.getUserType().equals("A")){
                    userController.showAllHotels();
                }
               else if(customer.getUserType().equals("O")){
                    userController.showAllHotels();
                }
            }
            else{
                System.out.println("Wrong password");
            }
        }
        else {
            System.out.println("wrong username");
        }

    }






}
