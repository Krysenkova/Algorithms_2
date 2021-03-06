package MyListsProg.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Listable<T> {

    Node head = null; //head of the list

    private class Node {
        T data;
        Node next;
    }

    private class SinglyListIterator implements Iterator<T> {
        Node nextNode;

        SinglyListIterator() {
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

    public Iterator<T> iterator() {
        return new SinglyListIterator();
    }

    public SinglyLinkedList() {

    }


    @Override
    public void add(T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    @Override
    public void add(int index, T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (index < 0){
            System.out.println("Wrong Index. The student wasn't added");
        }
        else if(index > size()){
            System.out.println("Index is bigger than the size of the list. The student will be attached to the end of the list at index " + size());
            addLast(data);
        }
        else if (head == null) {
            head = node;
        } else if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node currentNode = head;
            int i = 1;
            while (currentNode != null) {
                if (i == index) {
                    node.next = currentNode.next;
                    currentNode.next = node;
                    break;
                }
                currentNode = currentNode.next;
                i++;
            }
        }
    }

    @Override
    public void addFirst(T data) {
        Node node = new Node();
        node.data = data;
        if (head != null) {
            node.next = head;
            head = node;
        } else {
            head = node;
            node.next = null;
        }
    }

    @Override
    public void addLast(T data) {
        add(data);
    }

    @Override
    public void set(int index, T data) {
        if (index < 0 || index > this.size()) {
            System.out.println("Index is wrong!");
        }
        Node temp = head;
        if (!isEmpty()) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.data = data;
        } else
            System.out.println("List is empty!");
    }

    @Override
    public T get(int index) {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            if (counter == index) {
                return temp.data;
            }
            counter++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public void remove(int index) {
        if(index >= size()){
            System.out.println("");
        }
        if (head == null)
            System.out.println("List is empty!");
        Node temp = head;
        if (index == 0) {
            head = temp.next; }
        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null)
            return;
        temp.next = temp.next.next;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public int size() {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    @Override
    public void printAll() {
        if(isEmpty()){
            System.out.println("The list is already empty!");
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}