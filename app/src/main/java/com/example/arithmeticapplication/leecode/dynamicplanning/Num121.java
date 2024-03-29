package com.example.arithmeticapplication.leecode.dynamicplanning;

/**
 * @author Rui Chaoqun
 * @date :2019/9/24 19:33
 * description:给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Num121 {

    public static void main(String[] args) {
        System.out.printf(""+new Num121().maxProfit1(new int[]{7,1,5,3,6,4}));
    }

    /**
     * dp[k,0] 定义为第k天的最大利润，
     * dp[k,0] = max(dp[k-1,0],dp[k-1,1] + p[k])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int dpk0 = 0;
        int dpk1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dpk0 = Math.max(dpk0,dpk1+prices[i]);
            dpk1 = Math.max(dpk1,-prices[i]);
        }
        return dpk0;
    }

    public int maxProfit1(int[] prices) {
        int profit = 0;
        int minp = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(minp > prices[i]){
                minp = prices[i];
            }
            profit = Math.max(profit,prices[i] - minp);
        }
        return profit;
    }
}
