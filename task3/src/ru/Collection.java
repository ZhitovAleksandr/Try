package ru;

/**
 * Created by student10 on 24.03.2017.
 */
public interface Collection extends Iterable {

    void add(Object item);

    void clear();

    boolean isEmpty();

    boolean remove(Object obj);

    int size();

}
