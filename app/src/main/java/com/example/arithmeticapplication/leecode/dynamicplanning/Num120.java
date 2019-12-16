package com.example.arithmeticapplication.leecode.dynamicplanning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/12/11 17:31
 * description:给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分
 *
 */
public class Num120 {

    public static void main(String[] args) {
        Num120 num120 = new Num120();
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        listList.add(list);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        listList.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        listList.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        listList.add(list4);
        System.out.println("args = [" + num120.minimumTotal2(listList) + "]");

    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int[] dp = new int[triangle.size()];
        int[] temp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if(j == 0){
                    temp[j] = dp[j] + list.get(j);
                }else if(j == list.size()-1){
                    temp[j] = dp[j-1] + list.get(j);
                }else{
                    temp[j] = Math.min(dp[j-1],dp[j]) + list.get(j);
                }
            }
            int[] t = temp;
            temp = dp;
            dp = t;
        }

        for (int i = 0; i < dp.length; i++) {
            if(min > dp[i]){
                min = dp[i];
            }
        }
        return min;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if(j == 0){
                    if(i == 0){
                        dp[0][0] = list.get(j);
                    }else{
                        dp[i][j] = dp[i-1][j] + list.get(j);
                    }
                }else if(j == list.size()-1){
                    dp[i][j] = dp[i-1][j-1] + list.get(j);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + list.get(j);
                }
            }
        }

        for (int i = 0; i < dp[dp.length-1].length; i++) {
            if(min > dp[dp.length-1][i]){
                min = dp[dp.length-1][i];
            }
        }
        return min;
    }


    public int minimumTotal3(List<List<Integer>> triangle) {
        return stack(triangle,0,0);
    }

    //递归
    public int stack(List<List<Integer>> triangle,int row,int col) {
        if(row == triangle.size() -1){
            return triangle.get(row).get(col);
        }
        return Math.min(stack(triangle,row+1,col),stack(triangle,row+1,col+1)) + triangle.get(row).get(col);
    }
}
