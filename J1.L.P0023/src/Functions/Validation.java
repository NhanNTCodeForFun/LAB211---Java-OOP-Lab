/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Class.Fruit;
import Class.Order;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NhanNT
 */
public class Validation {

    private static final Scanner in = new Scanner(System.in);
    /**
     * Check input number is valid or not
     * @param min
     * @param max
     * @return valid number
     */
    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + "->" + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    /**
     * Check role Staff or Customer
     * @return if staff return true / if customer return false
     */
    public static boolean checkStaffOrCustomer() {
        System.out.println("Are you Staff or Customer?");
        System.out.println("1. Staff.");
        System.out.println("2. Customer.");
        System.out.println("Your choice");
        int choice = checkInputIntLimit(1, 2);
        if (choice == 1) {
            return true;
        } else {
            return false;
        }

    }
    /**
     * Check input string is empty or not
     * @return string
     */
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    /**
     * Check input is Integer or not
     * @return 
     */
    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }
    /**
     * Check input is double or not
     * @return 
     */
    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }
    /**
     * Check input is yes or no
     * @return if yes return true/ if no return false
     */
    public static boolean checkInputYN() {
        System.out.print("Do you want to continue (Y/N)? ");
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    /**
     * Check Id exist or not
     * @param listFruit
     * @param id
     * @return 
     */
    public static boolean checkIdExist(ArrayList<Fruit> listFruit, String id) {
        for (Fruit fruit : listFruit) {
            if (id.equalsIgnoreCase(fruit.getFruitId())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check Item exist or not
     * @param listOrder
     * @param id
     * @return 
     */
    public static boolean checkItemExist(ArrayList<Order> listOrder, String id) {
        for (Order order : listOrder) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Check Phone number valid or not
     * @param phoneNumber
     * @return true/false
     */
    public static boolean checkPhoneNumber(String phoneNumber)
    {
        return phoneNumber.matches("\\d+")&&(phoneNumber.length()==10||phoneNumber.length()==11);
    }
}
