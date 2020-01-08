package com.example.arithmeticapplication.leecode.dynamicplanning;

import android.content.Intent;
import android.text.TextUtils;

/**
 * @author Rui Chaoqun
 * @date :2019/12/27 14:39
 * description:给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回符合要求的最少分割次数。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 */
public class Num132 {

    public static void main(String[] args) {
        Num132 num132 = new Num132();
        System.out.println("args = [" + num132.minCut("eegiicgaeadbcfa") + "]");
    }

    public int minCut(String s) {
        int min = Integer.MAX_VALUE;;
        return minCut(s,0,s.length()-1);
    }

    public int minCut(String s,int left,int right){
        if(isPalindrome(s,left,right)){
            return 0;
        }else{
            int min = Integer.MAX_VALUE;
            for (int i = left; i < right; i++) {
                min = Math.min(min,1+minCut(s,left,i)+minCut(s,i+1,right));
            }
            return min;
        }
    }

    public boolean isPalindrome(String s,int left,int right){
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right--;
        }
        return true;
    }
}
