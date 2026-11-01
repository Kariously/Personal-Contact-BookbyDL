package Util;

import java.util.Scanner;

public class DV {
    private static Scanner sc = new Scanner(System.in);

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
}
