# JAVA-2-ASSIGNMENT
Syeda Maha Pirzada

Assignment 2:
1.	Car Class:
•	Represents a car model with attributes model and price.
•	Has a constructor to initialize the car model and price.
•	Contains a method displayDetails to print the car model and price.
2.	Showroom Class:
•	Manages an array of cars (Car[] cars) and total revenue (double totalRevenue).
•	Constructor initializes the array and revenue.
•	addCar method adds a new car to the showroom if space is available.
•	sellCar method sells a car at a specified index, updates total revenue, and removes the sold car.
•	displayAvailableCars method shows the models of available cars.
•	saveShowroomToFile method saves showroom details to a file (showroom.txt).
•	loadShowroomFromFile method loads showroom details from the file.
3.	ShowroomManagement Class (Main Class):
•	Contains the main method, the entry point of the program.
•	Creates an instance of the Showroom class and a Scanner for user input.
•	Provides a menu-driven interface for users with options to:
•	Add a car to the showroom.
•	Sell a car from the showroom.
•	Display available cars.
•	Save showroom details to a file.
•	Load showroom details from a file.
•	Exit the program.
4.	Menu Handling in Main:
•	User enters a choice (integer) based on the displayed menu.
•	Switch statement processes the user's choice:
•	Case 1: Add a new car to the showroom.
•	Case 2: Sell a car from the showroom.
•	Case 3: Display available cars.
•	Case 4: Save showroom details to a file.
•	Case 5: Load showroom details from a file.
•	Case 0: Exit the program.
•	Default: Handle invalid choices.
5.	User Input:
•	Uses a Scanner to get user input for various operations.
6.	File Handling:
•	Uses FileWriter to save showroom details to a file.
•	Uses FileReader and BufferedReader to load showroom details from a file.
•	Catches IOException for error handling.
7.	Looping:
•	The program runs in a loop until the user chooses to exit (enters 0).
8.	Closing Resources:
•	Closes the Scanner at the end of the program.
This program provides a simple interactive system for managing a car showroom, allowing users to perform operations such as adding cars, selling cars, and saving/loading showroom details.

