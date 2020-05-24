package MyListsProg.sort;

import MyListsProg.compare.Comparator;
import MyListsProg.list.Listable;

public interface Sortable<T> {
    void sort(Listable<T> list, Comparator<T> comparator);
}

