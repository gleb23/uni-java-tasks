package edu.hlibbabii.clone10;

//TODO why do we need to implement our own LinkedList?
class MyLinkedList<E> implements Cloneable {

    public static class IndexOutOfRangeException extends Exception {

        public IndexOutOfRangeException() {
        }
    }

    Node start = null;
    
    /**
     * class representing element of the list
     */    
    private class Node {

        /** reference on the previous element */
        Node prev;
        
        /** reference on the next element */
        Node next;
        
        /** data itself */
        E data;

        /** creates node with two pointers on itself */
        Node(E x) {
            data = x;
            prev = this;
            next = this;
        }

        private Node(Node prevNode, Node nextNode, E x) {
            data = x;
            next = nextNode;
            prev = prevNode;
        }
    }

    /**
     * Adds element to the end
     * @param x element to be added to the end
     */
    public void add(E x) {
        if (start == null) {
            start = new Node(x);
        } else {
            Node tmp = new Node(start.prev, start, x);
            start.prev.next  = tmp;
            start.prev = tmp;
        }
    }

    /**
     * returns the element with given index
     * @param index index of the element to get
     * @return the element with given index
     * @throws MyLinkedList.IndexOutOfRangeException
     */
    public E get(int index) throws IndexOutOfRangeException {
        if (index < 0 || index >= size())
            throw new IndexOutOfRangeException();
        else {
            Node start2 = start;
            while (index-- != 0) {
                start2 = start2.next;
            }
            return start2.data;
        }
    }
    
    public E getFirst() {
        return start.data;
    }
    
    /**
     * removes the element with given index
     * @param index index of the element to be removed
     * @return removed element
     * @throws IndexOutOfRangeException
     */
    public E remove(int index) throws IndexOutOfRangeException {
        if (index < 0 || index >= size())
            throw new IndexOutOfRangeException();
        else {
            Node start2 = start;
            while (index-- != 0) {
                start2 = start2.next;
            }
            if (start == start2) { // delete from the beginning
                if (start == start.next) { // one element in the list
                    start = null;
                } else {
                    start = start.next;
                }
            }
            // now remove start2
            start2.prev.next = start2.next;
            start2.next.prev = start2.prev;
            return start2.data;
        }
    }
    
    /**
     * returns the number of elements in the list
     * @return the number of elements in the list
     */
    public int size() {
        if (start == null) {
            return 0;
        } else {
            Node start2 = start.next;
            int counter = 1;
            while (start2 != start) {
                ++counter;
                start2 = start2.next;
            }
            return counter;
        }
    }

    
    /**
     * Returns a shallow copy of this LinkedList. 
     * (The elements themselves are not cloned.)
     * @return a shallow copy of this LinkedList instance
     */
    @Override
    public Object clone() {
        int cloneSize = size();
        MyLinkedList<E> cloneList = new MyLinkedList<E>();
        for (int i = 0 ; i < cloneSize; i++) {
            try {
                cloneList.add(this.get(i));
            } catch (IndexOutOfRangeException ex) {}
        }
        return cloneList;
    }
}
