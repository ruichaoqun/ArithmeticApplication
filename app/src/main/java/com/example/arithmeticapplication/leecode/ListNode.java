package com.example.arithmeticapplication.leecode;

public class ListNode {
    public int val;
    public ListNode next;


    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder builder =new StringBuilder();
        ListNode node = this;
        while (node != null){
            builder.append(node.val);
            builder.append(" , ");
            node = node.next;
        }
        return builder.toString();
    }
}
