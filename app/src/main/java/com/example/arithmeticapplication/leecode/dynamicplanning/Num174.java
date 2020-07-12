package com.example.arithmeticapplication.leecode.dynamicplanning;

/**
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 *  
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * <p>
 * -2 (K)	-3	    3
 * -5	    -10	    1
 * 10	    30	    -5 (P)
 *  
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * <p>
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num174 {
    /**
     * 从右下到左上的动态规划
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        return Math.max(0, stack(dungeon, 0, 0) + 1);
    }

    private int stack(int[][] dungeon, int row, int col) {
        if (row == dungeon.length - 1 && col == dungeon[0].length - 1) {
            return dungeon[row][col] < 0 ? -dungeon[row][col] : 0;
        } else if (row == dungeon.length - 1) {
            return Math.max(0, stack(dungeon, row, col + 1) - dungeon[row][col]);
        } else if (col == dungeon[0].length - 1) {
            return Math.max(0, stack(dungeon, row + 1, col) - dungeon[row][col]);
        }
        return Math.max(0, Math.min(stack(dungeon, row + 1, col), stack(dungeon, row, col + 1)) - dungeon[row][col]);
    }

    public int calculateMinimumHP1(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    dp[i][j] = dungeon[i][j] < 0 ? -dungeon[i][j] : 0;
                } else if (i == row - 1) {
                    dp[i][j] = Math.max(0, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == col - 1) {
                    dp[i][j] = Math.max(0, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(0, Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0] + 1;
    }
}
