package com.example.arithmeticapplication.leecode.dynamicplanning;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    max = Math.max(dp[j]+1,max);
                }
            }
            dp[i] = max;
            result = Math.max(result,max);
        }
        return result;
    }


    public static void main(String[] args) {
        Num354 num354 = new Num354();
        System.out.print(num354.maxEnvelopes(new int[][]{{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}}));
    }
}
