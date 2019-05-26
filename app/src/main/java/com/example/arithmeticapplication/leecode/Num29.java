package com.example.arithmeticapplication.leecode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 */
public class Num29 {

    public static void main(String[] args){
        divide(Integer.MIN_VALUE,-1);
    }

    public static int divide(int dividend, int divisor) {
        if(dividend == 0 )
            return 0;
        int result = 0;
        int sign;
        if((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)){
            sign = 1;
        }else{
            sign = -1;
        }
        if(dividend == Integer.MIN_VALUE){
            if(divisor == 0){
                return dividend;
            }

            if(divisor == -1){
                return Integer.MAX_VALUE;
            }

            if(divisor == -2){
                return 1<<30;
            }

            if(divisor == 2){
                return -1<<30;
            }

            dividend = Integer.MAX_VALUE;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if(dividend < divisor)
            return 0;
        int i = 0;

        while (divisor << 1 <= dividend && divisor  <= Math.pow(2,30) - 1){
            i++;
            divisor = divisor << 1;
        }

        for (int j = 0; j <= i; j++) {
            result = result << 1;
            if(dividend >= divisor){
                dividend = dividend - divisor;
                result ++;
            }
            divisor = divisor >> 1;
        }
        return result * sign;
    }
}
