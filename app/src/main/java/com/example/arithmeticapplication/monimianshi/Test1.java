package com.example.arithmeticapplication.monimianshi;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int sum = 0;
        int length = s.length();
        int i = 0;
        while (i < length){
            char c = s.charAt(i);
            if(c == 'M'){
                sum+=1000;
            }else if(c == 'D'){
                sum+=500;
            }else if(c == 'C'){
                if(i < length-1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                    if(s.charAt(i+1) == 'D'){
                        sum+=400;
                    }else{
                        sum+=900;
                    }
                    i++;
                }else {
                    sum+=100;
                }
            }else if(c == 'L'){
                sum+=50;
            }else if(c=='X'){
                if(i < length-1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                    if(s.charAt(i+1) == 'L'){
                        sum+=40;
                    }else{
                        sum+=90;
                    }
                    i++;
                }else {
                    sum+=10;
                }
            }else if(c == 'V'){
                sum+=5;
            }else if(c=='I'){
                if(i < length-1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                    if(s.charAt(i+1) == 'V'){
                        sum+=4;
                    }else{
                        sum+=9;
                    }
                    i++;
                }else {
                    sum+=1;
                }
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = romanToInt("MMMCMXCIX");
        System.out.printf(""+sum);
    }
}
