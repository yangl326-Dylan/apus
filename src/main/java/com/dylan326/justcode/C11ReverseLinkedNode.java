package com.dylan326.justcode;


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
    }

    public static ListNode reverseLinkNode(ListNode sourceNode) {
        ListNode resultHead = new ListNode(0);
        while (sourceNode != null) {
            ListNode tmp = resultHead.next;
            ListNode tmpHead = sourceNode.next;
            resultHead.next = sourceNode;
            sourceNode.next = tmp;
            sourceNode = tmpHead;
        }
        return resultHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(reverseLinkNode(listNode4).val);

    }
}
