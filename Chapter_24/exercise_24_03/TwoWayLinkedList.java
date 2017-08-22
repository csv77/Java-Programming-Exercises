package exercise_24_03;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class TwoWayLinkedList<E> extends AbstractSequentialList<E> {
    protected int size = 0; // The size of the list
    private Node<E> head, tail;
    
    /** Create a default list */
    public TwoWayLinkedList() {
    }
    
    /** Create a list from an array of objects */
    public TwoWayLinkedList(E[] objects) {
        for(int i = 0; i < objects.length; i++)
            add(objects[i]);
    }
    
    /** Return the head element in the list */
    public E getFirst() {
        if(size == 0) {
            return null;
        }
        else {
            return head.element;
        }
    }
    
    /** Return the last element in the list */
    public E getLast() {
        if(size == 0) {
            return null;
        }
        else {
            return tail.element;
        }
    }
    
    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e);
        if(size > 0) {
            head.previous = newNode;
        }
        newNode.next = head;
        newNode.previous = null;
        head = newNode;
        size++;

        if(tail == null) {
            tail = head;
        }
    }
    
    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e);

        if(tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.next = null;
            newNode.previous = tail;
            tail = tail.next;
        }

        size++;
    }
    
    @Override /** Add a new element at the specified index 
     * in this list. The index of the head element is 0 */
    public void add(int index, E e) {
        if(index == 0) {
            addFirst(e);
        }
        else if(index >= size) {
            addLast(e);
        }
        else {
            Node<E> current = head;
            for(int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp2 = current.next;
            Node<E> temp1 = current;
            current.next = new Node<E>(e);
            (current.next).next = temp2;
            (current.next).previous = temp1;
            temp2.previous = current.next;
            temp1.next = current.next;
            size++;
        }
    }
    
    /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            else {
                head.previous = null;
            }
            return temp.element;
        }
    }
    
    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else {
            Node<E> temp = tail;
            tail = tail.previous;
            tail.next = null;
            size--;
            return temp.element;
        }
    }
    
    public ListIterator<E> listIterator() {
        return new TwoWayLinkedListIterator<>();
    }
    
    @Override
    public ListIterator<E> listIterator(int index) {
        return new TwoWayLinkedListIterator<>(index);
    }

    @Override
    public int size() {
        return size;
    }

    public class TwoWayLinkedListIterator<E> implements ListIterator<E> {
        private Node<E> current = (Node<E>)head; // Current index
        private int index;
        
        public TwoWayLinkedListIterator() {
        }
        
        public TwoWayLinkedListIterator(int index) {
            this.index = index;
        }
                
        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public boolean hasPrevious() {
            return (current != null);
        }

        @Override
        public E previous() {
            E e = current.element;
            current = current.previous;
            return e;
        }

        @Override
        public int nextIndex() {
            if(hasNext()) {
                return index + 1;
            }
            else {
                throw new IndexOutOfBoundsException("no more element");
            }
        }

        @Override
        public int previousIndex() {
            if(hasPrevious()) {
                return index - 1;
            }
            else {
                throw new IndexOutOfBoundsException("no more element");
            }
        }

        @Override
        public void remove() {
            
        }

        @Override
        public void set(E e) {
            
        }

        @Override
        public void add(E e) {
            
        }
    }

    
    
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;
        
        public Node(E e) {
            element = e;
        }
    }
    
}
