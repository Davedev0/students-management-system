package ProjectDev.menu;

import java.util.Scanner;
import ProjectDev.utils.*;
import ProjectDev.exceptions.errorHandler;


public class menu {
    public static void displayMenu() {
        cls.clearScreen();
        System.out.println(color.CYAN + "\n=== STUDENTS INFORMATION ===" + color.RESET);
        System.out.println(color.GREEN + "[1] Create Student");
        System.out.println("[2] View All Students");
        System.out.println("[3] Update Student");
        System.out.println("[4] Delete Student");
        System.out.println("[5] Back to Main Menu" + color.RESET);
        System.out.print("Select your choice: ");
    }
    
    public static int getMenuChoice(Scanner scanner) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                
                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    errorHandler.invalidChoice();
                    System.out.print("\nSelect your choice: ");
                }
            } catch (Exception e) {
                errorHandler.inputNumberOnly();
                scanner.nextLine();
                System.out.print("\nSelect your choice: ");
            }
        }
    }
}