package com.dylan326.apus;

/**
 * Created by dylan on 2017/5/22.
 * 链表数据相加
 * 注意进位状态，只可能是0或者1
 * 思考反向表示大数如何处理
 */
public class A2Add2Num {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int status = 0;
        ListNode tmpNode = new ListNode(0);
        ListNode result = new ListNode(0);
        int i = 0;
        while (i++ >= 0) {
            ListNode tmp = new ListNode(0);
            if (l1 != null && l2 != null) {
                tmp.val = (l1.val + l2.val + status) % 10;
                if ((l1.val + l2.val + status) / 10 == 1) {
                    status = 1;
                } else {
                    status = 0;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 != null) {
                tmp.val = (l2.val + status) % 10;
                if ((l2.val + status) / 10 == 1) {
                    status = 1;
                } else {
                    status = 0;
                }
                l2 = l2.next;
            } else if (l1 != null) {
                tmp.val = (l1.val + status) % 10;
                if ((l1.val + status) / 10 == 1) {
                    status = 1;
                } else {
                    status = 0;
                }
                l1 = l1.next;
            } else {
                if (status != 0) {
                    tmpNode.next = new ListNode(1);
                }
                break;
            }
            if (i == 1) {
                result = tmp;
            }
            tmpNode.next = tmp;
            tmpNode = tmpNode.next;

        }
        return result;
    }

    public static void main(String[] args) {
        ListNode headOld = new ListNode(1);
        headOld.next = new ListNode(2);
        headOld.next.next = new ListNode(3);
        headOld.next.next.next = new ListNode(4);
        print(headOld);
// 0->1->2->end
        ListNode currentNode = headOld;
        ListNode currentHead = headOld;
        ListNode next1 = currentNode.next;
        ListNode next2 = currentNode.next.next;
        if (next2 == null) { // 2个元素
            next1.next = currentNode;
            currentNode.next = null;
            print(next1);
            return;
        } else {
            currentHead = next1;
            next1.next = headOld;
            currentNode = next2;
            headOld.next = null;
        }
        print(currentHead);
        while (currentNode != null) {
            ListNode tmp = currentNode.next;
            currentNode.next = currentHead;
            currentHead = currentNode;
            currentNode = tmp;
        }
        print(currentHead);


    }

    private static void print(ListNode head) {
        System.out.print("head ");
        while (head != null) {
            System.out.print(String.valueOf(head.val) + "->");
            head = head.next;
        }
        System.out.println("end");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}