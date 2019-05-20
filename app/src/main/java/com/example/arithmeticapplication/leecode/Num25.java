package com.example.arithmeticapplication.leecode;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Num25 {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        reverseKGroup(node, 3);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || k == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode header = new ListNode(0);
        header.next = head;
        ListNode bac = header;
        ListNode pre = header;
        for (int i = 0; i < k; i++) {
            if (pre.next == null) {
                return header.next;
            }
            pre = pre.next;
        }

        while (pre != null) {
            //此时bac.next指向第k*n个节点，pre指向第n*(k+1)个节点
            //记录下一个链表的首节点
            ListNode nextFirstNode = pre.next;
            //记录上一段的尾节点
            ListNode bacLastNode = bac;
            ListNode targetFirstNode = pre;
            ListNode targetLastNode = bac.next;
            ListNode lastpreNode = pre.next;
            //使用尾插法翻转链表
            bac = bac.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode node = bac.next;
                bac.next = pre.next;
                pre.next = bac;
                bac = node;
                if (lastpreNode != null) {
                    lastpreNode = lastpreNode.next;
                }
            }

            bacLastNode.next = targetFirstNode;
            targetLastNode.next = nextFirstNode;
            bac = targetLastNode;
            pre = lastpreNode;
        }

        return header.next;
    }
}
