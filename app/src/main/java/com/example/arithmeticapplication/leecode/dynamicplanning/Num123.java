package com.example.arithmeticapplication.leecode.dynamicplanning;

/**
 * @author Rui Chaoqun
 * @date :2019/12/13 15:54
 * description:给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 *
 */
public class Num123 {


    public static void main(String[] args) {
        Num123 num123 = new Num123();
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println("args = [" + num123.maxProfit2(prices) + "]");
    }



    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        int temp1 = prices[0];
        int temp2 = prices[0];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                profit = prices[j] - prices[i];
                if(profit > 0){
                    for (int k = j+1; k < prices.length; k++) {
                        for (int l = k+1; l < prices.length; l++) {
                            if(prices[l] - prices[k] > 0 && maxProfit < profit+prices[l] - prices[k]){
                                maxProfit = profit+prices[l] - prices[k];
                            }
                        }
                    }
                }
                if(maxProfit < profit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int maxk = 2;
        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = 0; k <= maxk; k++) {
                if(i == 0){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                if(k == 0){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = Math.max(dp[i-1][k][1], - prices[i]);
                }else{
                    dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k-1][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k][0] - prices[i]);
                }
            }
        }
        return dp[prices.length-1][2][0];
    }

}
