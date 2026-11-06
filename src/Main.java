import Util.DV;
import Util.FileHandling;

public class Main {
    static void main() {
        FileHandling.initializeFiles();
        int open = 0;
        boolean again = true;

        while (again) {
            System.out.println("=== PERSONAL CONTACT BOOK SYSTEM ===");
            System.out.println("""
                    [1] Add Contact
                    [2] View All Contacts
                    [3] Search Contacts
                    [4] Delete Contacts
                    [5] Exit\n""");

            int choice = DV.isValidChoice();

            switch (choice) {
                case 1: {
                    open = 1;
                    System.out.println("\n=== ADD CONTACT ===");
                    FileHandling.AddContact();
                    System.out.println("===================\n");
                    break;
                }

                case 2: {
                    System.out.println("\n=== CONTACTS ===");
                    FileHandling.ViewContact();
                    System.out.println("================\n");
                    break;
                }

                case 3: {
                    System.out.println("\n=== SEARCH CONTACT ===");
                    String input = "";
                    FileHandling.SearchContact(input);
                    System.out.println("======================\n");
                    break;
                }

                case 4: {
                    System.out.println("\n=== DELETE CONTACT ===");
                    FileHandling.DeleteContact();
                    System.out.println("======================\n");
                    break;
                }

                case 5: {
                    again = false;
                    break;
                }
            }
        }
    }
}
