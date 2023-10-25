package com.dylan326.justcode;

import java.util.Arrays;

/**
 * Created by dylan on 2023/10/23.
 */
public class Solution25RevertK {
    /**
     * 1->2->3->4->5 k=2 2->1->4->3->5
     * 1->2->3->4->5 k=3 3->2->1->4->5
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || checkSmallerThanK(head, k)) {
            return head;
        }
        ListNode[] firstResult = reverseLinkedList(head, k);
        ListNode tmpHead = firstResult[0];
        ListNode tmpTail = firstResult[1];
        ListNode tmpNextHead = firstResult[2];
        while (!checkSmallerThanK(tmpNextHead, k)) {
            ListNode[] tmpResult = reverseLinkedList(tmpNextHead, k);
            tmpTail.next = tmpResult[0];
            tmpTail = tmpResult[1];
            tmpNextHead = tmpResult[2];
        }

        return tmpHead;
    }

    public static ListNode[] reverseLinkedList(ListNode head, int k) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode tail = null;
        ListNode nextHead = null;
        int counter = 0;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            if (counter == 1) {
                tail = curr;
            }
            if (++counter >= k) {
//                nextHead = new ListNode(curr.next);
                break;
            }
        }
        nextHead = curr;
        return new ListNode[]{pre, tail, nextHead};
    }

    private static boolean checkSmallerThanK(ListNode head, int k) {
        int counter = 0;
        while (head != null) {
            head = head.next;
            if (++counter > k) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1->2->3->4->5   5->4->3->2->1
     *
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static ListNode[] reverseLinkedList2(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode[]{head, head};
        }
        ListNode tmpHead = new ListNode(head);
        tmpHead.next = null;
        ListNode tailNode = new ListNode(tmpHead);
        while (head.next != null) {
            ListNode tmp = new ListNode(head.next);
            tmp.next = tmpHead;
            tmpHead = tmp;
            head = head.next;
        }
        return new ListNode[]{tmpHead, tailNode};
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        System.out.println(Arrays.toString(reverseLinkedList2(l1)));
        System.out.println(reverseLinkedList(l1, 3));
//        System.out.println(reverseLinkedList(l4));
//        System.out.println(reverseLinkedList(l5));
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(ListNode tmp) {
            this.val = tmp.val;
            this.next = tmp.next;
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer().append(val);
            if (next != null) {
                ListNode tmp = new ListNode(next);
                while (tmp != null) {
                    sb.append("->").append(tmp.val);
                    tmp = tmp.next;
                }
            }
            return sb.toString();
        }
    }
}
