package ru.collections.linked_list;

import ru.collections.Deque;
import ru.collections.List;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by student10 on 22.03.2017.
 */
public class LinkedList extends Throwable implements List, Deque {
    private Node first;
    private Node last;
    private int numberOfElements;

    public LinkedList() {
        numberOfElements = 0;
    }

    private void initList(Node item) {
        first = item;
        last = item;
    }

    @Override
    public void addFirst(Object item) {
        Node newElement = new Node(item);
        if (first != null) {
            first.setPrev(newElement);
            newElement.setNext(first);
            first = newElement;
        } else initList(newElement);
        ++numberOfElements;
    }

    @Override
    public void addLast(Object item) {
        Node newElement = new Node(item);
        if (last != null) {
            last.setNext(newElement);
            newElement.setPrev(last);
            last = newElement;
        } else initList(newElement);
        ++numberOfElements;
    }

    @Override
    public void removeFirst() {
        first = first.getNext();
        first.setPrev(null);
        --numberOfElements;
    }

    @Override
    public void removeLast() {
        last = last.getPrev();
        last.setNext(null);
        --numberOfElements;
    }

    @Override
    public Object getFirst() {
        return first.getData();
    }

    @Override
    public Object getLast() {
        return last.getData();
    }

    @Override
    public Object pullFirst() {
        Object firstData = first.getData();
        removeFirst();
        return firstData;
    }

    @Override
    public Object pullLast() {
        Object lastData = last.getData();
        removeLast();
        return lastData;
    }

    @Override
    public void add(int index, Object item) {
        if (index > size())
            throw new IndexOutOfBoundsException();
        else if (index == size()) addLast(item);
        else if (index == 0) addFirst(item);
        else {
            Node prevElement = getNode(index - 1);
            Node nextElement = prevElement.getNext();
            Node newElement = new Node(item);
            nextElement.setPrev(newElement);
            prevElement.setNext(newElement);
            newElement.setNext(nextElement);
            newElement.setPrev(prevElement);
            ++numberOfElements;
        }
    }

    private Node getNode(int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public Object get(int index) {
        return getNode(index).getData();
    }

    @Override
    public int indexOf(Object obj) {
        int index = 0;
        for (Node current = first; current != null; current = current.getNext()){
            if (current.getData().equals(obj))
                return index;
            ++index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        int index = size() - 1;
        for (Node current = last; current != null; current = current.getPrev()){
            if (current.getData().equals(obj))
                return index;
            --index;
        }
        return -1;
    }

    @Override
    public void replace(int index, Object obj) {
        getNode(index).setData(obj);
    }

    @Override
    public void remove(int index) {
        if (index == size() - 1)
            removeLast();
        else if (index == 0)
            removeFirst();
        else {
            Node current = getNode(index);
            Node next = current.getNext();
            Node prev = current.getPrev();
            next.setPrev(prev);
            prev.setNext(next);
            --numberOfElements;
        }
     }

    @Override
    public List subList(int from, int to) {
        LinkedList subList = new LinkedList();
        Node last = getNode(to).getNext();
        for (Node current = getNode(from); current != last; current = current.getNext()) {
            subList.addLast(current.getData());
        }
        return subList;
    }

    @Override
    public void add(Object item) {
        addLast(item);
    }

    @Override
    public void clear() {
        initList(null);
    }

    @Override
    public boolean isEmpty() {
        return size() > 0;
    }

    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == 0) return false;
        remove(index);
        return true;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    public class LinkedListIterator implements ListIterator
    {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Object previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(Object o) {

        }

        @Override
        public void add(Object o) {

        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}