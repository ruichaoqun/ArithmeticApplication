package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Rui Chaoqun
 * @description:
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * @date :2019/6/4 15:40
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 */
public class Num36 {
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        isValidSudoku(chars);
    }

    /**
     *
     * @param board
     * @return
     * 暴力法：每行判断，每列判断，每个小数读判断
     */
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> characterSet = new HashSet<>();
        //每一行判断
        for (int i = 0; i < 9; i++) {
            characterSet.clear();
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    if(characterSet.contains(board[i][j])){
                        return false;
                    }
                    characterSet.add(board[i][j]);
                }
            }
        }

        //每一列判断
        for (int i = 0; i < 9; i++) {
            characterSet.clear();
            for (int j = 0; j < 9; j++) {
                if(board[j][i] != '.'){
                    if(characterSet.contains(board[j][i])){
                        return false;
                    }
                    characterSet.add(board[j][i]);
                }
            }
        }

        //每一个3*3判断
        for (int i = 0; i < 9; i++) {
            int x = 3*(i%3);
            int y = 3*(i/3);
            characterSet.clear();
            for (int k = x; k < x+3; k++) {
                for (int l = y; l < y+3; l++) {
                    if(board[k][l] != '.'){
                        if(characterSet.contains(board[k][l])){
                            return false;
                        }
                        characterSet.add(board[k][l]);
                    }
                }
            }
        }

        return true;
    }

    /**
     *
     * @param board
     * @return
     * 使用hashmap，存储数字-坐标，其中坐标放在list中。
     * 当遍历到数字时，判断hashmap中是否有这个字符，如果有，把这个数字的坐标跟已存储的所有这个字符的坐标做匹配
     * 匹配成功直接返回false，匹配失败把这个字符的坐标也放入该字符的list中
     */
    public static boolean isValidSudoku1(char[][] board) {
        Map<Character,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    if(map.containsKey(board[i][j])){
                        List<Integer> list = map.get(board[i][j]);
                        for (int k = 0; k < list.size(); k+=2) {
                            int m = list.get(k);
                            int n = list.get(k+1);
                            if(m == i || n == j || (i/3 == m/3 && j/3 == n/3)){
                                return false;
                            }
                        }
                        list.add(i);
                        list.add(j);
                    }else {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        map.put(board[i][j],list);
                    }
                }
            }
        }
        return true;
    }



}
