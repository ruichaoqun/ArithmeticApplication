package com.example.arithmeticapplication.leecode.dynamicplanning;

public class Num122 {

    public static void main(String[] args) {
        System.out.printf(""+new Num122().maxProfit1(new int[]{1,2,3,4,5}));
    }

    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int profit = 0;
        int pre = 0;
        int p = 1;
        while (p < prices.length){
            if(prices[pre] < prices[p]){
                while (p < prices.length && prices[p] - prices[p-1] > 0 ){
                    p++;
                }
                profit += prices[p-1] - prices[pre];
                pre = p;
                p++;
            }else{
                pre++;
                p++;
            }
        }
        return profit;
    }


    /**
     * dp[i,0] 表示第i天手上没有股票的最大利润
     * dp[i,1] 表示第i天手上有股票的最大利润
     * dp[i,0] = max(dp[i-1,0],dp[i-1,1]+price[i])  第i天没有股票就是  第i-1天没有股票  和  第i-1天有股票 + 第i天的股票  的大的那一个
     * dp[i,1] = max(dp[i-1,1],dp[i-1,0]-price[i])  第i天有股票就是  第i-1天有股票  和  第i-1天没有股票 - 第i天的股票  的大的那一个
     * 最后求的结果就是dp[n,0]
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int m = 0;
        int n = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int k = m;
            int t = n;
            m = Math.max(k,t+prices[i]);
            n = Math.max(t,k-prices[i]);
        }
        return m;
    }
}
