package ru.collections.linked_list;

import ru.collections.Deque;
import ru.collections.List;

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
        return prevFirstData;
    }

    @Override
    public Object pullLast() {
        Object prevLastData = last.getData();
        removeLast();
        return prevLastData;
    }

    @Override
    public void add(int index, Object item) {
        if (index > size())
            throw new IndexOutOfBoundsException();
        else if (index == size()) addLast(item);
        else if (index == 0) addFirst(item);
        else {
            Node prevElement = (Node)getElement(index - 1);
            Node nextElement = prevElement.getNext();
            Node newElement = new Node(item);
            nextElement.setPrev(newElement);
            prevElement.setNext(newElement);
            newElement.setNext(nextElement);
            newElement.setPrev(prevElement);
            ++numberOfElements;
        }
    }

    private Object getElement(int index) {
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
        return ((Node)getElement(index)).getData();
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
        Node current = (Node) getElement(index);
        current.setData(obj);
    }

    @Override
    public void remove(int index) {
        if (index == size() - 1)
            removeLast();
        else if (index == 0)
            removeFirst();
        else {
            Node current = (Node) getElement(index);
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
        Node last = ((Node)getElement(to)).getNext();
        for (Node current = (Node) getElement(from); current != last; current = current.getNext()) {
            subList.addLast(current.getData());
        }
        return subList;
    }

    @Override
    public int size() {
        return numberOfElements;
    }
}