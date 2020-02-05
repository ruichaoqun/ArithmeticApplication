package com.example.arithmeticapplication.leecode.recall;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num79 {


    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Num79 num79 = new Num79();
        System.out.printf(num79.exist(board,"ABCB")+"");
    }

    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == c){
                    board[i][j] = '.';
                    if(stack(board,word,i,j,1)){
                        return true;
                    }else{
                        board[i][j] = c;
                    }
                }
            }
        }
        return false;
    }

    public boolean stack(char[][] board,String word,int row,int col,int index){
        if(index >= word.length()){
            return true;
        }
        char c = word.charAt(index);
        if(row != 0 && board[row-1][col] == c){
            board[row-1][col] = '.';
            if(!stack(board,word,row-1,col,index+1)){
                board[row-1][col] = c;
            }else{
                return true;
            }
        }

        if(col != board[0].length-1 && board[row][col+1] == c){
            board[row][col+1] = '.';
            if(!stack(board,word,row,col+1,index+1)){
                board[row][col+1] = c;
            }else{
                return true;
            }
        }

        if(col != 0 && board[row][col-1] == c){
            board[row][col-1] = '.';
            if(!stack(board,word,row,col-1,index+1)){
                board[row][col-1] = c;
            }else{
                return true;
            }
        }

        if(row != board.length-1 && board[row+1][col] == c){
            board[row+1][col] = '.';
            if(!stack(board,word,row+1,col,index+1)){
                board[row+1][col] = c;
            }else{
                return true;
            }
        }
        return false;
    }
}
