package com.example.arithmeticapplication.leecode;

public class Num41 {


    public static void main(String[] args) {
        firstMissingPositive(new int[]{1,2,3,4,5});
    }
    public static int firstMissingPositive(int[] nums) {

        //1.判断是否包含1，如果不包含，直接返回1
        boolean contains = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                contains = true;
                break;
            }
        }

        if(!contains){
            return 1;
        }

        //包含1切长度是1，直接返回2
        if(nums.length == 1){
            return 2;
        }

        //将所有小于等于0的数以及大于长度的数置为1
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <=0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }

        //将数字n出现的位置的num[n-1]置为负数
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            nums[a-1] = -Math.abs(nums[a-1]);
        }

        //查询第一个大于0的数
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n = i+1;
            if(nums[i] > 0) {
                return n;
            }
        }
        //都小于0，返回n+1
        return n+1;
    }
}
