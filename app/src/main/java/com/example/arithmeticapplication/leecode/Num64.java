package com.example.arithmeticapplication.leecode;

import java.util.Arrays;

/**
 * @author Rui Chaoqun
 * @date :2019/7/2 10:57
 * description:给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 */
public class Num64 {

    public static void main(String[] args) {
        Num64 num64 = new Num64();
        int s = num64.minPathSum(new int[][]{{1,2,5},{3,2,1}});
        System.out.println("args = [" + s + "]");
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = -1;
            }
        }
        caculateXY(m-1,n-1,grid,temp);
        return temp[m-1][n-1];
    }

    //递归，要求出第m行，n列的数字的最小路径和，先求出m-1，n以及m,n-1这两个的最小路径和（注意边界情况），
    // 求出后再比较大小，小的加上m,n的数字就是m,n的最小路径和
    public void caculateXY(int x,int y,int[][] grid,int[][] temp){
        if(temp[x][y] != -1){
            return;
        }
        if(x > 0){
            caculateXY(x-1,y,grid,temp);
        }
        if(y > 0){
            caculateXY(x,y-1,grid,temp);
        }
        if(x == 0 && y == 0){
            temp[0][0] = grid[0][0];
            return;
        }
        if(x == 0 && y>0){
            temp[x][y] = grid[x][y] + temp[x][y-1];
        }else if(y == 0 && x>0){
            temp[x][y] = grid[x][y] + temp[x-1][y];
        }else{
            temp[x][y] = Math.min(temp[x-1][y],temp[x][y-1]) + grid[x][y];
        }
    }
}
