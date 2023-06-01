/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author Tyrel
 */
// Landlord Class (extended from User Class)
class Landlord extends User {
    public Landlord(String name, String email, String password) {
        super(name, email, password, "landlord");
    }

    // Methods specific to landlords for creating and managing property listings
    // ...
}
