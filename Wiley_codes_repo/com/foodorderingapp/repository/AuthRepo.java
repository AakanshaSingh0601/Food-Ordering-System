package com.foodorderingapp.repository;

import com.foodorderingapp.model.Customer;

import java.util.HashMap;

public class AuthRepo {
    public HashMap<String, Customer> db = new HashMap<>();
    public AuthRepo(){
        db.put("gtiwari912@gmail.com", new Customer("Gaurav", "Nsp", "gtiwari912@gmail.com","1234"));
        db.put("aakanshas134@gmail.com", new Customer("Aakansha", "Vasai", "aakanshas134@gmail.com","1234"));
        db.put("Sonia", new Customer("Sonia", "Mira Rd", "sonia@gmail.com","1234"));
    }


}
