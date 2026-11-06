package Util;

import java.util.Scanner;

public class DV {
    public static Scanner sc = new Scanner(System.in);

    public static int isValidChoice() {
        String input = "";
        int res = 0;
        boolean again = true;

        while (again) {
            System.out.print("Enter choice: ");

            try {
                input = sc.nextLine().trim();
                if (input.matches("^0|[1-5]$")) {
                    res = Integer.parseInt(input);
                    again = false;
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input.");
            }
        }
        return res;
    }

    public static String isValidNumberv1() {
        String input = "";
        boolean again = true;

        while (again) {
            try {
                input = sc.nextLine().trim();
                if (input.matches("\\d{4}/\\d{3}/\\d{4}")) {
                    again = false;
                } else {
                    System.out.println("Please refer to the format.");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input.");
            }
        }

        return input;
    }

    public static String isValidNumber() {
        String input = "";
        boolean again = true;

        while (again) {
            try {
                input = FileHandling.checkValidNumber(input);
                if (input.matches("\\d{4}/\\d{3}/\\d{4}")) {
                    again = false;
                } else {
                    System.out.println("Please refer to the format.");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input.");
            }
        }

        return input;
    }

    public static String isValidName() {
        String input = "";
        boolean again = true;

        while (again) {
            System.out.print("Enter name for the phone number: ");

            try {
                input = sc.nextLine().trim();

                if (!input.isEmpty() && input.matches("[A-Za-z .\\-']+")) {
                    again = false;
                } else {
                    System.out.println("Please enter a name.");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input.");
            }
        }

        return input;
    }
}
