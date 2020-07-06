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
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(min[i-1]*nums[i],Math.max(nums[i],max[i-1]*nums[i]));
            min[i] = Math.min(min[i-1]*nums[i],Math.min(nums[i],max[i-1]*nums[i]));
            result = Math.max(result,max[i]);
        }
        return result;
    }

    public int maxProduct1(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max,mi =  min;
            max = Math.max(mi*nums[i],Math.max(nums[i],mx*nums[i]));
            min = Math.min(mi*nums[i],Math.min(nums[i],mx*nums[i]));
            result = Math.max(result,max);
        }
        return result;
    }
}
