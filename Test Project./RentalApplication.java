/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author Tyrel
 */// RentalApplication Class
class RentalApplication {
    private String personalInfo;
    private String financialInfo;
    private String applicationStatus;

    public RentalApplication(String personalInfo, String financialInfo) {
        this.personalInfo = personalInfo;
        this.financialInfo = financialInfo;
        this.applicationStatus = "Pending";
    }

    // Getters and setters

    public String getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(String personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getFinancialInfo() {
        return financialInfo;
    }

    public void setFinancialInfo(String financialInfo) {
        this.financialInfo = financialInfo;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    // Methods for submitting rental applications, storing application details, and tracking application status for tenants
    // ...
}