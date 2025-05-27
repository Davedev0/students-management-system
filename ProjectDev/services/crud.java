package ProjectDev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ProjectDev.utils.*;
import ProjectDev.views.*;
import ProjectDev.exceptions.errorHandler;

public class crud {
    private static List<Person> people = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);
    
    // Gumawa ng bagong person
    public static void createPerson() {
        cls.clearScreen();
        System.out.println(color.CYAN + "\n=== CREATE STUDENT INFO ===" + color.RESET);
        try {
            System.out.print("Enter full name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter course: ");
            String course = scanner.nextLine();
            
            System.out.print("Enter section: ");
            String section = scanner.nextLine();
            
            // Age input with validation
            int age = 0;
            boolean validAge = false;
            while (!validAge) {
                try {
                    System.out.print("Enter age: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); 
                    validAge = true;
                } catch (Exception e) {
                    errorHandler.invalidAge();
                    scanner.nextLine(); // Clear invalid input
                } 
            }
                
            if (age <= 3 || age >= 80) {
                System.out.println(color.RED + "\nInvalid age! Age must be between 4 and 79." + color.RESET);
                System.out.print("\nTry again to create (yes/no): ");
                String ageValidation = scanner.nextLine().toLowerCase();
            
                if (ageValidation.equals("yes")) {
                    createPerson();
                    return;
                } else if (ageValidation.equals("no")) {
                    cls.pressEnterToReturn();
                    cls.clearScreen();
                    return;
                } else {
                    errorHandler.inputYesOrNoOnly();
                }
            } 
            
            Person person = new Person(nextId++, name, course, section, age);
            people.add(person);
          
            System.out.println(color.YELLOW + "\nStudent created successfully!" + color.RESET);
            ui.printSinglePerson(person);
                        
        } catch (Exception e) {
            errorHandler.invalidAge();
            scanner.nextLine();
        }
            
        while (true) {
            System.out.print("\nCreate a new student (yes/no): ");
            String createNewStudent = scanner.nextLine().toLowerCase();
            
            if (createNewStudent.equals("yes")) {
                createPerson();
                return;
            } else if (createNewStudent.equals("no")) {
                cls.pressEnterToReturn();
                cls.clearScreen();
                return;
            } else {
                errorHandler.inputYesOrNoOnly();
            }
        }
    }
    
    // Ipakita ang lahat ng mga persons
    public static void readAllPeople() {
        cls.clearScreen();
        System.out.println(color.CYAN + "\n=== LIST OF STUDENTS ===" + color.RESET);
        if (people.isEmpty()) {
            ui.printRowEmpty();
            cls.pressEnterToReturn();
            cls.clearScreen();
            return;
        }
        
        ui.printTableHeader();
        for (Person person : people) {
            System.out.println(person.toTableRow());
            ui.printRowSeparate();
        }
        
        cls.pressEnterToReturn();
        cls.clearScreen();
    }

    // I-update ang isang person
    public static void updatePerson() {
        cls.clearScreen();
        System.out.println(color.CYAN + "\n=== UPDATE STUDENT INFO ===" + color.RESET);
        while (true) {
            try {
                System.out.print("Enter ID of student to update: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 
                
                Person personToUpdate = null;
                for (Person person : people) {
                    if (person.getId() == id) {
                        personToUpdate = person;
                        break;
                    }
                }

                if (personToUpdate == null) {
                    System.out.print(color.RED + "\nStudent with ID " + id + " not found." + color.RESET);
                    ui.printRowEmpty();
                    System.out.print("\nTry again to update (yes/no): ");
                    String tryAgainToUpdate = scanner.nextLine().toLowerCase();
                
                    if (tryAgainToUpdate.equals("yes")) {
                        continue;
                    } else if (tryAgainToUpdate.equals("no")) {
                        cls.pressEnterToReturn();
                        cls.clearScreen();
                        return;
                    } else {
                        errorHandler.inputYesOrNoOnly();
                    }
                    continue;
                }

                System.out.println(color.YELLOW + "\nCurrent details:" + color.RESET);
                ui.printSinglePerson(personToUpdate);
                
                // Get new name
                System.out.print("\nEnter new name (current: " + personToUpdate.getName() + "): ");
                String newName = scanner.nextLine();
                
                // Get new course
                System.out.print("Enter new course (current: " + personToUpdate.getCourse() + "): ");
                String newCourse = scanner.nextLine();
                
                // Get new section
                System.out.print("Enter new section (current: " + personToUpdate.getSection() + "): ");
                String newSection = scanner.nextLine();
                
                // Get new age with validation
                int newAge = 0;
                boolean validAge = false;
                while (!validAge) {
                    try {
                        System.out.print("Enter new age (current: " + personToUpdate.getAge() + "): ");
                        newAge = scanner.nextInt();
                        scanner.nextLine();
                        validAge = true;
                    } catch (Exception e) {
                        errorHandler.invalidAge();
                        scanner.nextLine();
                    }
                }
                
                if (newAge <= 3 || newAge >= 80) {
                    System.out.println(color.RED + "\nInvalid age! Age must be between 4 and 79." + color.RESET);
                    System.out.print("\nTry again to update (yes/no): ");
                    String ageValidation = scanner.nextLine().toLowerCase();
                
                    if (ageValidation.equals("yes")) {
                        continue;
                    } else if (ageValidation.equals("no")) {
                        cls.pressEnterToReturn();
                        cls.clearScreen();
                        return;
                    } else {
                        errorHandler.inputYesOrNoOnly();
                    }
                }

                // Add confirmation before mag update
                while (true) {
                    System.out.print("\nAre you sure you want to update this student? (yes/no): ");
                    String confirmUpdate = scanner.nextLine().toLowerCase();
                    
                    if (confirmUpdate.equals("yes")) {
                        personToUpdate.setName(newName);
                        personToUpdate.setCourse(newCourse);
                        personToUpdate.setSection(newSection);
                        personToUpdate.setAge(newAge);
                        System.out.println(color.YELLOW + "\nStudent updated successfully!" + color.RESET);
                        ui.printSinglePerson(personToUpdate);
                        cls.pressEnterToReturn();
                        cls.clearScreen();
                        return;
                    } else if (confirmUpdate.equals("no")) {
                        System.out.println(color.RED + "\nUpdate cancelled!" + color.RESET);
                        cls.pressEnterToReturn();
                        cls.clearScreen();
                        return;
                    } else {
                        errorHandler.inputYesOrNoOnly();
                    } 
                }
                
            } catch (Exception e) {
                errorHandler.invalidId();
                scanner.nextLine();
            }
        }
    }

    // Tanggalin ang isang person
    public static void deletePerson() {
        cls.clearScreen();
        System.out.println(color.CYAN + "\n=== DELETE STUDENT INFO ===" + color.RESET);
        while (true) {
            try {
                System.out.print("Enter ID of student to delete: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 

                Person personToDelete = null;
                for (Person person : people) {
                    if (person.getId() == id) {
                        personToDelete = person;
                        break;
                    }
                }

                if (personToDelete == null) {
                    System.out.print(color.RED + "\nStudent with ID " + id + " not found." + color.RESET);
                    ui.printRowEmpty();
                    System.out.print("\nTry again to delete (yes/no): ");
                    String tryAgainToDelete = scanner.nextLine().toLowerCase();
                
                    if (tryAgainToDelete.equals("yes")) {
                        continue;
                    } else if (tryAgainToDelete.equals("no")) {
                        cls.pressEnterToReturn();
                        cls.clearScreen();
                        return;
                    } else {
                        errorHandler.inputYesOrNoOnly();
                    }
                    continue;
                }
                
                while (true) {
                    System.out.println(color.YELLOW + "\nCurrent details:" + color.RESET);
                    ui.printSinglePerson(personToDelete);
                    System.out.print("\nAre you sure to delete (yes/no): ");
                    String toDeletePerson = scanner.nextLine().toLowerCase();
                    
                    if (toDeletePerson.equals("yes")) {
                        System.out.println(color.RED + "\nStudent deleted successfully!" + color.RESET);
                        ui.printSinglePerson(personToDelete);
                        people.remove(personToDelete);
                        cls.pressEnterToReturn();
                        cls.clearScreen();
                        return;
                    } else if (toDeletePerson.equals("no")) {
                        System.out.println(color.RED + "\nCancelled delete student!" + color.RESET);
                        cls.pressEnterToReturn();
                        cls.clearScreen();
                        return;
                    } else {
                        errorHandler.inputYesOrNoOnly();
                    }
                }
            } catch (Exception e) {
                errorHandler.invalidId();
                scanner.nextLine();
            }
        }
    }
    }
