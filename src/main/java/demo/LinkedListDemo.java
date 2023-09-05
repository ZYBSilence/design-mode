package demo;

/**
 * @description:
 * @author: zyb
 * @date: 2023/8/17 11:24
 */
public class LinkedListDemo {

//    1:# 一个链表和一个整数k（k大于等于0，小于等于链表长度，链表长度未知），
//      # 按k步长反转链表比如1->2->3->4->5->6->7->8，
//      # 当k=3的时候结果是3->2->1->6->5->4->7->8
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 计算链表的长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        // 如果链表长度小于k，不需要反转，直接返回头节点
        if (length < k) {
            return head;
        }

        // 创建一个虚拟节点作为新链表的头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev指向新链表的末尾节点，curr指向当前片段的起始节点
        ListNode prev = dummy;
        ListNode curr = head;

        // 反转每个片段
        while (length >= k) {
            for (int i = 1; i < k; i++) {
                // 将curr的下一个节点插入到prev后面
                ListNode temp = curr.next;
                curr.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }

            // 更新prev和curr的位置
            prev = curr;
            curr = curr.next;
            length -= k;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 创建链表
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        // 反转链表
        int k = 3;
        ListNode result = reverseKGroup(head, k);

        // 打印结果
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
