package com.example.arithmeticapplication.leecode;

import java.util.Arrays;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num42 {

    public static void main(String[] args) {
        int sum = trap(new int[]{8,5,4,1,8,9,3,0,0});
        System.out.println("sum = [" + sum + "]");
    }
    public static int trap(int[] height) {
        return caculate(height,0,height.length-1);
    }

    /**
     * 1.找出left到right区间的第一大的值和第二大的值，这俩值有可能相等，
     * 2.算出第一大到第二大中间的面积，
     * 3.再递归left到左边大值以及右边大值到right的面积
     * @param height
     * @param left
     * @param right
     * @return
     */
    public static int caculate(int[] height,int left,int right){
        if(left+1 >= right){
            return 0;
        }
        //找出left到right区间的第一大的值和第二大的值，这俩值有可能相等，
        int maxHeight = 0;
        int secondHeight = 0;
        int maxHeightValue = -1;
        int secondHeightValue = -1;
        for (int i = left; i <= right; i++) {
            if(height[i] >= maxHeightValue){
                secondHeight = maxHeight;
                secondHeightValue = maxHeightValue;
                maxHeight = i;
                maxHeightValue = height[i];
            }else if(height[i] > secondHeightValue){
                secondHeightValue = height[i];
                secondHeight = i;
            }
        }
        //算出第一大到第二大中间的面积，
        int maxValue = height[secondHeight];
        int l = maxHeight< secondHeight?maxHeight:secondHeight;
        int r = maxHeight < secondHeight?secondHeight:maxHeight;
        int sum = 0;
        for (int i = l+1; i < r; i++) {
            sum += maxValue - height[i];
        }
        //递归left到左边大值以及右边大值到right的面积
        return sum+caculate(height,left,l)+caculate(height,r,right);
    }
}
