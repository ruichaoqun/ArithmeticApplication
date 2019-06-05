package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Rui Chaoqun
 * @description:
 * @date :2019/6/4 17:52
 */
public class Num37 {


    public static void main(String[] args) {
        Num37 num37 = new Num37();
        num37.solveSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}});
        System.out.println("args = [" + args + "]");
//        solveSudoku(board);
    }

    char[][] board;

    int[][] row = new int[9][10];
    int[][] column = new int[9][10];
    int[][] sudoku = new int[9][10];
    private boolean finished;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    int num = Character.getNumericValue(board[i][j]);
                    row[i][num] = 1;
                    column[j][num] = 1;
                    sudoku[3*(i/3)+(j/3)][num] = 1;
                }
            }
        }
        placeNumber(0,0);
    }

    private void placeNumber(int r, int c) {
        // 找寻空位置
        while (board[r][c] != '.') {
            if (++c >= 9) {
                r++;
                c = 0;
            }
            if (r >= 9) {
                return;
            }
        }
        if(board[r][c] == '.'){
            for (int i = 1; i <10; i++) {
                if(row[r][i] + column[c][i] + sudoku[3*(r/3)+(c/3)][i] == 0){
                    row[r][i] = 1;
                    column[c][i] = 1;
                    sudoku[3*(r/3)+(c/3)][i] = 1;
                    board[r][c] = (char) (i+'0');
                    //递归
                    placeNextNumber(r,c);
                    if(!finished){
                        //回溯
                        row[r][i] = 0;
                        column[c][i] = 0;
                        sudoku[3*(r/3)+(c/3)][i] = 0;
                        board[r][c] = '.';
                    }
                }
            }
        }else{
            placeNextNumber(r,c);
        }
    }

    private void placeNextNumber(int r, int c) {
        if(r == 8 && c == 8){
            finished = true;
            return;
        }
        if(c == 8){
            placeNumber(r+1,0);
        }else{
            placeNumber(r,c+1);
        }
    }
}
