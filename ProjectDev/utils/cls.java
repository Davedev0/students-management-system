package ProjectDev.utils;

import java.util.Scanner;

//this code is provided, do not touch!
//https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
public class cls {
    static Scanner scanner = new Scanner(System.in);
    
    public static void clearScreen() {
        
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
          } System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void pressEnterToReturn() {
            System.out.print("\nPress enter to return...");
            scanner.nextLine();
    }
}