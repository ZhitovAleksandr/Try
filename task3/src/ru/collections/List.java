package ru.collections;

import ru.Collection;

/**
 * Created by student10 on 22.03.2017.
 */
public interface List extends Collection {

    void add(int index, Object item);

    Object get(int index);

    int indexOf(Object obj);

    int lastIndexOf(Object obj);

    void replace(int index, Object obj);

    void remove(int index);

    List subList(int from, int to);

    int size();

}
