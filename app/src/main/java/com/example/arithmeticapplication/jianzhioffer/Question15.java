package com.example.arithmeticapplication.jianzhioffer;

public class Question15 {
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(Question15.hammingWeight(-3)+"");
    }
}
