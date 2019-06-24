package com.example.arithmeticapplication.leecode;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num48 {
    static int[][] matrix;

    public static void main(String[] args) {
        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
//        matrix = matrix;

        stack(0, matrix.length - 1);
    }

    //递归方法
    private static void stack(int left, int right) {
        if (left >= right) {
            return;
        }
        for (int i = 0; i < right - left; i++) {
            int temp = matrix[left][left + i];
            matrix[left][left + i] = matrix[right - i][left];
            matrix[right - i][left] = matrix[right][right - i];
            matrix[right][right - i] = matrix[left + i][right];
            matrix[left + i][right] = temp;
        }
        stack(left + 1, right - 1);
    }

    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1 - j];
                matrix[i][n-1 - j] = temp;
            }
        }
    }

    public static void rotate2(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;
        while (left < right){
            for (int i = 0; i < right - left; i++) {
                int temp = matrix[left][left + i];
                matrix[left][left + i] = matrix[right - i][left];
                matrix[right - i][left] = matrix[right][right - i];
                matrix[right][right - i] = matrix[left + i][right];
                matrix[left + i][right] = temp;
            }
            left++;
            right--;
        }
    }


}
