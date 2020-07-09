package com.example.arithmeticapplication.leecode.sort;

/**
 * @author Rui Chaoqun
 * @date :2020/6/23 9:31
 * description:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 */
public class Offer51 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy,0,len-1,temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if(left == right){
            return 0;
        }
        int mid = left + (right-left)/2;
        int leftPairs = reversePairs(nums,left,mid,temp);
        int rightPairs = reversePairs(nums,mid+1,right,temp);
        if(nums[mid] <= nums[mid+1]){
            return leftPairs+rightPairs;
        }
        int mergePairs = mergePairs(nums,left,mid,right,temp);
        return leftPairs +rightPairs + mergePairs;
    }

    private int mergePairs(int[] nums, int left, int mid, int right, int[] temp) {
        //只需要拷贝left到right的数据到temp中
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid+1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if(i == mid+1){
                nums[k] = temp[j];
                j++;
            }else if(j == right+1){
                nums[k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }else{
                nums[k] = temp[j];
                j++;
                count += mid-i+1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Offer51 offer51 = new Offer51();
        int count = offer51.reversePairs(new int[]{7,5,6,4});
        System.out.print(count);
    }
}

