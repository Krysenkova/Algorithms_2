package MyListsProg;

import MyListsProg.compare.CourseComparator;
import MyListsProg.compare.MatriculationNumberComparator;
import MyListsProg.compare.PrenameComparator;
import MyListsProg.compare.SurnameComparator;
import MyListsProg.data.Student;
import MyListsProg.list.SinglyLinkedList;
import MyListsProg.sort.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void bubbleSortBySurnameTest() {
        var s3 = new Student("Watson", "John", 1, 3568);
        var s1 = new Student("Holmes", "Sherlock", 5, 7629);
        var s2 = new Student("Moriarty", "James", 3, 4321);
        SinglyLinkedList<Student> list = new SinglyLinkedList<>();
        list.add(s3);
        list.add(s1);
        list.add(s2);
        BubbleSort<Student> algo = new BubbleSort<>();
        algo.sort(list, new SurnameComparator());
        SinglyLinkedList<Student> actualList = new SinglyLinkedList<>();
        actualList.add(s1);
        actualList.add(s2);
        actualList.add(s3);
        Student[] array = new Student[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        Student[] testArray = new Student[actualList.size()];
        for (int i = 0; i < actualList.size(); i++) {
            testArray[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(array, testArray);
    }

    @Test
    public void bubbleSortByPrenameTest() {
        var s1 = new Student("Watson", "John", 1, 3568);
        var s2 = new Student("Holmes", "Sherlock", 5, 7629);
        var s3 = new Student("Moriarty", "James", 3, 4321);
        SinglyLinkedList<Student> list = new SinglyLinkedList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        BubbleSort<Student> algo = new BubbleSort<>();
        algo.sort(list, new PrenameComparator());
        SinglyLinkedList<Student> actualList = new SinglyLinkedList<>();
        actualList.add(s3);
        actualList.add(s1);
        actualList.add(s2);
        Student[] array = new Student[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        Student[] testArray = new Student[actualList.size()];
        for (int i = 0; i < actualList.size(); i++) {
            testArray[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(array, testArray);
    }

    @Test
    public void bubbleSortByCourseTest() {
        var s1 = new Student("Watson", "John", 1, 3568);
        var s2 = new Student("Holmes", "Sherlock", 5, 7629);
        var s3 = new Student("Moriarty", "James", 3, 4321);
        SinglyLinkedList<Student> list = new SinglyLinkedList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        BubbleSort<Student> algo = new BubbleSort<>();
        algo.sort(list, new CourseComparator());
        SinglyLinkedList<Student> actualList = new SinglyLinkedList<>();
        actualList.add(s1);
        actualList.add(s3);
        actualList.add(s2);
        Student[] array = new Student[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        Student[] testArray = new Student[actualList.size()];
        for (int i = 0; i < actualList.size(); i++) {
            testArray[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(array, testArray);
    }

    @Test
    public void bubbleSortByMatNumTest() {
        var s1 = new Student("Watson", "John", 1, 3568);
        var s2 = new Student("Holmes", "Sherlock", 5, 7629);
        var s3 = new Student("Moriarty", "James", 3, 4321);
        SinglyLinkedList<Student> list = new SinglyLinkedList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        BubbleSort<Student> algo = new BubbleSort<>();
        algo.sort(list, new MatriculationNumberComparator());
        SinglyLinkedList<Student> actualList = new SinglyLinkedList<>();
        actualList.add(s1);
        actualList.add(s3);
        actualList.add(s2);
        Student[] array = new Student[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        Student[] testArray = new Student[actualList.size()];
        for (int i = 0; i < actualList.size(); i++) {
            testArray[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(array, testArray);
    }
}
