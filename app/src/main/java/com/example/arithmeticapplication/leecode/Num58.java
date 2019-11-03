package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @date :2019/6/24 19:48
 * description:给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 */
public class Num58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s == null || s.length() == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                count = 0;
            }else{
                count++;
            }
        }
        return count;
    }
}
