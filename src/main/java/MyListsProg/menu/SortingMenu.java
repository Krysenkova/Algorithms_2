package MyListsProg.menu;

import MyListsProg.compare.CourseComparator;
import MyListsProg.compare.MatriculationNumberComparator;
import MyListsProg.compare.PrenameComparator;
import MyListsProg.compare.SurnameComparator;
import MyListsProg.data.Student;
import MyListsProg.list.Listable;
import MyListsProg.main.App;
import MyListsProg.main.Console;
import MyListsProg.sort.BubbleSort;
import MyListsProg.sort.SelectionSort;
import MyListsProg.sort.Sortable;

public class SortingMenu {
    private static int sortMenu() {//for option 11
        System.out.println("Choose the sorting type:");
        System.out.println();
        System.out.println("1. Selection Sort by surname");
        System.out.println("2. Selection Sort by prename");
        System.out.println("3. Selection Sort by course");
        System.out.println("4. Selection Sort by matriculation number");
        System.out.println("5. Bubble Sort by surname");
        System.out.println("6. Bubble Sort by prename");
        System.out.println("7. Bubble Sort by course");
        System.out.println("8. Bubble Sort by matriculation number");
        return Console.readIntFromStdin("Please enter a number for an option: ");
    }
    public static void sortingMenu(Listable<Student> list){
        int sort;
        do {
            sort = sortMenu();
            if (sort == 1) {
                App.sortAndPrint(list, new SelectionSort<>(), new SurnameComparator());
            }
            if (sort == 2) {
                App.sortAndPrint(list, new SelectionSort<>(), new PrenameComparator());
            }
            if (sort == 3) {
                App.sortAndPrint(list, new SelectionSort<>(), new CourseComparator());
            }
            if (sort == 4) {
                App.sortAndPrint(list, new SelectionSort<>(), new MatriculationNumberComparator());
            }
            if (sort == 5) {
                App.sortAndPrint(list, new BubbleSort<>(), new SurnameComparator());
            }
            if (sort == 6) {
                App.sortAndPrint(list, new BubbleSort<>(), new PrenameComparator());
            }
            if (sort == 7) {
                App.sortAndPrint(list, new BubbleSort<>(), new CourseComparator());
            }
            if (sort == 8) {
                App.sortAndPrint(list, new BubbleSort<>(), new MatriculationNumberComparator());
            }
            if (sort <= 0 || sort > 8) {
                System.out.println("Wrong input. Try again!");
            }
        } while (sort <= 0 || sort > 8);
    }
}