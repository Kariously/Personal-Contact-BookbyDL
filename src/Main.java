import Util.DV;

public class Main {
    static void main() {
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

                }
            }
        }
    }
}
