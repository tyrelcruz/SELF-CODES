/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author Tyrel
 */
// RentalPayment Class
class RentalPayment {
    private String dueDates;
    private double amount;
    private String paymentStatus;

    public RentalPayment(String dueDates, double amount) {
        this.dueDates = dueDates;
        this.amount = amount;
        this.paymentStatus = "Pending";
    }

    // Getters and setters

    public String getDueDates() {
        return dueDates;
    }

    public void setDueDates(String dueDates) {
        this.dueDates = dueDates;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Methods for making rental payments and viewing payment history for tenants
    // ...
}