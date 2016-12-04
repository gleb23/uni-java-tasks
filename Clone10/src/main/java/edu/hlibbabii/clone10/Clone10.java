package edu.hlibbabii.clone10;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Clone10 {

    /**
     * @param args the command line arguments
     */
    //TODO unit-tests instead of this
    public static void main(String[] args) {
        try {
            MyLinkedList list = new MyLinkedList();
            list.add(new A(3));
            list.add(new A(4));
            MyLinkedList list2 = (MyLinkedList) list.clone();
            System.out.println(list.get(0).toString() + "  " + list.get(1).toString());
            System.out.println(list2.get(0).toString() + "  " + list2.get(1).toString());
            ((A) list2.getFirst()).a = 10;
            System.out.println(list.get(0).toString() + "  " + list.get(1).toString());
            System.out.println(list2.get(0).toString() + "  " + list2.get(1).toString());
            list2.add(list2.remove(0));
            System.out.println(list.get(0).toString() + "  " + list.get(1).toString());
            System.out.println(list2.get(0).toString() + "  " + list2.get(1).toString());
        } catch (MyLinkedList.IndexOutOfRangeException e) {
            Logger.getLogger(Clone10.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private static class A {

        public int a;

        public A(int aa) {
            a = aa;
        }

        @Override
        public String toString() {
            return (new Integer(a)).toString();
        }
    }
}