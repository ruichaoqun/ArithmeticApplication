package com.example.arithmeticapplication.leecode.dynamicplanning;

/**
 * @author Rui Chaoqun
 * @date :2020/4/26 8:52
 * description:给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
public class Num279 {
    public static void main(String[] args) {
        Num279 num279 = new Num279();
        System.out.println("args = [" + num279.numSquares1(54) + "]");
    }

    /**
     * 暴力法（超出时间限制）
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int i = (int) Math.sqrt(n);
        int num = Integer.MAX_VALUE;
        for (int j = i; j >=1 ; j--) {
            num = Math.min(num,numSquares(n-j*j)+1);
        }
        return num;
    }


    /**
     * 动态规划，使用dptable解题
     * 方程：numSquares[n] = min(numSquares[n-k]+1)  1<=k<=n
     * @param n
     * @return
     */
    public int numSquares1(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int k = 1;
            while (i - k*k >= 0){
                min = Math.min(min,dp[i-k*k]+1);
                k++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
