package MyListsProg.find;

import MyListsProg.data.Student;
import MyListsProg.list.Listable;
import MyListsProg.list.SinglyLinkedList;

import java.util.Iterator;

public class CourseFinder implements Finder<Student> {
    @Override
    public Listable<Student> find(String o, Listable<Student> list) {
        Listable<Student> findings = new SinglyLinkedList<>();

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getCourse() == Integer.parseInt(o)) {
                findings.addLast(student);
            }
        }
        return findings;
    }
}
