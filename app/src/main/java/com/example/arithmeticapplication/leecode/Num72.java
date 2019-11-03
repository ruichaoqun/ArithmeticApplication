package com.example.arithmeticapplication.leecode;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Num72 {
    static int[][] temp;
    static int num;
    public static void main(String[] args) {
        System.out.println(minDistance("intention","execution"));
        System.out.println("args = [" + num + "]");
    }

    public static int minDistance(String word1, String word2) {
        temp = new int[word1.length()][word2.length()];
        return findMInDistance(word1.length()-1,word2.length()-1,word1,word2);
    }

    //最小编辑距离算法
    public static int findMInDistance(int i,int j,String word1,String word2){
        //如果i走到头了，j还没走完。剩下的步骤就全是添加一个字符了
        if(i == -1){
            return j+1;
        }

        //如果i没走到头，j走完了，剩下的步骤就全是删除了
        if(j == -1){
            return i+1;
        }

        if(temp[i][j] != 0){
            return temp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            //如果两个字符相同，不做任何操作，i和j都向前移动一位。距离也没有增加
            num ++;
            temp[i][j] = findMInDistance(i-1,j-1,word1,word2);
            return temp[i][j];
        }else{
            //如果两个字符不同，这是会有三种情况，添加一个字符，删除一个字符，或者替换一个字符
            //使用递归去确定到底哪一步的距离是最小的
            //min{
            //  Math.min(
            //  findMInDistance(i-1,j-1,word1,word2)+1  这是替换后的距离  替换字符，i，j都向前移动一位
            //  findMInDistance(i-1,j,word1,word2)+1     这是删除字符操作的，删除后i向前一位，j不动
            //  findMInDistance(i,j-1,word1,word2)+1    这是添加字符操作的，添加后i不动，j向前一位
            // }
            num ++;
            temp[i][j] = Math.min(Math.min(findMInDistance(i-1,j-1,word1,word2)+1,findMInDistance(i-1,j,word1,word2)+1),findMInDistance(i,j-1,word1,word2)+1);
            return temp[i][j];
        }
    }
}
