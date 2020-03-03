package com.example.arithmeticapplication.leecode;

import java.util.LinkedList;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num148 {

    public static void main(String[] args) {
        ListNode p1 = new ListNode(3);
        p1.next = new ListNode(2);
        p1.next.next = new ListNode(4);


        ListNode p = sortList(p1);
        System.out.printf(""+p.val);
    }


    // bottom-to-up 的算法
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int listLength = 0;
        ListNode p = head;
        while (p!= null){
            listLength++;
            p = p.next;
        }
        ListNode dumHead = new ListNode(0);
        dumHead.next = head;
        //每一步排序长度增倍
        int i = 1;
        while (i < listLength){
            ListNode p1 = dumHead.next;
            ListNode p2 = dumHead.next;
            ListNode p3 = dumHead.next;
            ListNode preTail = dumHead;
            int residueLength = listLength;
            while (residueLength > i){
                //这一步是找出需要执行合并的两个链表的尾节点
                for (int k = 0; k < i-1; k++) {
                    p2 = p2.next;
                    //第二个链表长度可能不是i
                    if(p3 != null && p3.next != null){
                        p3 = p3.next.next;
                    }
                }
                //切断第一个链表的尾部
                ListNode p5 = p3;
                if(p3 != null && p3.next != null){
                    p3 = p3.next.next;
                    //切断第二个链表的尾部
                    p5.next.next = null;
                }else {
                    p3 = null;
                }
                ListNode p4 = p2.next;
                p2.next = null;
                //将合并后的链表链接到前面
                preTail.next = merge(preTail,p1,p4);
                if(p3 != null){
                    while (preTail.next != null){
                        preTail = preTail.next;
                    }
                    //连上链表
                    preTail.next = p3;
                    p1 = p3;
                    p2 = p3;
                }
                residueLength -= i*2;
            }
            i *=2;
        }
        return dumHead.next;
    }



    public static ListNode merge(ListNode head,ListNode p1, ListNode p2) {
        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        p.next = p1 == null ? (p2 == null ? null : p2) : p1;
        return head.next;
    }
}
