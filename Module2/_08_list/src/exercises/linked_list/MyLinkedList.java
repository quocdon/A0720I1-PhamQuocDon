package exercises.linked_list;

public class MyLinkedList<E> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public void add(int index, E element) {
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        Node holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public boolean add(E element) {
        this.addLast(element);
        return true;
    }

    public int size() {
        return numNodes;
    }

    public E get(int index) {
        if (index >= numNodes) {
            throw new IllegalArgumentException("index: " + index);
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return (E) temp.data;
        }
    }

    public E getFirst() {
        if (head == null) {
            return null;
        } else {
            Node temp = head;
            return (E) temp.data;
        }
    }

    public E getLast() {
        if ( head == null){
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < numNodes - 1; i++) {
                temp = temp.next;
            }
            return (E) temp.data;
        }
    }

    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            if ((E) temp.data == element) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index: " + index);
        } else {
            Node temp = head;
            E data;
            if (index == 0) {
                data = (E) head.getData();
                head = head.next;
                numNodes--;
            } else {
                for (int i = 0; i < index - 1 && temp.next != null; i++) {
                    temp = temp.next;
                }
                data = (E) temp.next.data;
                if (index < numNodes - 1) {
                    temp.next = temp.next.next;
                }
                numNodes--;
            }
            return data;
        }
    }

    public boolean remove(Object object) {
        if (this.indexOf((E) object) == -1) {
            return false;
        } else {
            this.remove(this.indexOf((E) object));
            return true;
        }
    }

    public boolean contains(E element) {
        if (this.indexOf(element) == -1) {
            return false;
        } else return true;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> newlist = new MyLinkedList<E>();
        newlist.head = this.head;
        Node temp = head;
        Node newTemp = newlist.head;
        newlist.numNodes = this.numNodes;
        for (int i = 0; i < numNodes - 1; i++) {
            newTemp.next = temp.next;
        }
        return newlist;
    }
}

