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
            Node<E> current = head.next;
            if(index < size / 2) {
                for(int i = 1; i < index; i++) {
                    current = current.next;
                }
            }
            else {
                current = tail.previous;
                for(int i = size - 2; i >= index; i--) {
                    current = current.previous;
                }
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
    
    @Override /** Remove the element at the specified position in this 
     *  list. Return the element that was removed from the list. */
    public E remove(int index) {   
        if(index < 0 || index >= size) {
            return null;
        }
        else if(index == 0) {
            return removeFirst();
        }
        else if(index == size - 1) {
            return removeLast();
        }
        else {
            Node<E> current = head.next;
            if(index < size / 2) {
                for(int i = 1; i < index; i++) {
                    current = current.next;
                }
            }
            else {
                current = tail.previous;
                for(int i = size - 2; i > index; i--) {
                    current = current.previous;
                }
            }
            
            Node<E> previous = current.previous;
            previous.next = current.next;
            current.next.previous = previous;
            size--;
            return current.element;
        }
    }
    
    @Override
    public boolean remove(Object e) {
        int index = indexOf((E)e);
        if(index == -1) {
            return false;
        }
        else {
            remove(index);
            size--;
            return true;
        }
    }
    
    @Override /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            }
            else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }
    
    @Override /** Clear the list */
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override /** Return true if this list contains the element e */
    public boolean contains(Object e) {
        if(size == 0) {
            return false;
        }
        Node<E> current = head;
        for(int i = 0; i < size; i++, current = current.next) {
            if(current.element.equals((E)e)) {
                return true;
            }
        }
        return false;
    }
    
    @Override /** Return the element at the specified index */
    public E get(int index) {
        checkIndex(index);
        if(index == 0) {
            return getFirst();
        }
        else if(index == size - 1) {
            return getLast();
        }
        else {
            Node<E> current = head.next;
            if(index < size / 2) {
                for(int i = 1; i < index; i++) {
                    current = current.next;
                }
            }
            else {
                current = tail.previous;
                for(int i = size - 2; i > index; i--) {
                    current = current.previous;
                }
            }
            
            return current.element;
        }
    }
    
    @Override/** Return the index of the head matching element in 
     *  this list. Return -1 if no match. */
    public int indexOf(Object e) {
        if(size == 0) {
            return -1;
        }
        if(getFirst().equals((E)e)) {
            return 0;
        }
        else if(getLast().equals((E)e)) {
            return size - 1;
        }
        Node<E> current = head.next;
        for(int i = 1; i < size - 1; i++, current = current.next) {
            if(current.element.equals((E)e)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override /** Return the index of the last matching element in 
     *  this list. Return -1 if no match. */
    public int lastIndexOf(Object e) {
        if(size == 0) {
            return -1;
        }
        Node<E> current = head;
        int lastIndex = -1;
        for(int i = 0; i < size; i++, current = current.next) {
            if(current.element.equals(e)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }
    
    @Override /** Replace the element at the specified position 
     *  in this list with the specified element. */
    public E set(int index, E e) {
        checkIndex(index);
        Node<E> current = head;
        for(int i = 0; i < index; i++, current = current.next) {
        }
        E temp = current.element;
        current.element = e;
        return temp;
    }
    
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
            ("Index: " + index + ", Size: " + size);
    }
    
    @Override
    public ListIterator<E> listIterator() {
        return new TwoWayLinkedListIterator();
    }
    
    @Override
    public ListIterator<E> listIterator(int index) {
        return new TwoWayLinkedListIterator(index);
    }

    @Override
    public int size() {
        return size;
    }

    public class TwoWayLinkedListIterator implements ListIterator<E> {
        private Node<E> current = head; // Current index
        
        public TwoWayLinkedListIterator() {
        }
        
        public TwoWayLinkedListIterator(int index) {
            if(index < size / 2) {
                current = head;
                for(int i = 0; i < index; i++) {
                    current = current.next;
                }
            }
            else {
                current = tail;
                for(int i = size - 1; i > index; i--) {
                    current = current.previous;
                }
            }
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
            return 1;
        }

        @Override
        public int previousIndex() {
            return 1;
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
