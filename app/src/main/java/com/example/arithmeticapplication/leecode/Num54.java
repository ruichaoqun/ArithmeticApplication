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
        List<Integer> list = spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9,},{10,11,12}});
        System.out.println("args = [" + list.size() + "]");
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int level = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        while (level <= column/2){
            if(level == column-level-1){
                list.add(matrix[level][level]);
            }else{
                for (int i = level; i < column-level-1; i++) {
                    list.add(matrix[level][i]);
                }
            }
            for (int i = level; i < row-level-1; i++) {
                list.add(matrix[i][column-level-1]);
            }

            for (int i = column - level -1; i > level; i--) {
                list.add(matrix[row-level-1][i]);
            }

            for (int i = row - level - 1; i > level ; i--) {
                list.add(matrix[i][level]);
            }
            level++;
        }
        return list;
    }
}
