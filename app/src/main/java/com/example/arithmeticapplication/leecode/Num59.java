package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @date :2019/7/3 21:08
 * description:给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Num59 {

    public static void main(String[] args) {
        int[][] res = generateMatrix(5);
        System.out.println("args = [" + args + "]");
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int row = 0;
        while (row < n / 2) {
            for (int i = row; i < n - row - 1; i++) {
                int k = (n - row * 2 - 1);
                result[row][i] = num;
                result[i][n - row - 1] = result[row][i] + k;
                result[n-row-1][n-i-1] = num + 2*k;
                result[n-i-1][row] = num + 3*k;
                num++;
            }
            num = result[row+1][row] + 1;
            row++;
        }
        if(n%2 != 0){
            result[n/2][n/2] = n*n;
        }
        return result;
    }
}
