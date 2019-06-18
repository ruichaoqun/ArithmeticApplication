package com.example.arithmeticapplication.leecode;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @description: N皇后问题
 * @date :2019/6/17 17:48
 */
public class Num51 {
    //结果
    private List<List<String>>  lists;
    //记录当前queen的位置
    private int[] queens;
    private int n;

    public static void main(String[] args) {
        Num51 num51 = new Num51();
        num51.solveNQueens(8);
        System.out.println("args = [" + num51.lists.size() + "]");
    }

    public List<List<String>> solveNQueens(int n) {
        lists = new ArrayList<>();
        queens = new int[n];
        for (int i = 0; i < n; i++) {
            queens[i] = -1;
        }
        this.n = n;
        stack(0);
        return lists;
    }

    public void stack(int row){
        //判断第row个皇后
        for (int column = 0; column < n; column++) {
            //第row行第column列可以放置皇后
            if(isMatch(row,column)){
                //放置皇后
                queens[row] = column;
                //如果是最后一行了，成功
                if(row + 1 == n){
                    addQueen();
                }else{
                    //不是最后一行，递归下一行
                    stack(row + 1);
                }
                //回溯，其实没必要
                queens[row] = -1;
            }
        }
    }

    public void addQueen(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if(j != queens[i]){
                    builder.append('.');
                }else{
                    builder.append('Q');
                }
            }
            list.add(builder.toString());
        }
        lists.add(list);
    }

    public boolean isMatch(int row,int column){
        for (int i = 0; i < row; i++) {
            //当前位置的行、列、左右对角线都没有皇后
            if(column == queens[i] || (row + column) == i+queens[i] || column - row == queens[i] - i){
                return false;
            }
        }
        return true;
    }
}
