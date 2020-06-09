package MyListsProg.compare;

import MyListsProg.data.Student;

public class SurnameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getSurname() == null && o2.getSurname() == null) {
            return 0;
        } else if (o1.getSurname() == null) {
            return 1;
        } else if (o2.getSurname() == null) {
            return -1;
        }
        return o1.getSurname().compareTo(o2.getSurname()); //returns 0 if equal, <0 if o2 greater, >0 if o2 less
    }
}
