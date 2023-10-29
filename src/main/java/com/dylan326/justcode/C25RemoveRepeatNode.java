package com.dylan326.justcode;

public class C25RemoveRepeatNode {
    public class Node{
        int val;
        Node next;

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static Node removeRepeat(Node head){
        Node current = head;
        while (current!=null){
            Node tmp = current.next;
            while (tmp !=null){
                if(tmp.val == current.val){
                    tmp.next = tmp.next.next;
                }else {
                    tmp = tmp.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}


