package com.example.arithmeticapplication.leecode;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num200 {
    public static void main(String[] args) {
        char[][] chars = new char[][]{{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},{'0','0','0','1','1'}};
        Num200 num200 = new Num200();
        int i = num200.numIslands(chars);
        System.out.printf(""+i);
    }

    public int numIslands(char[][] grid) {
        if(grid == null ||grid.length == 0 ){
            return 0;
        }
        int index = 2;
        int[][] arr = new int[grid.length+2][grid[0].length+2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(i == 0 || i == arr.length-1 || j == 0 || j == arr[i].length - 1){
                    arr[i][j] = 0;
                }else{
                    if(grid[i-1][j-1] == '0'){
                        arr[i][j] = 0;
                    }else{
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 1; i < arr.length-1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                if(arr[i][j] == 1){
                    trans(arr,i,j,index);
                    index++;
                }
            }
        }
        return index-2;
    }

    public void trans(int[][] arr,int i,int j,int count){
        if(arr[i][j] == 1){
            arr[i][j] = count;
            trans(arr,i-1,j,count);
            trans(arr,i,j-1,count);
            trans(arr,i+1,j,count);
            trans(arr,i,j+1,count);
        }
    }
}
