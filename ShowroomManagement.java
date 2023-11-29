import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

// Car class representing a car model
class Car {
    String model;
    double price;

    // Constructor to initialize the car model and price
    Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    // Method to display car details
    void displayDetails() {
        System.out.println("Car Model: " + model);
        System.out.println("Price: $" + price);
    }
}

// Showroom class managing cars, payments, and transactions
class Showroom {
    Car[] cars;
    double totalRevenue;

    // Constructor to initialize the showroom
    Showroom() {
        cars = new Car[5]; // Assuming 5 different car models
        totalRevenue = 0;
    }

    // Method to add a new car to the showroom
    void addCar(String model, double price) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = new Car(model, price);
                System.out.println("Car added to the showroom.");
                return;
            }
        }
        System.out.println("Showroom is full. Cannot add more cars.");
    }

    // Method to sell a car and process payment
    void sellCar(int index) {
        if (index >= 0 && index < cars.length && cars[index] != null) {
            cars[index].displayDetails();
            totalRevenue += cars[index].price;
            System.out.println("Payment received. Total Revenue: $" + totalRevenue);

            // Remove the sold car from the showroom
            cars[index] = null;
        } else {
            System.out.println("Invalid car index. Cannot sell the car.");
        }
    }

    // Method to display all available cars in the showroom
    void displayAvailableCars() {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                System.out.println("Car " + (i + 1) + ": " + cars[i].model);
            }
        }
    }

    // Method to save showroom details to a file
    void saveShowroomToFile() {
        try {
            File file = new File("showroom.txt");
            FileWriter writer = new FileWriter(file);

            for (Car car : cars) {
                if (car != null) {
                    writer.write(car.model + "," + car.price + "\n");
                }
            }

            writer.write("Total Revenue: $" + totalRevenue);

            writer.close();
            System.out.println("Showroom details saved to 'showroom.txt'");
        } catch (IOException e) {
            System.out.println("Error saving showroom details to file.");
        }
    }

    // Method to load showroom details from a file
    void loadShowroomFromFile() {
        try {
            File file = new File("showroom.txt");
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                reader.close();
            } else {
                System.out.println("Showroom file does not exist.");
            }
        } catch (IOException e) {
            System.out.println("Error loading showroom details from file.");
        }
    }
}

public class ShowroomManagement {
    public static void main(String[] args) {
        Showroom showroom = new Showroom();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            // Display the menu
            System.out.println("\nShowroom Management System");
            System.out.println("1. Add Car to Showroom");
            System.out.println("2. Sell Car");
            System.out.println("3. Display Available Cars");
            System.out.println("4. Save Showroom Details to File");
            System.out.println("5. Load Showroom Details from File");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            // Get user input for menu choice
            choice = scanner.nextInt();

            // Process user choice
            switch (choice) {
                case 1:
                    // Add a new car to the showroom
                    System.out.print("Enter Car Model: ");
                    String model = scanner.next();
                    System.out.print("Enter Car Price: $");
                    double price = scanner.nextDouble();
                    showroom.addCar(model, price);
                    break;

                case 2:
                    // Sell a car from the showroom
                    System.out.print("Enter Car Index to Sell: ");
                    int sellIndex = scanner.nextInt();
                    showroom.sellCar(sellIndex - 1); // Subtract 1 to match array index
                    break;

                case 3:
                    // Display available cars in the showroom
                    showroom.displayAvailableCars();
                    break;

                case 4:
                    // Save showroom details to a file
                    showroom.saveShowroomToFile();
                    break;

                case 5:
                    // Load showroom details from a file
                    showroom.loadShowroomFromFile();
                    break;

                case 0:
                    // Exit the program
                    System.out.println("Exiting Showroom Management System. Goodbye!");
                    break;

                default:
                    // Handle invalid choice
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);

        // Close the scanner
        scanner.close();
    }
}
