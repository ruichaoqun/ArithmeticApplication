package com.example.arithmeticapplication.leecode;

/**
 * @author Rui Chaoqun
 * @description:
 * @date :2019/6/13 9:26
 */
public class Num44 {

    public static void main(String[] args) {
        isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb");
    }




    public static boolean  isMatch(String s, String p) {
        boolean b =  match1(s,p,0,0);
        System.out.println("s = "+b);
        return b;
    }

    public static  boolean match1(String s,String p,int m,int n){
        System.out.println(" m = [" + m + "], n = [" + n + "]");

        //递归出口
        if(m == s.length()){
            if(n == p.length()){
                return true;
            }
            for (int i = n; i < p.length(); i++) {
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        //递归出口
        if(n == p.length() && m < s.length()){
            return false;
        }


        if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '?'){
            return match1(s,p,m+1,n+1);
        }else if(p.charAt(n) == '*'){
            for (int i = n+1; i < p.length(); i++) {
                if(p.charAt(i) != '*'){
                    break;
                }
                n++;
            }
            for (int i = m; i <= s.length(); i++) {
                //递归
                if(match1(s,p,i,n+1)){
                    return true;
                }
            }
            return false;
        }else {
            return false;
        }
    }
}
