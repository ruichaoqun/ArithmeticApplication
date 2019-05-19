package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Num23 {

    /**
     * 暴力法，每次遍历列表，拿出最小的插入新链表结尾
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode header = new ListNode(1);
        ListNode node = header;

        List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));

        while (listNodes.size() > 1){
            ListNode minNode = listNodes.get(0);
            int min = 0;
            for (int i = 0; i < listNodes.size(); i++) {
                if(minNode.val > listNodes.get(i).val){
                    minNode = listNodes.get(i);
                    min = i;
                }
            }
            node.next = minNode;
            if(minNode.next == null){
                listNodes.remove(min);
            }else{
                listNodes.set(min,minNode.next);
            }
        }
        if(listNodes.size() == 1){
            node.next = listNodes.get(0);
        }
        return header.next;
    }

    /**
     *
     * @param lists
     * @return
     * 分治法
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        node1.next =  new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next =  new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next =  new ListNode(6);
        ListNode[] nodes = new ListNode[]{node1,node2,node3};
        mergeKLists(nodes);
    }
}
