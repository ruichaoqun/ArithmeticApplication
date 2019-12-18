package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @date :2019/11/7 9:53
 * description:编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num74 {

    //二分法求值 矩阵下标转换成数组下标
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int  m = matrix.length;
        int n = matrix[0].length;
        int left = 0,right = m*n-1;
        while (left <= right){
            int mid = (left + right)/2;
            int j = mid/n;
            int k = mid%n;
            if(matrix[j][k] == target){
                return true;
            }else if(matrix[j][k] < target){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return false;
    }
}
