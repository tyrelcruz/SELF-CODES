/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author Tyrel
 */
// AccessControl Class
class AccessControl {
    // Check the role of the logged-in user and grant or deny access to specific functionalities based on their role
    public static void checkAccess(User user) {
        if (user != null) {
            if (user.getRole().equals("landlord")) {
                System.out.println("Access granted to landlord functionalities.");
                // Implement landlord functionalities here
            } else if (user.getRole().equals("tenant")) {
                System.out.println("Access granted to tenant functionalities.");
                // Implement tenant functionalities here
            } else {
                System.out.println("Invalid role. Access denied!");
            }
        } else {
            System.out.println("Please log in first!");
        }
    }
}
