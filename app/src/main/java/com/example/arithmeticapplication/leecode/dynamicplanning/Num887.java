package com.example.arithmeticapplication.leecode.dynamicplanning;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 *
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 *
 * 输入：K = 3, N = 14
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num887 {

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for (int i = 1; i < N + 1; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i < K+1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i < K+1; i++) {
            for (int j = 2; j < N+1; j++) {
                if(dp[i][j-1] <= dp[i-1][0]){
                    dp[i][j] = dp[i-1][0]+1;
                }else if(dp[i][0] >= dp[i-1][j-1]){
                    dp[i][j] = dp[i][0]+1;
                }else {
                    //二分查找
                    int left = 1,right = j;
                    while (left < right){
                        int mid = (right+left)/2;
                        if(dp[i][j-mid] == dp[i-1][mid-1]){
                            left = right = mid;
                            break;
                        }else if(dp[i][j-mid] > dp[i-1][mid-1]){
                            left = mid+1;
                        }else{
                            right = mid-1;
                        }
                    }
                    dp[i][j] = 1+Math.min(Math.max(dp[i][j-left],dp[i-1][left-1]),Math.max(dp[i][j-right],dp[i-1][right-1]));
                }
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        System.out.print(new Num887().superEggDrop(3,14));
    }
}
