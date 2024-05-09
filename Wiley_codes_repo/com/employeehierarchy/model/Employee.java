package com.employeehierarchy.model;

public abstract class Employee {

    private int id;  // non-negative
    private String name; // shouldn't be null or blank
    private String email; // shouldn't be null or blank
    private float salary; // non-negative
    private Address address;

    public Employee(int id, String name, String email, float salary, Address address) {
        try {
            if (id <= 0) {
                throw new RuntimeException("ID should be a positive integer.");
            }
            this.id = id;

            if (name == null || name.isBlank()) {
                throw new RuntimeException("Name cannot be null or blank");
            }
            this.name = name;

            if (email == null || email.isBlank()) {
                throw new RuntimeException("Email cannot be null or blank");
            }
            this.email = email;

            if (salary <= 0) {
                throw new RuntimeException("Salary should be a positive number");
            }
            this.salary = salary;

            this.address = address;
        } catch (RuntimeException e) {
            System.out.println("Please enter valid inputs: " + e.getMessage());
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee(){
        System.out.println("Employee Initialized");
    }

    public Employee(int id){
        this.id = id;
    }

    public void setId(int id){
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("ID should be a positive integer.");
            }
            this.id = id;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting ID: " + e.getMessage());
        }
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or blank.");
            }
            this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting name: " + e.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("Email cannot be null or blank.");
            }
            this.email = email;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting email: " + e.getMessage());
        }
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        try {
            if (salary <= 0) {
                throw new IllegalArgumentException("Salary should be a positive number.");
            }
            this.salary = salary;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting salary: " + e.getMessage());
        }
    }

    public void setEmployeeDetails(int id){
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("ID should be a positive integer.");
            }
            this.id = id;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting ID: " + e.getMessage());
        }
    }

    public void setEmployeeDetails(String name){
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or blank.");
            }
            this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting name: " + e.getMessage());
        }
    }


    public abstract void showEmployeeInfo();

}
