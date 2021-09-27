package org.example;
import java.util.Scanner;
import java.util.regex.Pattern;
/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tiffany Thani
 */

public class Exercise27 {

        static String info = "";

        public static void main(String[] args) {
            // Creating the scanner object
            Scanner input = new Scanner(System.in);
            // Reading in the user's input
            System.out.print("Enter the first name: ");
            String fName = input.nextLine();
            System.out.print("Enter the last name: ");
            String lName = input.nextLine();
            System.out.print("Enter the ZIP code: ");
            String zip = input.nextLine();
            System.out.print("Enter the employee ID: ");
            String employeeID = input.nextLine();


            validateInput(fName, lName, zip, employeeID);

        }

        // Takes in input info and invokes the specific validation functions
        public static void validateInput(String fName, String lName, String zip, String employeeID) {
            boolean first = validateFirstName(fName);
            boolean last = validateLastName(lName);
            boolean zipFlag = validateZipCode(zip);
            boolean idFlag = validateEmployeeID(employeeID);

            if (first && last && zipFlag && idFlag) {
                info = "There were no errors found.";
            }
            System.out.println(info);
        }

        // This method validate firstName
        public static boolean validateFirstName(String fName) {
            boolean status = true;

            if (fName.length() < 2) {
                info = info + "The first name must be at least 2 characters long.\n";
                status = false;
            }
            if (fName.length() == 0) {
                info = info + "The first name must be filled in.\n";
                status = false;
            }
            return status;
        }

        // This method validate lastName
        public static boolean validateLastName(String lName) {
            boolean status = true;

            if (lName.length() < 2) {
                info = info + "The last name must be at least 2 characters long.\n";
                status = false;
            }
            if (lName.length() == 0) {
                System.out.println("The last name must be filled in.");
                status = false;
            }
            return status;
        }

        // This method validates zip
        public static boolean validateZipCode(String zip) {
            boolean status = true;
            try {
                int number= Integer.parseInt(zip);
                if (zip.length() != 5) {
                    info = info + "The zipcode must be a 5 digit number.\n";
                    status = false;
                }
            } catch (Exception e) {
                info = info + "The zipcode must be a 5 digit number.\n";
                status = false;
            }
            return status;
        }

        // EmployeeID Validation
        public static boolean validateEmployeeID(String employeeID) {
            String pattern = "[a-zA-Z]{2}[-]{1}[0-9]{4}";
            if (!Pattern.matches(pattern, employeeID)) {
                info = info + "The employee ID must be in the format of AA-1234.\n";
                return false;
            }
            return true;
        }

    }

