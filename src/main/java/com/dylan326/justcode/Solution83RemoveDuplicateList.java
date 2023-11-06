package com.dylan326.justcode;

public class Solution83RemoveDuplicateList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static ListNode removeDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            while (next != null) {
                if (current.val == next.val) {
                    current.next = next.next;
                    next = next.next;
                } else {
                    current = next;
                }
            }
            current = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode tmp1 = new ListNode(1);
        ListNode tmp2 = new ListNode(1);
        ListNode tmp3 = new ListNode(1);
        ListNode tmp4 = new ListNode(2);
        tmp1.next = tmp2;
        tmp2.next = tmp3;
        tmp3.next = tmp4;
        ListNode result = removeDuplicates(tmp1);
        System.out.println(result);

    }
}
