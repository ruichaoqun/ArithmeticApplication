package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num47 {

    public static void main(String[] args) {
        List<List<Integer>> lists1 = permute(new int[]{1, 1, 2});
        System.out.println("args = [" + lists1.size() + "]");
    }

    public static List<List<Integer>> permute(int[] nums) {
        return permute(new ArrayList<List<Integer>>(), nums, 0);
    }

    /**
     * 递归
     *
     * @param lists
     * @param nums
     * @param i
     * @return
     */
    public static List<List<Integer>> permute(List<List<Integer>> lists, int[] nums, int i) {
        //递归出口
        if (i >= nums.length) {
            return lists;
        }
        //i= 0时做特殊处理
        if (lists.size() == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            lists.add(list);
            //插入第i+1个数
            return permute(lists, nums, i + 1);
        } else {
            //i != 0时
            List<List<Integer>> lists1 = new ArrayList<>();
            //遍历已经排好的0  -  i-1 的数组
            for (int j = 0; j < lists.size(); j++) {
                //对数组中每一个数组，将num[i]插入其中，注意插入的位置可以是0-list.size
                for (int k = 0; k <= lists.get(j).size(); k++) {
                    if (k != 0 && lists.get(j).get(k - 1) == nums[i]) {
                        continue;
                    }
                    List<Integer> list = new ArrayList<>(lists.get(j));
                    list.add(k, nums[i]);
                    boolean b = false;
                    //最后一步去重
                    if(i == nums.length-1){
                        for (int l = 0; l < lists1.size(); l++) {
                            int t = 0;
                            while (t < list.size()){
                                if(list.get(t).equals(lists1.get(l).get(t)))
                                    t++;
                                else
                                    break;
                            }
                            if(t == list.size()){
                                b = true;
                                break;
                            }
                        }
                    }
                    if(!b){
                        lists1.add(list);
                    }
                }
            }
            //插入第i+1个数
            return permute(lists1, nums, i + 1);
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

}
