package com.example.arithmeticapplication.leecode.mianshiti;

import java.util.HashMap;
import java.util.Map;

/**
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 *
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 *
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/re-space-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int respace(String[] dictionary, String sentence) {
        if(sentence.length() == 0){
            return 0;
        }
        if(dictionary.length == 0){
            return sentence.length();
        }
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < dictionary.length; i++) {
            map.put(dictionary[i],dictionary[i]);
        }
        int[] dp = new int[sentence.length()];
        for (int i = 0; i < sentence.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                String s = sentence.substring(j,i+1);
                if(map.containsKey(s)){
                    if(j == 0){
                        min = Math.min(0,min);
                    }else{
                        min = Math.min(min,dp[j-1]);
                    }
                }else{
                    if(j == 0){
                        min = Math.min(min,i-j+1);
                    }else{
                        min = Math.min(min,dp[j-1]+i-j+1);
                    }
                }
            }
            dp[i] = min;
        }
        return dp[sentence.length()-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.respace(new String[]{"looked","just","like","her","brother"},"jesslookedjustliketimherbrother");
        System.out.print(result);
    }
}
