package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @date :2019/11/7 11:06
 * description:给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Num76 {
    public static void main(String[] args) {
        Num76 num76 = new Num76();
        String s = num76.minWindow("ADOBECODEBANC","ABC");
        System.out.println("args = [" + s + "]");
    }

    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        String minString = "";
        while (r<s.length()){
            if(containString(s,t,l,r)){
                if(minString == ""){
                    minString = s.substring(l,r+1);
                }else if(minString.length() > (r-l+1)){
                    minString = s.substring(l,r+1);
                }
                l++;
            }else{
                r++;
            }
        }
        return minString;
    }


    private boolean containString(String s,String t ,int l,int r){
        String temp = s.substring(l,r+1);
        for (int i = 0; i < t.length(); i++) {
            if(!temp.contains(t.charAt(i)+"")){
                return false;
            }
        }
        return true;
    }
}
