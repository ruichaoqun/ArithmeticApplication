package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/6/27 21:54
 * description:给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class Num54 {

    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][]{{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}});
        System.out.println("args = [" + list.size() + "]");
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0){
            return list;
        }
        int level = 0;
        int row = matrix.length;//行数
        int column = matrix[0].length;//列数
        int left = 0,right = column-1;
        while (left <= right && left <= row - left - 1){
            if(left == right){
                for (int i = left; i < row-left; i++) {
                    list.add(matrix[i][left]);
                }
                left++;
                right--;
                break;
            }

            if(left == row-left - 1){
                for (int i = left; i <= right; i++) {
                    list.add(matrix[left][i]);
                }
                left++;
                right--;
                break;
            }

            for (int i = left; i < right; i++) {
                list.add(matrix[left][i]);
            }

            for (int i = left; i < row-left-1; i++) {
                list.add(matrix[i][right]);
            }

            for (int i = right; i > left; i--) {
                list.add(matrix[row-left-1][i]);
            }

            for (int i = row-left-1; i > left; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            right--;
        }
        return list;
    }
}
