package com.example.arithmeticapplication.leecode;

public class Num160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int length1 = 0,length2 = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null){
            length1 ++;
            p1 = p1.next;
        }
        while (p2 != null){
            length2 ++;
            p2 = p2.next;
        }
        while (length1 != length2){
            if(length1 < length2){
                headB = headB.next;
                length2 --;
            }else{
                headA = headA.next;
                length1--;
            }
        }
        while (headA != headB && headA != null){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
