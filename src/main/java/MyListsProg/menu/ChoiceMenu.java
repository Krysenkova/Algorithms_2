package MyListsProg.menu;

import MyListsProg.data.Student;
import MyListsProg.find.CourseFinder;
import MyListsProg.find.MatriculationNumberFinder;
import MyListsProg.find.PrenameFinder;
import MyListsProg.find.SurnameFinder;
import MyListsProg.list.Listable;
import MyListsProg.main.Console;

public class ChoiceMenu {
    private static int searchMenu() { //for option 10
        System.out.println("Choose a search parameter: ");
        System.out.println();
        System.out.println("1. Search by surname");
        System.out.println("2. Search by prename");
        System.out.println("3. Search by course number");
        System.out.println("4. Search by matriculation number");
        System.out.println();
        return Console.readIntFromStdin("Please enter a number for an option: ");
    }
    public static void choiceMenu(Listable<Student>list){
        int choice;
        do {
            choice = searchMenu();
            if (choice == 1) {
                String surname = Console.readStringFromStdin("Enter a surname: ");
                SurnameFinder findings = new SurnameFinder();
                Listable<Student> found = findings.find(surname, list);
                found.printAll();
            }
            if (choice == 2) {
                String prename = Console.readStringFromStdin("Enter a prename: ");
                PrenameFinder findings = new PrenameFinder();
                Listable<Student> found = findings.find(prename, list);
                found.printAll();
            }
            if (choice == 3) {
                int course = Console.readIntFromStdin("Enter a course number: ");
                String s = String.valueOf(course);
                CourseFinder findings = new CourseFinder();
                Listable<Student> found = findings.find(s, list);
                found.printAll();
            }
            if (choice == 4) {
                int mNumber = Console.readIntFromStdin("Enter a matriculation number: ");
                String sm = String.valueOf(mNumber);
                MatriculationNumberFinder findings = new MatriculationNumberFinder();
                Listable<Student> found = findings.find(sm, list);
                found.printAll();
            }
            if (choice < 1 || choice > 4) {
                System.out.println("Wrong input. Try again!");
            }
        } while (choice < 1 || choice > 4);
    }
}
