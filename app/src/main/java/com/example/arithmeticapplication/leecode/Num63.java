package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @date :2019/8/1 16:17
 * description:一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Num63 {

    public static void main(String[] args) {
        Num63 num63 = new Num63();
        System.out.println("args = [" + num63.uniquePathsWithObstacles1(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}) + "]");
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return stack(0, 0, obstacleGrid);
    }

    //递归算法
    public int stack(int m, int n, int[][] obstacleGrid) {
        if (m >= obstacleGrid.length || n >= obstacleGrid[0].length || obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (m == obstacleGrid.length - 1 && n == obstacleGrid[0].length - 1) {
            return 1;
        }
        return stack(m, n + 1, obstacleGrid) + stack(m + 1, n, obstacleGrid);
    }

    //动态规划算法
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length - 1;//行数
        int n = obstacleGrid[0].length - 1;//列数
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                }else if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                } else if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }
        return obstacleGrid[m][n];
    }
}
