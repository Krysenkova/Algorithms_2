/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package MyListsProg.main;

import MyListsProg.compare.Comparator;
import MyListsProg.data.Student;
import MyListsProg.list.Listable;
import MyListsProg.menu.GeneralMenu;
import MyListsProg.sort.Sortable;

import java.util.List;

public class App {
    public static void main(String[] args) {
        GeneralMenu.chooseListMenu();

    }
    public static void sortAndPrint(Listable<Student> list, Sortable<Student> algorithm, Comparator<Student> comparator){
        System.out.println("Sort algorithm: " + algorithm.getClass().getSimpleName() + "Comparator: " + comparator.getClass().getSimpleName());
        algorithm.sort(list, comparator);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        System.out.println();
    }
    private static void printList(List<Student> list, String headLine) {
        System.out.println(headLine);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        System.out.println();
    }
}



