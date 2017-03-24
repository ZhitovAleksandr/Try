package ru.collections.linked_list;

/**
 * Created by student10 on 22.03.2017.
 */
public class Node {
    private Node next;
    private Node prev;
    private Object data;

    Node(Object data){
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Object getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }
}
