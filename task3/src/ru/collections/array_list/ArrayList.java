package ru.collections.array_list;

import ru.collections.List;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

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
            if (size() + 1 == array.length) resize();
            for (int i = size() + 1; i > index; --i) {
                array[i] = array[i - 1];
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
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        array[index] = obj;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size())
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
    public void add(Object item) {
        add(size(), item);
    }

    @Override
    public void clear() {
        array = new Object[START_CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        return size() > 0;
    }

    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    private class ArrayListIterator extends Throwable implements ListIterator{
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public Object next() {
            if (hasNext()) return get(cursor++);
            else throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public Object previous() {
            if (hasPrevious()) return get(--cursor);
            else throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            ArrayList.this.remove(cursor);
        }

        @Override
        public void set(Object o) {
            replace(cursor, o);
        }

        @Override
        public void add(Object o) {
            ArrayList.this.add(cursor++, o);
        }

    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }
}
