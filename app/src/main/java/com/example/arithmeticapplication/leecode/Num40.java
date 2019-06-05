package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @description:给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * @date :2019/6/5 15:44
 */
public class Num40 {
    List<List<Integer>>  mLists = new ArrayList<>();
    int[] candidates;
    int target;

    public static void main(String[] args) {
        Num40 num39 = new Num40();
        num39.combinationSum2(new int[]{2,3,5},8);
        System.out.println("args = [" + args + "]");
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            boolean exist = false;
            for (int i = 0; i < mLists.size(); i++) {

                if(mLists.get(i).size() == list.size()){
                    int j = 0;
                    for (; j < list.size(); j++) {
                        if(list.get(j) != mLists.get(i).get(j)){
                            break;
                        }
                    }
                    if(j == list.size()){
                        exist = true;
                        break;
                    }
                }
            }
            if(!exist){
                mLists.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if(offset < num)
                return;

            list.add(num);
            stack(i+1,offset-num,list);
            list.remove(list.size()-1);
        }
    }
}
