package com.dylan326.apus;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * <p>
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * 分析单向链表 需要知道头结点才能做头结点后的节点数据交换（此case是两节点）。
 * 实际先交换节点1，2 变成2-1-3-4， 此时2节点为结果的头结点，但是后面的节点没处理
 * 然后按照知晓头结点1 处理1-3-4中的3，4 交换， 依次类推处理知道节点后面小于2个节点退出
 */
public class A24SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { // 初始条件判定
            return head;
        }
        // 首节点交换逻辑 result为结果即头结点， 但是当前后面的数据还没处理
        ListNode result = new ListNode(head.next.val);
        head.next = head.next.next;
        result.next = head;
        ListNode node = head; // 此时2-1-3-4
        while (node.next != null && node.next.next != null) {  // 循环退出即后面小于两个节点 不需要做交换
            ListNode tmp1 = node.next; // 处理例子 1-3-4； 1节点后面的数据
            ListNode tmp2 = node.next.next.next;
            node.next = tmp1.next;
            node.next.next = tmp1;
            tmp1.next = tmp2; // 结束后1-4-3

            node = tmp1; // 重置循环初始条件 此时例子应该为 3节点。 如果后面还有数据
        }
        return result;
    }

    //Given 1->2->3->4, you should return the list as 2->1->4->3.
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) { // 初始条件判定
            return head;
        }
        ListNode result = head.next;
        ListNode node3 = head.next.next;
        result.next = head;
        head.next = node3; //2 1 3 4
        ListNode node = head;  //  1开始
        while (node.next != null && node.next.next != null) {
            ListNode tmp1 = node.next;
            ListNode tmp2 = node.next.next.next;
            node.next = tmp1.next;
            node.next.next = tmp1;
            tmp1.next =  tmp2;

            node = tmp1;
        }
        return result;
    }
}
