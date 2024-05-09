package com.foodorderingapp.repository;

import com.foodorderingapp.model.Customer;

import java.util.HashMap;

public class AuthRepo {
    public HashMap<String, Customer> db = new HashMap<>();
    public AuthRepo(){
        db.put("gaurav", new Customer("Gaurav", "Nsp", "gtiwari912@gmail.com","1234","O"));
        db.put("Aashu", new Customer("Aakansha", "Vasai", "aakanshas134@gmail.com","1234","A"));
        db.put("sonia", new Customer("Sonia", "Mira Rd", "sonia@gmail.com","1234","C"));
    }


}
