package Util;

import java.io.*;
import java.util.ArrayList;

import static Util.DV.sc;

public class FileHandling {
    public static final String file = "Contact.txt";

    public static void initializeFiles() {
        try {
            new File(file).createNewFile();
        } catch (IOException e) {
            System.out.println("Error in creating file.");
        }
    }

    public static void AddContact() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(String.format("%s | %s", DV.isValidName(), DV.isValidNumber()));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error in writing file.");
        }
        System.out.println("= CONTACT ADDED! =");
    }

    public static void ViewContact() {
        int count = 1;
        File f = new File(file);
        if (!(f.length() == 0)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.printf("[%d] ", count);
                    System.out.println(line);
                    count++;
                }
            } catch (IOException e) {
                System.out.println("Could not read file.");
            }
        }
    }

    public static void SearchContact(String input) {
        String line;
        boolean again = true;
        boolean found = false;
        String number = "";

        File f = new File(file);
        while (again && !(f.length()==0)) {
            System.out.print("Enter phone number (1234/567/8910): ");
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                input = DV.isValidNumberv1();

                while ((line = reader.readLine()) != null) {
                    if (line.contains(input)) {
                        number = line;
                        again = false;
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("\n= CONTACT FOUND! =");
                    System.out.println(number);
                }

            } catch (IOException e) {
                    System.out.println("Could not read file.");
            }
        }
    }

    public static String checkValidNumber(String input) {
        String line = "";
        ArrayList<String> number = new ArrayList<>();
        boolean again = true;

        while (again) {
            System.out.print("Enter phone number (1234/567/8910): ");
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                input = sc.nextLine();
                number.clear();
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    number.add(parts[1].trim());
                }
            } catch (IOException e) {
                System.out.println("Couldn't read file.");
            }

            if (number.contains(input)) {
                System.out.println("Number is already taken/does not exist.");
            } else {
                again = false;
            }
        }

        return input;
    }

    public static void DeleteContact() {
        String line = "";
        ArrayList<String> number = new ArrayList<>();
        boolean again = true;
        boolean found = false;

        while (again) {
            System.out.print("Enter phone number (1234/567/8910): ");
            String input = DV.isValidNumberv1();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                number.clear();
                while ((line = reader.readLine()) != null) {
                    number.add(line);
                }
            } catch (IOException e) {
                System.out.println("Couldn't read file.");
            }

            for (int i = 0; i < number.size(); i++) {
                if (number.get(i).contains(input)) {
                    number.remove(i);
                    System.out.println("= CONTACT DELETED! =");
                    found = true;
                    again = false;
                    break;
                }
            }

            if (found) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (String s : number) {
                        writer.write(s);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error in writing file.");
                }
                System.out.println("\n== UPDATED CONTACT BOOK ==");
                ViewContact();
            } else {
                System.out.println("Number not found.");
            }
        }
    }
}
