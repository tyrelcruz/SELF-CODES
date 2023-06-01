/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author Tyrel
 */
// LeaseAgreement Class
class LeaseAgreement {
    private double rentalPrice;
    private int leaseDuration;

    public LeaseAgreement(double rentalPrice, int leaseDuration) {
        this.rentalPrice = rentalPrice;
        this.leaseDuration = leaseDuration;
    }

    // Getters and setters

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getLeaseDuration() {
        return leaseDuration;
    }

    public void setLeaseDuration(int leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    // Methods for creating lease agreements and storing agreement details
    // ...
}