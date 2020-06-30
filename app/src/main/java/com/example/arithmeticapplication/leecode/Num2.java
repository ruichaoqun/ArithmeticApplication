package com.example.arithmeticapplication.leecode;

import java.util.List;
import java.util.Stack;

public class Num2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carray = 0;
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null){
            int i = l1.val + l2.val + carray;
            node.next = new ListNode(i%10);
            node = node.next;
            carray = i/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int i = l1.val+carray;
            node.next = new ListNode(i%10);
            node = node.next;
            carray = i/10;
            l1 = l1.next;
        }
        while (l2 != null){
            int i = l2.val+carray;
            node.next = new ListNode(i%10);
            node = node.next;
            carray = i/10;
            l2 = l2.next;
        }
        if(carray == 1){
            node.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1= new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2= new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Num2 num2 = new Num2();
        ListNode node = num2.addTwoNumbers(l1,l2);
        while (node!= null){
            System.out.printf(""+node.val);
            node = node.next;
        }
    }
}
