/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author Tyrel
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class to test the application
public class Main {
    private static final String USER_FILE = "users.txt";

    public static void main(String[] args) {
        List<User> userList = loadUserList();
        List<Property> propertyList = new ArrayList<>();
        List<RentalApplication> applicationList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // User registration
        User user1 = User.registerUser();
        userList.add(user1);
        saveUserList(userList);

        // User login
        User loggedInUser = User.login(userList);

        // Role-based access control
        AccessControl.checkAccess(loggedInUser);

        // Property listing
        if (loggedInUser instanceof Landlord) {
            System.out.println("Do you want to create a property listing? (yes/no)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                Property property = createPropertyListing(scanner);
                propertyList.add(property);
            }
        }

        // Tenant viewing property listings
        if (loggedInUser instanceof Tenant) {
            System.out.println("Viewing property listings:");
            for (Property property : propertyList) {
                System.out.println("Location: " + property.getLocation());
                System.out.println("Size: " + property.getSize());
                System.out.println("Price: " + property.getPrice());
                System.out.println("Available Dates: " + property.getAvailableDates());
                System.out.println("--------------------");
            }
        }

        // Tenant submitting rental application
        if (loggedInUser instanceof Tenant) {
            System.out.println("Do you want to submit a rental application? (yes/no)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                RentalApplication application = createRentalApplication(scanner);
                applicationList.add(application);
            }
        }

        // Landlord viewing and managing rental applications
        if (loggedInUser instanceof Landlord) {
            System.out.println("Viewing rental applications:");
            for (RentalApplication application : applicationList) {
                System.out.println("Personal Info: " + application.getPersonalInfo());
                System.out.println("Financial Info: " + application.getFinancialInfo());
                System.out.println("Application Status: " + application.getApplicationStatus());
                System.out.println("--------------------");
            }

            System.out.println("Do you want to accept or reject any rental applications? (yes/no)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Enter the index of the rental application you want to manage: ");
                int index = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (index >= 0 && index < applicationList.size()) {
                    RentalApplication application = applicationList.get(index);
                    System.out.println("Enter 'accept' or 'reject' to manage the application: ");
                    String action = scanner.nextLine();

                    if (action.equalsIgnoreCase("accept")) {
                        application.setApplicationStatus("Accepted");
                        System.out.println("Rental application accepted!");
                    } else if (action.equalsIgnoreCase("reject")) {
                        application.setApplicationStatus("Rejected");
                        System.out.println("Rental application rejected!");
                    } else {
                        System.out.println("Invalid action!");
                    }
                } else {
                    System.out.println("Invalid index!");
                }
            }
        }

        // Lease agreement
        System.out.println("Do you want to create a lease agreement? (yes/no)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            double rentalPrice;
            int leaseDuration;

            System.out.println("Enter rental price: ");
            rentalPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            System.out.println("Enter lease duration (in months): ");
            leaseDuration = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            LeaseAgreement leaseAgreement = new LeaseAgreement(rentalPrice, leaseDuration);
            System.out.println("Lease agreement created successfully!");

            if (loggedInUser instanceof Landlord) {
                // Landlord signing lease agreement
                System.out.println("Do you want to sign the lease agreement? (yes/no)");
                choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("yes")) {
                    System.out.println("Lease agreement signed by the landlord!");
                }
            } else if (loggedInUser instanceof Tenant) {
                // Tenant signing lease agreement
                System.out.println("Do you want to sign the lease agreement? (yes/no)");
                choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("yes")) {
                    System.out.println("Lease agreement signed by the tenant!");
                }
            }
        }

        // Lease management
        if (loggedInUser instanceof Landlord || loggedInUser instanceof Tenant) {
            System.out.println("Do you want to renew or terminate a lease? (yes/no)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                if (loggedInUser instanceof Landlord) {
                    // Landlord renewing or terminating a lease
                    System.out.println("Enter the index of the lease you want to manage: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (index >= 0 && index < propertyList.size()) {
                        System.out.println("Enter 'renew' or 'terminate' to manage the lease: ");
                        String action = scanner.nextLine();

                        if (action.equalsIgnoreCase("renew")) {
                            System.out.println("Lease renewed by the landlord!");
                        } else if (action.equalsIgnoreCase("terminate")) {
                            System.out.println("Lease terminated by the landlord!");
                        } else {
                            System.out.println("Invalid action!");
                        }
                    } else {
                        System.out.println("Invalid index!");
                    }
                } else if (loggedInUser instanceof Tenant) {
                    // Tenant requesting lease renewal or termination
                    System.out.println("Enter 'renew' or 'terminate' to manage your lease: ");
                    String action = scanner.nextLine();

                    if (action.equalsIgnoreCase("renew")) {
                        System.out.println("Lease renewal requested by the tenant!");
                    } else if (action.equalsIgnoreCase("terminate")) {
                        System.out.println("Lease termination requested by the tenant!");
                    } else {
                        System.out.println("Invalid action!");
                    }
                }
            }
        }

        // Rental payment
        if (loggedInUser instanceof Tenant) {
            System.out.println("Do you want to make a rental payment? (yes/no)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                RentalPayment payment = makeRentalPayment(scanner);
                // Store payment details and update payment status
                System.out.println("Rental payment made successfully!");
            }
        }
    }

    // Helper method to create a property listing
    private static Property createPropertyListing(Scanner scanner) {
        System.out.print("Enter property location: ");
        String location = scanner.nextLine();
        System.out.print("Enter property size: ");
        double size = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter property price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter property available dates: ");
        String availableDates = scanner.nextLine();

        Property property = new Property(location, size, price, availableDates);
        System.out.println("Property listing created successfully!");
        return property;
    }

    // Helper method to create a rental application
    private static RentalApplication createRentalApplication(Scanner scanner) {
        System.out.print("Enter personal information: ");
        String personalInfo = scanner.nextLine();
        System.out.print("Enter financial information: ");
        String financialInfo = scanner.nextLine();

        RentalApplication application = new RentalApplication(personalInfo, financialInfo);
        System.out.println("Rental application submitted successfully!");
        return application;
    }

    // Helper method to make a rental payment
    private static RentalPayment makeRentalPayment(Scanner scanner) {
        System.out.print("Enter due dates: ");
        String dueDates = scanner.nextLine();
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        RentalPayment payment = new RentalPayment(dueDates, amount);
        System.out.println("Rental payment made successfully!");
        return payment;
    }

    // Helper method to save the user list to a file
    private static void saveUserList(List<User> userList) {
        try (PrintWriter writer = new PrintWriter("C:\\Users\\Tyrel\\Documents\\NetBeansProjects\\TEST\\src\\main\\java\\com\\mycompany\\test\\users.txt")) {
            for (User user : userList) {
                writer.println(user.toCsvString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while saving user accounts: " + e.getMessage());
        }
    }

    // Helper method to load the user list from a file
    private static List<User> loadUserList() {
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Tyrel\\Documents\\NetBeansProjects\\TEST\\src\\main\\java\\com\\mycompany\\test\\users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String name = parts[0];
                    String email = parts[1];
                    String password = parts[2];
                    String role = parts[3];

                    User user;
                    if (role.equals("Landlord")) {
                        user = new Landlord(name, email, password);
                    } else if (role.equals("Tenant")) {
                        user = new Tenant(name, email, password);
                    } else {
                        continue; // Skip invalid user role
                    }

                    userList.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while loading user accounts: " + e.getMessage());
        }
        return userList;
    }
}
