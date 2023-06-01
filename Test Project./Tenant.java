/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author Tyrel
 */
// Tenant Class (extended from User Class)
class Tenant extends User {
    public Tenant(String name, String email, String password) {
        super(name, email, password, "tenant");
    }

    // Methods specific to tenants for viewing property listings
    // ...
}