package MyListsProg.menu;

import MyListsProg.data.Student;
import MyListsProg.list.Listable;
import MyListsProg.main.Console;


public class OptionMenu {
    public static void options(Listable<Student> list) {
        int option = 1;
        while (option != 0) {
            GeneralMenu.generalMenu();
            option = Console.readIntFromStdin("Please enter a number for an option: ");
            switch (option) {
                case 1:
                    Student studentToAdd = Console.readStudentFromStdin();
                    list.add(studentToAdd);
                    break;
                case 2:
                    int position;
                    Student studentToAddAtPosition = Console.readStudentFromStdin();
                    do {
                        position = Console.getPosition();
                        if (position < 0)
                            System.out.println("Index cannot be negative. try again!");
                    } while (position < 0);
                    list.add(position, studentToAddAtPosition);
                    break;
                case 3:
                    Student studentAddAtBeginning = Console.readStudentFromStdin();
                    list.addFirst(studentAddAtBeginning);
                    break;
                case 4:
                    Student studentToAddLast = Console.readStudentFromStdin();
                    list.addLast(studentToAddLast);
                    break;
                case 5:
                    int index = Console.getPosition();
                    System.out.println("Position " + index + ": " + list.get(index));
                    break;
                case 6:
                    list.printAll();
                    break;
                case 7:
                    System.out.println("Number of students: " + list.size());
                    break;
                case 8:
                    int toRemove;
                    do {
                        toRemove = Console.getPosition();
                        if (toRemove >= list.size()) {
                            System.out.println("The is no student at position " + toRemove + ". The max.position in the list now is " + (list.size() - 1) + ". Try again!");
                        }
                    }
                    while (toRemove >= list.size());
                    list.remove(toRemove);
                    System.out.println("The student deleted from the list");
                    break;
                case 9:
                    list.clear();
                    System.out.println("The list is cleared");
                    break;
                case 10:
                    ChoiceMenu.choiceMenu(list);
                    break;
                case 11:
                    SortingMenu.sortingMenu(list);
                case 0:
                    break;
                default:
                    System.out.println("Wrong input.Try again!");
            }
        }
    }
}
