package ru.collections.linked_list;

/**
 * Created by student10 on 22.03.2017.
 */
public class LinkedListElement {
    private LinkedListElement next;
    private LinkedListElement prev;
    private Object data;

    LinkedListElement(Object data){
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(LinkedListElement next) {
        this.next = next;
    }

    public void setPrev(LinkedListElement prev) {
        this.prev = prev;
    }

    public Object getData() {
        return this.data;
    }

    public LinkedListElement getNext() {
        return this.next;
    }

    public LinkedListElement getPrev() {
        return this.prev;
    }
}
