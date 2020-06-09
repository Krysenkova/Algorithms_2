package MyListsProg.sort;

import MyListsProg.compare.Comparator;
import MyListsProg.list.Listable;

public class SelectionSort<T> extends Swapper<T> implements Sortable<T> {
    @Override
    public void sort(Listable<T> list, Comparator<T> comparator) {
        int minimum;
        for (int i = 0; i < list.size(); i++){
            minimum = i;
            for (int e = i+1; e < list.size(); e++){
                if (comparator.compare(list.get(e), list.get(minimum)) < 0) {
                    minimum = e;
                }
            }
            swap(list, i, minimum);
        }
    }
}