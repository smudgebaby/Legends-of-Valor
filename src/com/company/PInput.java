package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for getting user input I built
 */
public class PInput {


    public static int getIntegerBounded(Scanner scan, int lowerBound, int upperBound, String userInputMsg) {
        while (true) {// if PlayerInput is at an already taken position, try again.
            int returnInt = lowerBound - 1;// Initialize row to out of bounds
            while (true) {// collect user input until row is in bounds of play
                //exception handling in case user does not input a int
                boolean continueInput = true;
                do {
                    try { //try to collect an int
                        System.out.println(userInputMsg);
                        returnInt = scan.nextInt();//try to collect an int
                        continueInput = false;//if above succeeds, release from exception handling code
                    } catch (InputMismatchException ex) { //Catch if user does not input an int
                        System.out.println("Integers only"); // explain to user to input an int
                        scan.nextLine();//trash the rest of the line
                    }
                }
                while (continueInput);//keep trying until we receive an int
                if(lowerBound <= returnInt && returnInt <= upperBound){
                    return returnInt;
                }
                else{
                    System.out.println("Integers only in the range " + lowerBound + " to " + upperBound + " please");
                }
            }
        }
    }

    public static int getInteger(Scanner scan, String userInputMsg) {
        while (true) {// if PlayerInput is at an already taken position, try again.
            int returnInt = 0;// Initialize
            // exception handling in case user does not input a int
            boolean continueInput = true;
            do {
                try { //try to collect an int
                    System.out.println(userInputMsg);
                    returnInt = scan.nextInt();//try to collect an int
                    continueInput = false;//if above succeeds, release from exception handling code
                } catch (InputMismatchException ex) { //Catch if user does not input an int
                    System.out.println("Integers only"); // explain to user to input an int
                    scan.nextLine();//trash the rest of the line
                }
            }
            while (continueInput);//keep trying until we receive an int
            return returnInt;
        }
    }
    public static String getString(Scanner scan, String userInputMsg){
        scan.nextLine();//trash the rest of the line
        while (true) {// if PlayerInput is at an already taken position, try again.
            String returnString = null;// Initialize
            // exception handling in case user does not input a int
            boolean continueInput = true;
            do {
                try { //try to collect an int
                    System.out.println(userInputMsg);
                    returnString = scan.nextLine();//try to collect an int
                    continueInput = false;//if above succeeds, release from exception handling code
                } catch (InputMismatchException ex) { //Catch if user does not input a String
                    System.out.println("Please Input a Valid String!"); // explain to user to input an int
                    scan.nextLine();//trash the rest of the line
                }
            }
            while (continueInput);//keep trying until we receive an int
            return returnString;
        }
    }
    public static String getNewString(Scanner scan, String userInputMsg, ArrayList<String> stringArrayList) {
        scan.nextLine();//trash the rest of the line
        while (true) {// if PlayerInput is at an already taken position, try again.
            String returnString = null;// Initialize
            // exception handling in case user does not input a int
            boolean continueInput = true;
            do {
                try { //try to collect an int
                    System.out.println(userInputMsg);
                    returnString = scan.nextLine();//try to collect an int
                    continueInput = false;//if above succeeds, release from exception handling code
                } catch (InputMismatchException ex) { //Catch if user does not input a String
                    System.out.println("Please Input a Valid String!"); // explain to user to input an int
                    scan.nextLine();//trash the rest of the line
                }
            }
            while (continueInput);//keep trying until we receive an int
            if (!(stringArrayList.contains(returnString))) {
                return returnString; //TODO possible just add to array here
            } else {
                System.out.println("Please input a unique name, " + returnString + " has already been taken");
            }
        }
    }

    public static String getOldString(Scanner scan, String userInputMsg, ArrayList<String> stringArrayList) {
        scan.nextLine();//trash the rest of the line
        while (true) {// if PlayerInput is at an already taken position, try again.
            String returnString = null;// Initialize
            // exception handling in case user does not input a int
            boolean continueInput = true;
            do {
                try { //try to collect an int
                    System.out.println(userInputMsg);
                    returnString = scan.nextLine();//try to collect an int
                    continueInput = false;//if above succeeds, release from exception handling code
                } catch (InputMismatchException ex) { //Catch if user does not input a String
                    System.out.println("Please Input a Valid String!"); // explain to user to input an int
                    scan.nextLine();//trash the rest of the line
                }
            }
            while (continueInput);//keep trying until we receive an int
            if ((stringArrayList.contains(returnString))) {
                return returnString;
            } else {
                System.out.println("Please input a existing string, " + returnString + " is not found");
            }
        }
    }
    public static void waitforuser(Scanner scan, String userInputMsg){
        System.out.println(userInputMsg);

        scan.next();
        scan.nextLine();
    }
}