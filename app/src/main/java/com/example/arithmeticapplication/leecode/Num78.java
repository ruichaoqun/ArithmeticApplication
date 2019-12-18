package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/11/9 17:36
 * description:给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Num78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        stack(new LinkedList<Integer>(),0,nums,lists);
        return lists;
    }

    public void stack(LinkedList<Integer> list,int p, int[] nums,List<List<Integer>> lists){
        lists.add(new ArrayList<>(list));

        for (int i = p; i < nums.length; i++) {
            list.add(nums[i]);
            stack(list,i+1,nums,lists);
            list.removeLast();
        }
    }
}
