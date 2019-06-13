package com.example.arithmeticapplication.leecode;

import java.util.Arrays;

/**
 * @author Rui Chaoqun
 * @description:给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @date :2019/6/6 17:13
 */
public class Num43 {

    public static void main(String[] args) {
        System.out.println("multiply = [" + multiply("664651","6422424554554") + "]");
    }

    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] arr = new int[len1+len2];
        if(num1.equals("0")  || num2.equals("0") ){
            return "0";
        }
        for (int i = num2.length()-1; i >= 0; i--) {
            int m = num2.charAt(i) - '0';
            if(m == 0){
                continue;
            }
            for (int j = num1.length()-1; j >= 0; j--) {
                int n = num1.charAt(j) - '0';
                int count = m*n;
                int k = num2.length()-1-i+num1.length()-1-j;
                for (int l = k; l < arr.length; l++) {
                    int t = (arr[l] + count)/10;
                    arr[l] = (arr[l] + count)%10;
                    count = t;
                    if(count == 0){
                        break;
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        boolean start = false;
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i] == 0 && !start){
                continue;
            }
            start = true;
            builder.append(arr[i]);
        }
        return builder.toString();
    }
}
