package com.example.arithmeticapplication.leecode.dynamicplanning;

/**
 * @author Rui Chaoqun
 * @date :2020/1/15 14:29
 * description:给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 */
public class Num152 {

    public int maxProduct(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.max(arr[i-1],caculateMaxWithIndex(i,nums));
        }
        return arr[arr.length-1];
    }

    private int caculateMaxWithIndex(int i, int[] nums) {
        int count = nums[i];
        int maxCount = count;
        for (int j = i-1; j >= 0; j--) {
            count = count*nums[j];
            if(count > maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }
}
