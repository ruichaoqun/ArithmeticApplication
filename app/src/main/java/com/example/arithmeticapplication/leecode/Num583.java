package com.example.arithmeticapplication.leecode;

/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 示例 1:
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 * 说明:
 *
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num583 {
    static String word1;
    static String word2;
    static int[][] temp;

    public static void main(String[] args) {
        System.out.println(minDistance("sea","eat"));
    }

    public static int minDistance(String word1, String word2) {
        Num583.word1 = word1;
        Num583.word2 = word2;
        temp = new int[word1.length()][word2.length()];
        return findMinDistance(word1.length()-1,word2.length()-1);
    }

    //最小编辑距离算法
    public static int findMinDistance(int i,int j){
        if(i == -1){
            return j+1;
        }

        if(j == -1){
            return i+1;
        }
        if(temp[i][j] != 0){
            return temp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            temp[i][j] = findMinDistance(i-1,j-1);
            return temp[i][j];
        }else{
            temp[i][j] = Math.min(findMinDistance(i-1,j)+1,findMinDistance(i,j-1)+1);
            return temp[i][j];
        }
    }
}
