/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author Tyrel
 */
// Property Class
import java.util.Scanner;

class Property {
    private String location;
    private double size;
    private double price;
    private String availableDates;

    public Property(String location, double size, double price, String availableDates) {
        this.location = location;
        this.size = size;
        this.price = price;
        this.availableDates = availableDates;
    }

    // Getters and setters

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(String availableDates) {
        this.availableDates = availableDates;
    }

    // Methods for creating and managing property listings
    public static void createPropertyListing(User user) {
        if (user.getRole().equals("landlord")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter property location: ");
            String location = scanner.nextLine();
            System.out.print("Enter property size: ");
            double size = scanner.nextDouble();
            System.out.print("Enter property price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter property available dates: ");
            String availableDates = scanner.nextLine();

            Property property = new Property(location, size, price, availableDates);
            System.out.println("Property listing created successfully!");
        } else {
            System.out.println("Only landlords can create property listings.");
        }
    }

    // Other methods for managing property listings (update, delete, etc.)
    // ...
}
