# Student Management System

## Overview
This is a Java-based Student Management System that allows users to perform CRUD (Create, Read, Update, Delete) operations on student records. The system features a console-based interface with color-coded outputs and input validation.

## Features

### Core Functionality
- **Create Student Records**: Add new students with name, course, section, and age
- **View All Students**: Display all student records in a formatted table
- **Update Student Information**: Modify existing student details
- **Delete Students**: Remove students from the system

### User Interface
- Color-coded console output for better readability
- Formatted table displays for student information
- Clear screen functionality between operations
- Confirmation prompts for critical operations

### Input Validation
- Age validation (must be between 4-79)
- ID validation (must be numeric)
- Menu selection validation
- Yes/No confirmation validation
- Automatic uppercase conversion for name, course, and section fields

## System Architecture

### Main Components
1. **Main Menu System**
   - Welcome screen with loading animation
   - Main menu navigation
   - About Us information

2. **Student Management System**
   - CRUD operations for student records
   - Table formatting for student display
   - Input validation for all operations

3. **Utility Classes**
   - Console clearing functionality
   - Error message handling
   - UI formatting tools

### Class Structure
- `main.java`: Program entry point
- `mainMenu.java`: Handles main menu display and navigation
- `studentSystem.java`: Manages student system operations
- `crud.java`: Contains all CRUD operations implementation
- `Person.java`: Data model for student records
- `ui.java`: Handles table formatting and display
- `errorValidation.java`: Contains all error messages
- `menu.java`: Student system menu display
- `menuHandler.java`: Routes menu selections to appropriate CRUD operations
- `cls.java`: Console utility functions

## Usage Instructions

1. **Main Menu Options**:
   - [1] Home: Access the student management system
   - [2] About Us: View program information
   - [3] Exit: Quit the program

2. **Student System Options**:
   - [1] Create Student: Add a new student record
   - [2] View All Students: Display all existing records
   - [3] Update Student: Modify an existing record
   - [4] Delete Student: Remove a record
   - [5] Back to Main Menu: Return to main menu

3. **Creating a Student**:
   - Enter full name, course, section, and age
   - Age must be between 4-79
   - System automatically converts text fields to uppercase

4. **Updating/Deleting**:
   - Requires student ID
   - Shows current details before modification
   - Requires confirmation before executing changes

## Technical Details

### Requirements
- Java Runtime Environment (JRE) 8 or later
- Windows, Linux, or macOS system

### Implementation Notes
- Uses Java's built-in `ArrayList` for data storage
- Implements encapsulation through the `Person` class
- Includes comprehensive input validation
- Features cross-platform console clearing functionality
- Uses ANSI color codes for enhanced console output

## Development Notes

This system was developed as an educational project to demonstrate:
- Object-oriented programming principles
- Console-based application development
- CRUD operations implementation
- Input validation techniques
- Clean code organization and separation of concerns

The code includes Filipino language comments (like "Gumawa ng bagong person") showing the developer's origin while maintaining English method names and UI text for international accessibility.

## Future Enhancements
1. Add search functionality
2. Implement data persistence (file storage)
3. Add sorting capabilities
4. Include more student fields (email, contact number)
5. Implement user authentication
6. Add reporting features

## How to Contribute
1. Fork the repository
2. Create a new branch for your feature
3. Commit your changes
4. Push to the branch
5. Create a pull request
