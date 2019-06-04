package com.example.arithmeticapplication.leecode;

import java.util.Stack;

/**
 * @author Rui Chaoqun
 * @description:给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * @date :2019/5/28 14:05
 */
public class Num32 {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] arr = new int[s.length()];
        //从1开始遍历
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    //如果最后两个字符正好匹配（），以i结尾的最大长度就是2+arr[i-2]的长度，注意i-2有可能越界
                    arr[i] = (i>=2?arr[i-2]:0)+2;
                    max = Math.max(arr[i],max);
                }else if(i - arr[i-1] > 0 && s.charAt(i-arr[i-1]-1) == '('){
                    //如果i-1是一个）字符，且i-arr[i-1]-1是一个‘（’
                    arr[i] = arr[i-1] + 2 + (i-arr[i-1]-2>0?arr[i-arr[i-1]-2]:0);
                    max = Math.max(arr[i],max);
                }
            }
        }
        return max;
    }
}
