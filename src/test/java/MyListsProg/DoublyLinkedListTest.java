package MyListsProg;

import MyListsProg.data.Student;
import MyListsProg.list.DoublyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Student> provideDoublyList() {
        DoublyLinkedList<Student> list = new DoublyLinkedList<>();
        Student s1 = new Student("Watson", "John", 1, 3568);
        Student s2 = new Student("Holmes", "Sherlock", 5, 7629);
        Student s3 = new Student("Moriarty", "James", 3, 4321);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        return list;
    }

    @Test
    public void doubly_addTest() {
        DoublyLinkedList<Student> testList = provideDoublyList();
        Student s4 = new Student("Hooper", "Molly", 2, 3256);
        testList.add(s4);
        Assert.assertEquals(s4, testList.get(3));
    }

    @Test
    public void doubly_addAtIndexTest() {
        DoublyLinkedList<Student> testList = provideDoublyList();
        Student s4 = new Student("Hooper", "Molly", 2, 3256);
        testList.add(2, s4);
        Assert.assertEquals(s4, testList.get(2));
    }
    @Test
    public void doubly_addFirstTest(){
        DoublyLinkedList<Student> testList = provideDoublyList();
        Student s4 = new Student("Hooper", "Molly", 2, 3256);
        testList.addFirst(s4);
        Assert.assertEquals(s4, testList.get(0));
    }

    @Test
    public void doubly_getTest(){
        DoublyLinkedList<Student> list = new DoublyLinkedList<>();
        Student s1 = new Student("Watson", "John", 1, 3568);
        Student s2 = new Student("Holmes", "Sherlock", 5, 7629);
        Student s3 = new Student("Moriarty", "James", 3, 4321);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Assert.assertEquals(s2, list.get(1));
    }

    @Test
    public void doubly_removeTest(){
        DoublyLinkedList<Student> testList = provideDoublyList();
        testList.remove(2);
        Assert.assertNull(testList.get(2));
    }

    @Test
    public void doubly_clearTest(){
        DoublyLinkedList<Student> testList = provideDoublyList();
        testList.clear();
        Assert.assertNull(testList.get(0));
    }

    @Test
    public void doubly_sizeTest(){
        DoublyLinkedList<Student> testList = provideDoublyList();
        Assert.assertEquals(3, testList.size());
    }

    @Test
    public void doubly_printAllTest(){
        //TODO think how to test it
    }

    @Test
    public void doubly_isEmptyTrueTest(){
        DoublyLinkedList<Student> testList = provideDoublyList();
        testList.clear();
        Assert.assertTrue(testList.isEmpty());
    }
    @Test
    public void isEmptyFalseTest(){
        DoublyLinkedList<Student> testList = provideDoublyList();
        Assert.assertFalse(testList.isEmpty());
        //TODO Solve problem with size
    }
}
