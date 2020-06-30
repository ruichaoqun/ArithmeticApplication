package com.example.arithmeticapplication.recursion;

import com.example.arithmeticapplication.leecode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public void reverseString(char[] s) {
        if(s == null){
            return;
        }
        int left = 0,right = s.length-1;
        while (left < right){
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        swip(node);
        return node.next;
    }

    public void swip(ListNode head){
        if(head.next != null && head.next.next != null){
            ListNode p = head.next;
            ListNode p1 = head.next.next;
            ListNode p2 = head.next.next.next;
            head.next = p1;
            p1.next = p;
            p.next = p2;
            swip(p);
        }
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if(numRows == 0){
            return lists;
        }
        stack1(lists,numRows);
        return lists;
    }

    private void stack1(List<List<Integer>> lists, int numRows) {
        if(numRows == 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            lists.add(list);
            return;
        }
        stack1(lists,numRows-1);
        List<Integer> list = lists.get(lists.size()-1);
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if(i == 0 || i == numRows-1){
                list1.add(1);
            }else{
                list1.add(list.get(i-1)+list.get(i));
            }
        }
        lists.add(list1);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= rowIndex+1; i++) {
            list.add(stack2(rowIndex+1,i));
        }
        return list;
    }

    private int stack2(int row, int index) {
        if(index == 1 || index == row){
            return 1;
        }
        return stack2(row-1,index-1)+stack2(row-1,index);
    }


    public static void main(String[] args) {
        Test1 test1 = new Test1();
        List<List<Integer>> lists = test1.generate(5);
        System.out.printf(""+lists.size());
    }
}
