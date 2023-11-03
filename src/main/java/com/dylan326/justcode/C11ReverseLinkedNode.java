package com.dylan326.justcode;


import java.util.Arrays;
import java.util.List;

/**
 * Created by dylan on 2019/11/11.
 * 链表反转
 * Given 1->2->3->4->5->6, you should return the list as 6->5->4->3->2->1.
 */
public class C11ReverseLinkedNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    /**
     * Given 1->2->3->4->5->6
     *
     * @param sourceNode
     * @return
     */
    public static ListNode reverseLinkNode(ListNode sourceNode) {
        ListNode pre = null;
        ListNode curr = sourceNode;
        while (curr != null) {
            ListNode tmpNext = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmpNext;
        }
        return pre;
    }

    /**
     * Given v- 1->2->3->4->5->6
     * 理解度更高
     *
     * @param sourceNode
     * @return
     */

    public static ListNode reverseLinkNode2(ListNode sourceNode) {
        ListNode virHead = new ListNode(0);
        ListNode curr = sourceNode;
        while (curr != null) {
            ListNode tmp = virHead.next;
            ListNode next = curr.next;

            curr.next = tmp;
            virHead.next = curr;

            curr = next;
        }
        return virHead.next;
    }

    public static ListNode[] reverseLinkNode2(ListNode sourceNode, int k) {
        ListNode virHead = new ListNode(0);
        ListNode curr = sourceNode;
        int counter = 0;

        ListNode tail = null;
        ListNode nextHead = null;
        while (curr != null) {
            ListNode tmp = virHead.next;
            ListNode currNext = curr.next;
            virHead.next = curr;
            curr.next = tmp;
            tail = tmp;
            curr = currNext;// 循环
            if (++counter >= k) {
                nextHead = curr;
                break;
            }
        }
        return new ListNode[]{virHead.next, tail, nextHead};
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        System.out.println(reverseLinkNode(listNode1).val);
        System.out.println(Arrays.toString(reverseLinkNode2(listNode1, 2)));

    }
}
