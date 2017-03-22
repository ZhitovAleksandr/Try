package ru.collections.array_list;

import ru.collections.List;

/**
 * Created by student10 on 22.03.2017.
 */
public class ArrayList extends Throwable implements List {
    private Object[] array;
    final private int START_CAPACITY = 10;
    private int numberOfElements = 0;

    public ArrayList() {
        array = new Object[START_CAPACITY];
    }

    public ArrayList(int startCapacity) {
        array = new Object[startCapacity];
    }

    public Object[] getArray() {
        return array;
    }

    private void resize() {
        Object[] resizedArray = new Object[(size() * 3) / 2 + 1];
        for (int i = 0; i < size(); i++) {
            resizedArray[i] = array[i];
        }
        array = resizedArray;
    }

    @Override
    public void add(int index, Object item) {
        if (index > size())
            throw new IndexOutOfBoundsException();
        else {
            if (size() == array.length) resize();
            for (int i = index; i < size() - 1; i++) {
                array[i + 1] = array[i];
            }
            array[index] = item;
            numberOfElements++;
        }
    }

    @Override
    public Object get(int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < size(); i++) {
            if (obj.equals(array[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        for (int i = size() - 1; i >= 0; i--) {
            if (obj.equals(array[i]))
                return i;
        }
        return -1;
    }

    @Override
    public void replace(int index, Object obj) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        array[index] = obj;
    }

    @Override
    public void remove(int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        for (int i = index; i < size() - 1; ++i) {
            array[i] = array[i + 1];
        }
        --numberOfElements;
    }

    @Override
    public List subList(int from, int to) {
        if (to >= size())
            throw new IndexOutOfBoundsException();
        List subList = new ArrayList();
        for (int i = from; i <= to; ++i) {
            subList.add(i - from, get(i));
        }
        return subList;
    }

    @Override
    public int size() {
        return numberOfElements;
    }
}
