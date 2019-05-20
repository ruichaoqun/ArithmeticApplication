package com.example.arithmeticapplication.leecode;

import java.util.List;


/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Num24 {
    //重点在怎么交换两个节点
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode node = headNode;
        while (node.next != null){
            if(node.next.next == null){
                return headNode.next;
            }
            //交换节点
            ListNode node1 = node.next;
            node.next = node.next.next;
            node1.next = node1.next.next;
            node.next.next = node1;
            node = node.next.next;
        }
        return headNode.next;
    }
}
