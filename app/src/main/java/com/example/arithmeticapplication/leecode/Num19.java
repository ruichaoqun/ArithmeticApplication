package com.example.arithmeticapplication.leecode;

import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Num19 {

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        removeNthFromEnd(node,2);
    }

    /**
     * 递归算法
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1){
            return null;
        }
        ListNode headNode = head;
        //获取倒数第n个节点的前面一个节点
        int i = getNodeIndex(head,n,headNode);
        if(i == -1)
            return head.next;
        return headNode;
    }

    public static int getNodeIndex(ListNode node,int n,ListNode headNode){
        if(node.next == null){
            return 1;
        }
        //节点后面还有t个节点
        int t = getNodeIndex(node.next,n,headNode);
        //如果当前节点就是要选择的节点
        if(n == t && node.next != null){
            node.next = node.next.next;
            return t + 1;
        }
        //如果
        if(node == headNode && n == t + 1){
            return -1;
        }
        return t+1;
    }


    /**
     *
     * @param head
     * @param n
     * @return
     * 两个指针，开始前指针移动，当距离是n时再同时移动两个指针直到前指针的next为空，后指针的next就是要删除的节点
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        int i = 0;
        ListNode preNode = headNode;
        ListNode bacNode = headNode;
        while (preNode.next != null && i != n){
            preNode = preNode.next;
            i++;
        }
        if(i < n){
            return null;
        }

        while (preNode.next != null){
            preNode = preNode.next;
            bacNode = bacNode.next;
        }
        if(bacNode == headNode)
            return head.next;

        bacNode.next = bacNode.next.next;
        return headNode.next;
    }

}
