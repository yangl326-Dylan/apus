package com.dylan326.justcode;

public class C26PartitionNodeList {
    public static class Node {
        int val;
        Node next;

        public Node(){
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static Node partition(Node head, int partition) {
        Node result  = new Node();
        result.next = head;
        Node current = head;
        Node tail = head;
        while (current !=null){
            if(current.val < partition){
                Node resultNext = result.next;
                Node next = current.next;

                result.next = current;
                current.next = resultNext;
                current =  next;
            }else{
                tail.next = current;
                tail = current;
                current = current.next;
            }
        }
        return result.next;

    }

    public static void main(String[] args) {

    }
}
