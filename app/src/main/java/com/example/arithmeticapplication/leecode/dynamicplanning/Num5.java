package com.example.arithmeticapplication.leecode.dynamicplanning;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int maxLeft = 0,maxRight = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = getMaxChildLength(s,i,i);
            int l2 = getMaxChildLength(s,i,i+1);
            int l = Math.max(l1,l2);
            if(l > (maxRight - maxLeft)){
                maxLeft = i - (l-1)/2;
                maxRight = i + l/2;
            }
        }
        return s.substring(maxLeft,maxRight+1);
    }

    private int getMaxChildLength(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l -1;
    }
}
