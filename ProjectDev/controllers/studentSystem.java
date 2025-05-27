package ProjectDev.controllers;

import java.util.Scanner;
import ProjectDev.menu.*;

public class studentSystem {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void start() {
        boolean inStudentSystem = true;
        
        try {
            while (inStudentSystem) {
                menu.displayMenu();
                int choice = menu.getMenuChoice(scanner);
                
                if (choice == 5) {
                    inStudentSystem = false;
                } else {
                    menuHandler.handleMenuChoice(choice);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}