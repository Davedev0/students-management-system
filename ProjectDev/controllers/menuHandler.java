package ProjectDev.controllers;

import ProjectDev.services.*;
import ProjectDev.exceptions.errorHandler;

public class menuHandler {
    public static void handleMenuChoice(int choice) {
        try {
            switch (choice) {
                case 1: 
                    crud.createPerson();
                    break;
                case 2: 
                    crud.readAllPeople();
                    break;
                case 3:
                    crud.updatePerson();
                    break;
                case 4:
                    crud.deletePerson();
                    break;
                default:
                    errorHandler.invalidChoice();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}