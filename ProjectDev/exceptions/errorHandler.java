package ProjectDev.exceptions;

import ProjectDev.utils.*;

public class errorHandler {
    
    //Kapag wala sa menu ang number or lumagpas sa hinihingi
    public static void invalidChoice() {
        System.out.println(color.RED + "\nInvalid choice, Please select correctly!" + color.RESET);
    }
    
    //Kapag letter ang input sa menu
    public static void inputNumberOnly() {
        System.out.println(color.RED + "\nInvalid input, Please enter a number only!" + color.RESET);
    }
    
    //Validation kapag ang hinihingi lang ay yes or no 
    public static void inputYesOrNoOnly() {
        System.out.println(color.RED + "\nInvalid input, Please enter 'yes' or 'no' only!" + color.RESET);
    }
    
    //kapag nag input ng letter sa age
    public static void invalidAge() {
        System.out.println(color.RED + "\nInvalid input! Age must be a number." + color.RESET);
    }
    
    //kapag nag input ng letter sa id
    public static void invalidId() {
        System.out.println(color.RED + "\nInvalid input! ID must be a number.\n" + color.RESET);
    }
}