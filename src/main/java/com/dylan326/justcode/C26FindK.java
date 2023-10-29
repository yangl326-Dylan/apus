package com.dylan326.justcode;

public class C26FindK {
    public class Node {
        int val;
        Node next;

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static Node findK(Node head, int k) {
        Node current = head;
        while (current !=null){
            Node next = current.next;
            int count = k;
            while (next != null) {
                if (--count <= 0) {
                    break;
                }
                next = next.next;
            }
            if(count == 0 && next == null){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
