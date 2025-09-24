// 定义链表节点类
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkReverse {
    /**
     * 将链表按照每2个节点为一组进行反转
     * @param head 链表的头节点
     * @return 反转后的链表头节点
     */
    public static ListNode reverseInPairs(ListNode head) {
        // 如果链表为空或者只有一个节点，直接返回头节点
        if (head == null || head.next == null) {
            return head;
        }
        
        // 保存当前组的第二个节点，反转后它会成为新的头节点
        ListNode newHead = head.next;
        // 保存下一组的头节点
        ListNode nextPair = head.next.next;
        
        // 反转当前组的两个节点
        head.next.next = head;
        // 当前组的第一个节点反转后指向后续反转后的链表
        head.next = reverseInPairs(nextPair);
        
        return newHead;
    }

    /**
     * 打印链表
     * @param head 链表的头节点
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建测试链表 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("原始链表:");
        printList(head);

        // 调用反转方法
        ListNode newHead = reverseInPairs(head);

        System.out.println("每2个节点反转后的链表:");
        printList(newHead);
    }
}
