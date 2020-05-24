package MyListsProg.find;

import MyListsProg.list.Listable;

public interface Finder<T> {
    Listable<T> find(String o, Listable<T> list);
}
