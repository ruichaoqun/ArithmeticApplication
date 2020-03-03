package com.example.arithmeticapplication.leecode;

import java.util.List;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num206 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode p = reverseList(listNode);
        System.out.printf("");
    }

    //递归
    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode p1 = head.next;
        ListNode node = reverseList(head.next);
        head.next = null;
        p1.next = head;
        return node;
    }

    //迭代
    public static ListNode reverseList1(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = head.next;
        head.next = null;
        while (pre != null){
            ListNode p = pre.next;
            pre.next = head;
            head = pre;
            pre = p;
        }
        return head;
    }
}
