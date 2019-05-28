package com.example.arithmeticapplication.leecode;

import java.util.Arrays;

/**
 * @author Rui Chaoqun
 * @description:
 * @date :2019/5/28 10:20
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Num31 {

    public static void main(String[] args){
        nextPermutation(new int[]{1,2,3});
    }

    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length <=1){
            return;
        }
        int index2 = 0;
        int i = nums.length-2;
        for (; i >= 0; i--) {
            if(nums[i] < nums[i+1]){
                break;
            }
        }
        if(i == -1){
            Arrays.sort(nums);
        }else{
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] > nums[i]){
                    index2 = j;
                }else{
                    break;
                }
            }
            int temp = nums[i];
            nums[i] = nums[index2];
            nums[index2] = temp;
            int left = i+1,right = nums.length-1;
            while (left<right){
                temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }

    }
}
