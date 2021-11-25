package com.example.arithmeticapplication.jianzhioffer

/**
 *@author ruichaoqun
 *创建日期：2021/11/23 16:06
 *描述：Question12
 *给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。



 

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
 

提示：

1 <= board.length <= 200
1 <= board[i].length <= 200
board 和 word 仅由大小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question12 {
    companion object{
        fun exist(board: Array<CharArray>, word: String): Boolean {
            var char = word[0]
            for (col in board.indices){
                for (row in board[col].indices){
                    if(board[col][row] == char){
                        if(check(board,word,col,row,0)){
                            return true
                        }
                    }
                }
            }
            return false
        }

        fun check(board: Array<CharArray>, word: String, col: Int, row: Int,index:Int):Boolean{
            if(index == word.length){
                return true
            }
            if(col == board.size || col < 0 || row == board[0].size || row < 0){
                return false
            }
            var char = word[index]
            if(char != board[col][row]){
                return false
            }
            board[col][row] = '0'
            if(check(board,word,col+1,row,index+1)
                    || check(board,word,col-1,row,index+1)
                    || check(board,word,col,row+1,index+1)
                    || check(board,word,col,row-1,index+1)){
                return true
            }else{
                board[col][row] = char
                return false
            }
        }
    }
}

fun main() {
    var board = arrayOf(charArrayOf('A','B','C','E'), charArrayOf('S','F','C','S'), charArrayOf('A','D','E','E'))
    println(Question12.exist(board,"ABCCED"))
}