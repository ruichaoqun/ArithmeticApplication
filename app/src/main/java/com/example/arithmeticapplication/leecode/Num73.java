package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @date :2019/11/6 19:41
 * description:给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 */
public class Num73 {


    public static void main(String[] args) {
        Num73 num73 = new Num73();
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        num73.setZeroes(matrix);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                builder.append(matrix[i][j]).append(".");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }


    int[][] matrix;
    int m,n;
    public void setZeroes(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        stack(0);
    }

    //递归
    public void stack(int i){
        while (i < m*n){
            int j = i/n;
            int k = i%n;
            if(matrix[j][k] == 0){
                stack(i+1);
                update(j,k);
                break;
            }else{
                i++;
            }
        }
    }

    private void update(int j, int k) {
        for (int i = 0; i < n; i++) {
            matrix[j][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            matrix[i][k] = 0;
        }
    }
}
