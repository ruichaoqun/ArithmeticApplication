package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @date :2019/9/17 11:17
 * description:假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class Num70 {

    public static void main(String[] args) {
        Num70 num70 = new Num70();
        int s = num70.climbStairs(40);
        System.out.println("args = [" + s + "]");
    }

    public int climbStairs(int n) {
        return stack(n);
    }

    //暴力递归
    public int stack(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return stack(n-1)+stack(n-2);
    }

    //动态规划，第i个台阶的走法是第i-1台阶走法+第i-2台阶走法
    public int climbStairs2(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if(i == 0){
                arr[i] = 1;
            } else if(i == 1){
                arr[i] = 2;
            }else {
              arr[i] = arr[i-1]+arr[i-2];
            }
        }
        return arr[n-1];
    }
}
