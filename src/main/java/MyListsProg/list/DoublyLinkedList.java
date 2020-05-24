package MyListsProg.list;
import java.util.Iterator;

public class DoublyLinkedList<T> implements Listable<T>, Iterable<T> {

    Node head;
    Node tail;
    int size;


    private class Node {
        T data;
        Node next;
        Node prev;
    }

    @Override
    public Iterator<T> iterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
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
        /*Node node = new Node();
        node.data = data;
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
        }*/
        if (data == null) {
            throw new IllegalArgumentException("No Info was passed");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (this.isEmpty()) {
            Node add = new Node();
            head = add;
            tail = add;
            size = 1;
        } else if (size == 1) {
            if (index == 0) {
                this.addFirst(data);
            } else {
                this.addLast(data);
            }
        } else if (index == size) {
            this.addLast(data);
        } else if (index == 0) {
            this.addFirst(data);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node next = current.next;
            Node add = new Node();
            next.prev = add;
            current.next = add;
            size++;
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
        //TODO set ?????????????????
        if (tail == null) throw new IllegalStateException();
        tail.data = data;

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
            throw new IndexOutOfBoundsException("Index out of bounds");
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
        return size;   //TODO SIZE!!!!!!!!!!!!!!
    }

    @Override
    public void printAll() {
//TODO printall
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

