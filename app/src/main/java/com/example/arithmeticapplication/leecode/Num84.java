package com.example.arithmeticapplication.leecode;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *  
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num84 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};
        System.out.printf(""+new Num84().largestRectangleArea(arr));
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int k =  caculateMaxInIndex(heights,i);
           if(max < k){
               max = k;
           }
        }
        return max;
    }

    public int caculateMaxInIndex(int[] heights,int index){
        int left = index;
        int right = index;
        while (left >= 0 && heights[left] >= heights[index]){
            left--;
        }

        while (right <=  heights.length-1 && heights[right] >= heights[index]){
            right++;
        }
        return heights[index]*(right-left-1);
    }
}
