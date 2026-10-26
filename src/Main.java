import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n====================================");
            System.out.println("     LINKED LIST MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> singlyMenu(new SinglyLinkedList());
                case 2 -> doublyMenu(new DoublyLinkedList());
                case 3 -> compareLists();
                case 4 -> running = false;
                default -> System.out.println("Invalid choice. Enter a number from 1 to 4.");
            }
        }
        System.out.println("Thank you for using the Linked List Management System.");
        scanner.close();
    }

    private static void singlyMenu(SinglyLinkedList list) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Singly Linked List ---");
            System.out.println("1. Insert at Beginning   2. Insert at End");
            System.out.println("3. Insert at Position    4. Insert After a Node");
            System.out.println("5. Insert Before a Node  6. Delete from Beginning");
            System.out.println("7. Delete from End       8. Delete from Position");
            System.out.println("9. Delete by Value       10. Search");
            System.out.println("11. Update               12. Display");
            System.out.println("13. Count Nodes          14. Find Maximum");
            System.out.println("15. Find Minimum         16. Find Middle");
            System.out.println("17. Reverse              18. Sort");
            System.out.println("19. Remove Duplicates    20. Exit to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> { list.insertAtBeginning(readInt("Enter value: ")); done(); }
                case 2 -> { list.insertAtEnd(readInt("Enter value: ")); done(); }
                case 3 -> {
                    int value = readInt("Enter value: "), pos = readInt("Enter 1-based position: ");
                    result(list.insertAtPosition(value, pos), "Inserted.", "Invalid position.");
                }
                case 4 -> {
                    int target = readInt("Insert after which value? "), value = readInt("Enter new value: ");
                    result(list.insertAfterValue(target, value), "Inserted.", "Target value not found.");
                }
                case 5 -> {
                    int target = readInt("Insert before which value? "), value = readInt("Enter new value: ");
                    result(list.insertBeforeValue(target, value), "Inserted.", "Target value not found.");
                }
                case 6 -> result(list.deleteFromBeginning(), "First node deleted.", "List is empty.");
                case 7 -> result(list.deleteFromEnd(), "Last node deleted.", "List is empty.");
                case 8 -> result(list.deleteAtPosition(readInt("Enter position: ")), "Node deleted.", "Invalid position or empty list.");
                case 9 -> result(list.deleteByValue(readInt("Enter value to delete: ")), "First matching value deleted.", "Value not found.");
                case 10 -> showSearch(list.search(readInt("Enter value to search: ")));
                case 11 -> {
                    int oldValue = readInt("Value to update: "), newValue = readInt("New value: ");
                    result(list.update(oldValue, newValue), "Value updated.", "Value not found.");
                }
                case 12 -> list.display();
                case 13 -> System.out.println("Number of nodes: " + list.count());
                case 14 -> showExtreme("Maximum", list.maximum());
                case 15 -> showExtreme("Minimum", list.minimum());
                case 16 -> showExtreme("Middle element", list.middle());
                case 17 -> { list.reverse(); System.out.println("List reversed."); list.display(); }
                case 18 -> { list.sort(); System.out.println("List sorted in ascending order."); list.display(); }
                case 19 -> { list.removeDuplicates(); System.out.println("Duplicates removed."); list.display(); }
                case 20 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void doublyMenu(DoublyLinkedList list) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Doubly Linked List ---");
            System.out.println("1. Insert at Beginning   2. Insert at End");
            System.out.println("3. Insert at Position    4. Insert After a Node");
            System.out.println("5. Insert Before a Node  6. Delete from Beginning");
            System.out.println("7. Delete from End       8. Delete from Position");
            System.out.println("9. Delete by Value       10. Search");
            System.out.println("11. Update               12. Display Forward");
            System.out.println("13. Display Backward     14. Count Nodes");
            System.out.println("15. Find Maximum         16. Find Minimum");
            System.out.println("17. Find Middle          18. Reverse");
            System.out.println("19. Sort                 20. Remove Duplicates");
            System.out.println("21. Exit to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> { list.insertAtBeginning(readInt("Enter value: ")); done(); }
                case 2 -> { list.insertAtEnd(readInt("Enter value: ")); done(); }
                case 3 -> {
                    int value = readInt("Enter value: "), pos = readInt("Enter 1-based position: ");
                    result(list.insertAtPosition(value, pos), "Inserted.", "Invalid position.");
                }
                case 4 -> {
                    int target = readInt("Insert after which value? "), value = readInt("Enter new value: ");
                    result(list.insertAfterValue(target, value), "Inserted.", "Target value not found.");
                }
                case 5 -> {
                    int target = readInt("Insert before which value? "), value = readInt("Enter new value: ");
                    result(list.insertBeforeValue(target, value), "Inserted.", "Target value not found.");
                }
                case 6 -> result(list.deleteFromBeginning(), "First node deleted.", "List is empty.");
                case 7 -> result(list.deleteFromEnd(), "Last node deleted.", "List is empty.");
                case 8 -> result(list.deleteAtPosition(readInt("Enter position: ")), "Node deleted.", "Invalid position or empty list.");
                case 9 -> result(list.deleteByValue(readInt("Enter value to delete: ")), "First matching value deleted.", "Value not found.");
                case 10 -> showSearch(list.search(readInt("Enter value to search: ")));
                case 11 -> {
                    int oldValue = readInt("Value to update: "), newValue = readInt("New value: ");
                    result(list.update(oldValue, newValue), "Value updated.", "Value not found.");
                }
                case 12 -> list.displayForward();
                case 13 -> list.displayBackward();
                case 14 -> System.out.println("Number of nodes: " + list.count());
                case 15 -> showExtreme("Maximum", list.maximum());
                case 16 -> showExtreme("Minimum", list.minimum());
                case 17 -> showExtreme("Middle element", list.middle());
                case 18 -> { list.reverse(); System.out.println("List reversed."); list.displayForward(); }
                case 19 -> { list.sort(); System.out.println("List sorted in ascending order."); list.displayForward(); }
                case 20 -> { list.removeDuplicates(); System.out.println("Duplicates removed."); list.displayForward(); }
                case 21 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static void result(boolean success, String successMessage, String failureMessage) {
        System.out.println(success ? successMessage : failureMessage);
    }

    private static void showSearch(int position) {
        if (position == -1) System.out.println("Value not found.");
        else System.out.println("Value found at position " + position + ".");
    }

    private static void showExtreme(String label, Integer value) {
        if (value == null) System.out.println("List is empty; " + label.toLowerCase() + " is unavailable.");
        else System.out.println(label + ": " + value);
    }

    private static void done() { System.out.println("Operation completed."); }

    private static void compareLists() {
        System.out.println("\n========== SINGLY VS DOUBLY LINKED LIST ==========");
        System.out.printf("%-28s %-22s %-22s%n", "Feature", "Singly", "Doubly");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-28s %-22s %-22s%n", "References per node", "next", "prev and next");
        System.out.printf("%-28s %-22s %-22s%n", "Traversal", "Forward only", "Forward and backward");
        System.out.printf("%-28s %-22s %-22s%n", "Memory use", "Lower", "Higher");
        System.out.printf("%-28s %-22s %-22s%n", "Insert at beginning", "O(1)", "O(1)");
        System.out.printf("%-28s %-22s %-22s%n", "Search", "O(n)", "O(n)");
        System.out.printf("%-28s %-22s %-22s%n", "Delete from end", "O(n)", "O(1) with tail");
        System.out.println("Singly lists use less memory; doubly lists support backward traversal.");
    }
}
