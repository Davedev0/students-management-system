package ProjectDev.menu;

import java.util.Scanner;
import ProjectDev.utils.*;
import ProjectDev.exceptions.errorHandler;
import ProjectDev.controllers.studentSystem;

public class mainMenu {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void displayWelcomeScreen() {
        cls.clearScreen();
        System.out.println(color.CYAN + "+====================================+");
        System.out.println("|  WELCOME TO STUDENT MANAGEMENT     |");
        System.out.println("+====================================+" + color.RESET);
        System.out.print("\nPlease wait...");
        
        try {
            // Wait for 3 seconds (3000 milliseconds)
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void displayMainMenu() {
        cls.clearScreen();
        System.out.println(color.CYAN + "\n=== STUDENT SYSTEM MANAGEMENT ===" + color.RESET);
        System.out.println(color.GREEN + "[1] Home");
        System.out.println("[2] About Us");
        System.out.println("[3] Exit" + color.RESET);
        System.out.print("Select your choice: ");
    }
    
    public static void handleMainMenu() {
        // Display welcome screen first
        displayWelcomeScreen();
        
        boolean running = true;
        
        try {
            while (running) {
                displayMainMenu();
                
                // Keep trying until we get valid input
                while (true) {
                    try {
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        
                        switch (choice) {
                            case 1:
                                studentSystem.start();
                                break;
                            case 2:
                                displayAboutUs();
                                break;
                            case 3:
                                System.out.print(color.GREEN + "\nExiting Program..." + color.RESET);
                                running = false;
                                break;
                            default:
                                errorHandler.invalidChoice();
                                System.out.print("\nSelect your choice: ");
                                continue; // show menu again
                        }
                        break; // exit the input loop if we got valid input
                    } catch (Exception e) {
                        scanner.nextLine(); // clear invalid input
                        errorHandler.inputNumberOnly();
                        System.out.print("\nSelect your choice: ");
                    }
                }
            }
        } finally {
            scanner.close();
        }
    }
    
    private static void displayAboutUs() {
        cls.clearScreen();
        System.out.println(color.CYAN + "=== ABOUT US ===" + color.RESET);
        System.out.println(color.YELLOW + "This is a Student Information System");
        System.out.println("Created for educational purposes" + color.RESET);
        cls.pressEnterToReturn();
    }
}