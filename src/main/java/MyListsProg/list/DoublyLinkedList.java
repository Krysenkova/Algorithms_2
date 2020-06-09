package MyListsProg.list;

import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Listable<T>, Iterable<T> {

    Node head;
    Node tail;
    int size;

    private class Node {
        T data;
        Node next;
        Node prev;
    }
    private class DoublyListIterator implements Iterator<T> {
        Node nextNode;

        DoublyListIterator() {
            nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException();
            T res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }
    }

    @Override
    public Iterator<T> iterator()  { return new DoublyListIterator();
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node getNode(int index) {
        Node node = head;
        int counter = 0;
        while (node != null) {
            if (counter == index) {
                return node;
            }
            counter++;
            node = node.next;
        }
        return null;
    }

    @Override
    public void add(T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.prev = tail;
        if (tail != null)
            tail.next = node;
        tail = node;
        if (head == null)
            head = node;
        size++;
    }

    @Override
    public void add(int index, T data) {
        Node node = new Node();
        node.data = data;
        if (index == 0)
            addFirst(data);
        else if (index < 0){
            System.out.println("Wrong Index. The student wasn't added");
        }
        else if (index > size) {
            System.out.println("Index is bigger than the size of the list. The student will be attached to the end of the list at index " + size);
            addLast(data);
        }
        Node node1 = getNode(index - 1);
        if (node1 == null) return;
        if (node1 != tail) {
            Node node2 = node1.next;
            node.prev = node1;
            node.next = node2;
            node1.next = node;
            node2.prev = node;
            size++;
        } else {
            addLast(data);
        }
    }

    @Override
    public void addFirst(T data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;
        head = node;
        if (tail == null)
            tail = node;
        size++;
    }

    @Override
    public void addLast(T data) {
        add(data);
    }

    @Override
    public void set(int index, T data) {
        Node current = head;
        if (!isEmpty()) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.data = data;
        } else System.out.println("List is empty!");
        if (index < 0 || index > this.size()) {
            System.out.println("Index is wrong!");
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        if (index == 0) {
            return head.data;
        }
        if (index == size - 1) {
            return tail.data;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Wrong index!");
        }
        Node remove = head;
        for (int i = 0; i < index; i++) {
            remove = remove.next;
        }
        if (index == 0) {
            if (size == 1) {
                this.clear();
            }
            head = head.next;
            head.prev = null;
            size--;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
        } else {
            remove.next.prev = remove.prev;
            remove.prev.next = remove.next;
            size--;
        }
    }

    @Override
    public void clear() {
        Node node = head;
        while (node != null) {
            Node next = node.next;
            node.prev = node.next = null;
            node.data = null;
            node = next;
        }
        head = tail = null;
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printAll() {
        if(isEmpty()){
            System.out.println("The list is empty!");
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

