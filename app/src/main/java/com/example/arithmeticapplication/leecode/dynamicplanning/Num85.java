package com.example.arithmeticapplication.leecode.dynamicplanning;

import java.util.Arrays;

/**
 * @author Rui Chaoqun
 * @date :2019/9/24 19:43
 * description:给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        int max = 0;
        for (int i = 0; i < m; i++) {
            int t_left = 0;
            int t_right = n;
            //更新行
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
            //更新左
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    left[j] = Math.max(left[j],t_left);
                else{
                    left[j] = 0;
                    t_left = j+1;
                }
            }
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') right[j] = Math.min(right[j], t_right);
                else {right[j] = n; t_right = j;}
            }
            // update area
            for(int j = 0; j < n; j++) {
                max = Math.max(max, (right[j] - left[j]) * height[j]);
            }

        }
        return max;
    }
}
