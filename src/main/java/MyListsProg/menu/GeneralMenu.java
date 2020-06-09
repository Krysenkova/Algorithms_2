package MyListsProg.menu;

import MyListsProg.data.Student;
import MyListsProg.list.DoublyLinkedList;
import MyListsProg.list.SinglyLinkedList;
import MyListsProg.main.Console;

public class GeneralMenu {
    public static void chooseListMenu() {
        header();
        int option = 0;
        while (option < 1 || option > 2) {
            System.out.println("Select list type before starting the main menu:");
            System.out.println();
            System.out.printf("1. SinglyLinkedList %n2. DoublyLinkedList %n");
            System.out.println();
            option = Console.readIntFromStdin("Please enter a number for an option: ");
            if (option < 1 || option > 2) {
                System.out.println("Incorrect number. Try again!");
                System.out.println();
            }
        }
        if (option == 1) {
            singlyMenu();
        } else
            doublyMenu();
    }

    public static void generalMenu() {
        System.out.println();
        System.out.println(" 1. Add a student to the end of the list.");
        System.out.println(" 2. Insert a student at the specified position in the list");
        System.out.println(" 3. Insert a student at the beginning of the list.");
        System.out.println(" 4. Append a student to the end of the list.");
        System.out.println(" 5. Return the student from the specified position in the list.");
        System.out.println(" 6. Print all students to console from the list.");
        System.out.println(" 7. Return the number of students in the list.");
        System.out.println(" 8. Remove the student at the specified position from the list.");
        System.out.println(" 9. Remove all students from the list.");
        System.out.println("10. Search for student(s) by different characteristics.");
        System.out.println("11. Sort the list by different properties.");
        System.out.println(" 0. Exit");
        System.out.println();
    }

    public static void singlyMenu() {
        header();
        System.out.println("You selected SinglyLinkedList:");
        SinglyLinkedList<Student> singlyLinkedList = new SinglyLinkedList<>();
        OptionMenu.options(singlyLinkedList);
    }

    public static void doublyMenu() {
        header();
        System.out.println("You selected DoublyLinkedList:");
        DoublyLinkedList<Student> doublyLinkedList = new DoublyLinkedList<>();
        OptionMenu.options(doublyLinkedList);
    }

    public static void header() {
        System.out.println("Console-Application: Exercise-2             <Ekaterina><Krysenkova><573734>");
        System.out.println();
    }
}
