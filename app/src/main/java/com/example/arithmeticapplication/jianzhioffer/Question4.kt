package com.example.arithmeticapplication.jianzhioffer

/**
 *@author ruichaoqun
 *创建日期：2021/11/23 1:00
 *描述：Question4
 *在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 

示例:

现有矩阵 matrix 如下：

[
[1,   4,  7, 11, 15],
[2,   5,  8, 12, 19],
[3,   6,  9, 16, 22],
[10, 13, 14, 17, 24],
[18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

 

限制：

0 <= n <= 1000

0 <= m <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question4 {
    companion object{
        fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
            if(matrix.size == 0)
                return false
            return findNumberIn2DArrayDepth(matrix,target,0,matrix.size-1,0,matrix[0].size-1)
        }

        fun findNumberIn2DArrayDepth(matrix: Array<IntArray>, target: Int,colStart:Int,colEnd:Int,rowStart:Int,rowEnd:Int): Boolean {
            var col = (colEnd+colStart)/2
            var row = (rowStart + rowEnd)/2
            if(colStart > colEnd || rowStart > rowEnd || colStart < 0 || colStart >= matrix.size || rowStart < 0 || rowEnd >= matrix[0].size){
                return false;
            }
            if(matrix[col][row] == target){
                return true
            }else if(matrix[col][row] < target){
                return findNumberIn2DArrayDepth(matrix,target,colStart,col,row+1,rowEnd)||
                        findNumberIn2DArrayDepth(matrix,target,col+1,colEnd,rowStart,row)||
                        findNumberIn2DArrayDepth(matrix,target,col+1,colEnd,row+1,rowEnd)
            }else{
                return findNumberIn2DArrayDepth(matrix,target,colStart,col-1,row,rowEnd)||
                        findNumberIn2DArrayDepth(matrix,target,col,colEnd,rowStart,row-1)||
                        findNumberIn2DArrayDepth(matrix,target,colStart,col-1,rowStart,row-1)
            }
        }
    }
}


fun main() {
    val arr = arrayOf(intArrayOf(1,4,7,11,15), intArrayOf(2,5,8,12,19), intArrayOf(3,   6,  9, 16, 22), intArrayOf(10, 13, 14, 17, 24), intArrayOf(18, 21, 23, 26, 30))
    println("${Question4.findNumberIn2DArray(arr,20)}")

}