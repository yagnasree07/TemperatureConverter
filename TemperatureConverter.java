// src/TemperatureConverter.java
import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("--- Java Console Temperature Converter ---");

        while (choice != 4) {
            displayMenu();

            try {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    
                    switch (choice) {
                        case 1:
                            convertFahrenheitToCelsius(scanner);
                            break;
                        case 2:
                            convertCelsiusToFahrenheit(scanner);
                            break;
                        case 3:
                            convertCelsiusToKelvin(scanner);
                            break;
                        case 4:
                            System.out.println("Exiting the converter. Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
                    }
                } else {
                    // Handle non-integer input
                    System.out.println("Invalid input. Please enter a number from the menu.");
                    scanner.next(); // Consume the invalid token
                }
            } catch (InputMismatchException e) {
                // Catch generic mismatch (e.g., if a non-number is entered later)
                System.out.println("Input error. Please try again with valid numbers.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Choose a Conversion ---");
        System.out.println("1. Fahrenheit (°F) to Celsius (°C)");
        System.out.println("2. Celsius (°C) to Fahrenheit (°F)");
        System.out.println("3. Celsius (°C) to Kelvin (K)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    private static void convertFahrenheitToCelsius(Scanner scanner) {
        System.out.print("Enter temperature in Fahrenheit: ");
        if (scanner.hasNextDouble()) {
            double fahrenheit = scanner.nextDouble();
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.printf("%.2f °F is equal to %.2f °C\n", fahrenheit, celsius);
        } else {
            System.out.println("Invalid temperature input. Please enter a number.");
            scanner.next(); // Consume invalid input
        }
    }

    private static void convertCelsiusToFahrenheit(Scanner scanner) {
        System.out.print("Enter temperature in Celsius: ");
        if (scanner.hasNextDouble()) {
            double celsius = scanner.nextDouble();
            double fahrenheit = (celsius * 9 / 5) + 32;
            System.out.printf("%.2f °C is equal to %.2f °F\n", celsius, fahrenheit);
        } else {
            System.out.println("Invalid temperature input. Please enter a number.");
            scanner.next();
        }
    }

    private static void convertCelsiusToKelvin(Scanner scanner) {
        System.out.print("Enter temperature in Celsius: ");
        if (scanner.hasNextDouble()) {
            double celsius = scanner.nextDouble();
            // Kelvin = Celsius + 273.15
            double kelvin = celsius + 273.15;
            System.out.printf("%.2f °C is equal to %.2f K\n", celsius, kelvin);
        } else {
            System.out.println("Invalid temperature input. Please enter a number.");
            scanner.next();
        }
    }
}