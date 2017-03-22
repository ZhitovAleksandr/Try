package ru.collections.linked_list;

import ru.collections.Deque;
import ru.collections.List;

/**
 * Created by student10 on 22.03.2017.
 */
public class LinkedList extends Throwable implements List, Deque {
    private LinkedListElement first;
    private LinkedListElement last;
    private int numberOfElements;

    public LinkedList() {
        numberOfElements = 0;
    }

    @Override
    public void addFirst(Object item) {
        LinkedListElement newElement = new LinkedListElement(item);
        first.setPrev(newElement);
        newElement.setNext(first);
        first = newElement;
        ++numberOfElements;
    }

    @Override
    public void addLast(Object item) {
        LinkedListElement newElement = new LinkedListElement(item);
        last.setNext(newElement);
        newElement.setPrev(last);
        last = newElement;
        ++numberOfElements;
    }

    @Override
    public void removeFirst() {
        first = first.getNext();
        --numberOfElements;
    }

    @Override
    public void removeLast() {
        last = last.getPrev();
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
        Object prevFirstData = first.getData();
        removeFirst();
        --numberOfElements;
        return prevFirstData;
    }

    @Override
    public Object pullLast() {
        Object prevLastData = last.getData();
        removeLast();
        --numberOfElements;
        return prevLastData;
    }

    @Override
    public void add(int index, Object item) {
        if (index > size())
            throw new IndexOutOfBoundsException();
        LinkedListElement prevElement = first;
        for (int i = 0; i < index; ++i)
            prevElement = first.getNext();
        LinkedListElement nextElement = prevElement.getNext();
        LinkedListElement newElement = new LinkedListElement(item);
        nextElement.setNext(newElement);
        prevElement.setPrev(newElement);
        ++numberOfElements;
    }

    private Object getElement(int index) {
        if (index > size())
            throw new IndexOutOfBoundsException();
        LinkedListElement current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public Object get(int index) {
        if (index > size())
            throw new IndexOutOfBoundsException();
        LinkedListElement current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public int indexOf(Object obj) {
        int index = 0;
        for (LinkedListElement current = first; current != null; current = current.getNext()){
            if (current.equals(obj))
                return index;
            ++index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        int index = size() - 1;
        for (LinkedListElement current = last; current != null; current = current.getPrev()){
            if (current.equals(obj))
                return index;
            --index;
        }
        return -1;
    }

    @Override
    public void replace(int index, Object obj) {
        LinkedListElement current = (LinkedListElement) getElement(index);
        current.setData(obj);
    }

    @Override
    public void remove(int index) {
        LinkedListElement current = (LinkedListElement) getElement(index);
        LinkedListElement next = current.getNext();
        LinkedListElement prev = current.getPrev();
        next.setPrev(prev);
        prev.setNext(next);
        --numberOfElements;
     }

    @Override
    public List subList(int from, int to) {
        LinkedList subList = new LinkedList();
        LinkedListElement last = (LinkedListElement)getElement(to);
        for (LinkedListElement current = (LinkedListElement) getElement(from); current != last; current = current.getNext()) {
            subList.addLast(current.getData());
        }
        return subList;
    }

    @Override
    public int size() {
        return numberOfElements;
    }
}
