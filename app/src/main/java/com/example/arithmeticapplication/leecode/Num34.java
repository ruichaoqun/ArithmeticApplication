package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @description:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @date :2019/6/4 10:27
 */
public class Num34 {

    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10},6);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int left = 0,right = nums.length-1,mid=0;
        boolean hasFindTarget = false;
        while (left<= right){
            mid = left+(right-left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                hasFindTarget = true;
                break;
            }
        }

        if(!hasFindTarget){
            return result;
        }

        int left1 = left,right1 = mid,left2 = mid,right2 = right;
        while (left1 <= right1){
            int m = left1+(right1 - left1)/2;
            if(nums[m] < target){
                left1 = m+1;
            }else{
                if(m == 0 || (m > 0 && nums[m-1] != target)){
                    result[0] = m;
                    break;
                }
                right1 = m-1;
            }
        }

        while (left2 <= right2){
            int m = left2+(right2 - left2)/2;
            if(nums[m] > target){
                right2 = m-1;
            }else{
                if(m == nums.length-1 || (m < nums.length-1 && nums[m+1] != target)){
                    result[1] = m;
                    break;
                }
                left2 = m+1;
            }
        }

        return result;
    }
}
