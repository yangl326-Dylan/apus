package com.dylan326.apus;

/**
 * Created by dylan on 2018/3/23.
 * 移除倒数第n个节点，一般就是多个指针，走在前面的指针到达尾部，那么后面的指针的下一个位置就是需要移除的节点
 */
public class A19RemoveNthNodeEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (n == 0) {
            return head;
        }
        ListNode tmp = head;
        ListNode tmp1 = head;
        ListNode tmp2 = head;
        while (n-- > 0) { // 初始化走在前面的指针
            tmp2 = tmp2.next;
        }
        while (true) {
            if (tmp2 == null) {  // n=链表长度的时候
                return head.next;
            }
            if (tmp2.next != null) { //确定后面指正的位置
                tmp2 = tmp2.next;
                tmp1 = tmp1.next;
            } else {
                break;
            }
        }
        ListNode next = tmp1.next.next;// 找到节点和删除
        tmp1.next = next;
        return tmp;

    }
}
