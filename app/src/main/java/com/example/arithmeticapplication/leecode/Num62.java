package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @description:一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * @date :2019/6/14 8:52
 */
public class Num62 {
    public static void main(String[] args) {
        int i = uniquePaths(51,9);
        System.out.println("i = [" + i + "]");
    }

    //递归算法
    public static int uniquePaths(int m, int n) {
        return path1(m,n,1,1);
    }

    public static int path1(int m,int n,int k,int l){
        if(k == m || l == n){
            return 1;
        }
        return path1(m,n,k+1,l) + path1(m,n,k,l+1);
    }

    //动态规划，[i][j]位置的路径是[i-1][j] 和 [i][j-1]的和，注意处理i=1或者j=1就可以了
    public static int uniquePaths1(int m, int n) {
        int[] arr = new int[m+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i == 1 || j == 1){
                    arr[j] = 1;
                }else{
                    arr[j] = arr[j] + arr[j-1];
                }
            }
        }
        return arr[m];
    }
}
