package com.example.arithmeticapplication.leecode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Num16 {
    public static void main(String[] args){

    }

    /**
     *
     * @param nums
     * @param target
     * @return
     *
     * 1.对数组进行排序，时间复杂度O(n²)
     * 2.遍历数组，每趟使用对撞指针查询最接近的和
     */
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            return Integer.MAX_VALUE;
        }
        //排序，复杂度O(n²)
        Arrays.sort(nums);
        //初始化三数之和
        int mostNearlySum = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i+1;
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target){
                    return target;
                }
                //此时三数之和绝对值小于之前记录的,记录
                if(Math.abs(target - sum) < Math.abs(target - mostNearlySum)){
                    mostNearlySum = sum;
                }

                if(sum > target){
                    //如果三数之和大于target，右指针左移
                    r--;
                }else if(sum < target){
                    // //如果三数之和小于target，左指针右移
                    l++;
                }
            }
        }
        return mostNearlySum;
    }
}
