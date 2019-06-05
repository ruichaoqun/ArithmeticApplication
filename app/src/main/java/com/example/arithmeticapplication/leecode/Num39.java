package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * @date :2019/6/5 15:44
 */
public class Num39 {
    List<List<Integer>>  mLists = new ArrayList<>();
    int[] candidates;
    int target;

    public static void main(String[] args) {
        Num39 num39 = new Num39();
        num39.combinationSum(new int[]{2,3,5},8);
        System.out.println("args = [" + args + "]");
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        stack(0,target,new ArrayList<Integer>());
        return mLists;
    }

    private void stack(int index,int offset,List<Integer> list) {
        if(offset < 0){
            return;
        }
        if(offset == 0){
            mLists.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if(offset < num)
                return;
            list.add(num);
            stack(i,offset-num,list);
            list.remove(list.size()-1);
        }
    }
}
