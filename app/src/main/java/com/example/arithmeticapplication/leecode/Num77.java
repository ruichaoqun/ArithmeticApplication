package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/11/9 17:10
 * description:给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Num77 {
    public static void main(String[] args) {
        Num77 num77 = new Num77();
        num77.combine(4,2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new LinkedList<>();
        stack(new LinkedList<Integer>(),1,n,k,lists);
        return lists;
    }

    //回溯算法
    public void stack(LinkedList<Integer> list,int start,int n,int k,List<List<Integer>> result){
        if(list.size() == k){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = start; i <= n; ++i) {
            list.add(i);
            stack(list,i+1,n,k,result);
            list.removeLast();
        }
    }
}
