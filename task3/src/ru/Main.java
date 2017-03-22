package ru;

import ru.collections.Deque;
import ru.collections.array_list.ArrayList;
import ru.collections.List;
import ru.collections.linked_list.LinkedList;
import ru.collections.linked_list.LinkedListElement;

/**
 * Created by student10 on 22.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        for (Integer i = 0; i < 10; i++)
            list.addLast(i);
        for (int i = 0; i < 9; i++)
            System.out.printf("%d ", (Integer)list.pullFirst());
    }
}
