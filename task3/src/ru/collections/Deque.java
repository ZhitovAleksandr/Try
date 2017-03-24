package ru.collections;

import ru.Collection;

/**
 * Created by student10 on 22.03.2017.
 */
public interface Deque extends Collection {

    void addFirst(Object item);

    void addLast(Object item);

    void removeFirst();

    void removeLast();

    Object getFirst();

    Object getLast();

    Object pullFirst();

    Object pullLast();

}
