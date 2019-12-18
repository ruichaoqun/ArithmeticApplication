package com.example.arithmeticapplication.leecode.dynamicplanning;

/**
 * @author Rui Chaoqun
 * @date :2019/12/3 15:28
 * description:
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 */
public class Num97 {

    public static void main(String[] args) {
        Num97 num97 = new Num97();
        boolean b = num97.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        System.out.println("args = [" + b + "]");
    }


    public boolean isInterleave(int m, int n, int p, String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())) {
            return false;
        }
        for (int i = p; i < s3.length(); i++) {
            char charS3 = s3.charAt(i);
            if (m < s1.length() && n < s2.length()) {
                if (s1.charAt(m) == charS3 && s2.charAt(n) == charS3) {
                    if (isInterleave(m + 1, n, i + 1, s1, s2, s3)) {
                        return true;
                    } else if (isInterleave(m, n + 1, i + 1, s1, s2, s3)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            if (m < s1.length() && s1.charAt(m) == charS3) {
                m++;
            } else if (n < s2.length() && s2.charAt(n) == charS3) {
                n++;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] arr = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = true;
                } else if (i == 0) {
                    arr[i][j] = arr[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    arr[i][j] = arr[i - 1][+j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    arr[i][j] = (arr[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (arr[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return arr[s1.length()][s2.length()];
    }

}
