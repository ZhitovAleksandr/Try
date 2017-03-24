package ru;

import ru.collections.array_list.ArrayList;
import ru.collections.linked_list.LinkedList;

/**
 * Created by student10 on 22.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ArrayList a = new ArrayList();
        for (Object object: a) {
            System.out.println((Integer) object);
        }
    }
}
