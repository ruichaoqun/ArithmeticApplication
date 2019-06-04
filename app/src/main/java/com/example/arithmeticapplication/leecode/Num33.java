package com.example.arithmeticapplication.leecode;

import java.util.Arrays;

/**
 * @author Rui Chaoqun
 * @description: 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * @date :2019/6/3 18:05
 */
public class Num33 {


    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 2, 3, 4};
        int result = search(nums, 1);
        System.out.println("result = [" + result + "]");
    }


    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //left 到 mid是升序排列
            if (nums[left] < nums[mid]) {
                if (target == nums[left]) {
                    return left;
                }

                if (target > nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //mid 到 right是升序排列
                if (target == nums[right]) {
                    return right;
                }
                //target位于mid和right中间
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
