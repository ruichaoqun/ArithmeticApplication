package com.example.arithmeticapplication.jianzhioffer

/**
 *@author ruichaoqun
 *创建日期：2021/11/25 16:58
 *描述：Question20
 *请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

数值（按顺序）可以分成以下几个部分：

若干空格
一个 小数 或者 整数
（可选）一个 'e' 或 'E' ，后面跟着一个 整数
若干空格
小数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
下述格式之一：
至少一位数字，后面跟着一个点 '.'
至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
至少一位数字
部分数值列举如下：

["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
部分非数值列举如下：

["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 

示例 1：

输入：s = "0"
输出：true
示例 2：

输入：s = "e"
输出：false
示例 3：

输入：s = "."
输出：false
示例 4：

输入：s = "    .1  "
输出：true
 

提示：

1 <= s.length <= 20
s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
通过次数81,283提交次数332,895

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question20 {
    companion object{
        fun isNumber(s: String): Boolean {
            var start = 0
            var end = s.length-1
            while (start <= s.length-1 && s[start] == ' '){
                start++
            }
            while (end >= 0 && s[end] == ' '){
                end--
            }
            if(start > end){
                return false
            }
            if(s.contains('e') || s.contains('E')){
                var index = 0
                if(s.contains('e')){
                    index = s.indexOf('e')
                }else{
                    index = s.indexOf('E')
                }
                return (isZhengShu(s,start,index-1) || isXiaoshu(s,start,index-1))&& isZhengShu(s,index+1,end)
            }else{
                return isZhengShu(s,start,end) || isXiaoshu(s,start,end)
            }
        }

        fun isZhengShu(s:String,m:Int,n:Int):Boolean{
            var start = m
            var end = n
            if(start > end || start >= s.length || end <0){
                return false
            }
            if(s[start] == '+' || s[start] == '-'){
                start++
            }
            if(start > end){
                return false
            }
            for (i in start..end){
                if(s[i]<'0' || s[i]>'9'){
                    return false
                }
            }
            return true
        }

        fun isXiaoshu(s:String,m:Int,n:Int):Boolean{
            var start = m
            var end = n
            if(start > end || start >= s.length || end <0){
                return false
            }
            if(s[start] == '+' || s[start] == '-'){
                start++
            }
            if(start >= end){
                return false
            }
            var pointCount = 0
            var numCount = 0
            for (i in start..end){
                if(s[i] == '.'){
                    if(pointCount != 0){
                        return false
                    }
                    pointCount++
                }else{
                    if(s[i]<'0' || s[i]>'9'){
                        return false
                    }else{
                        numCount++
                    }
                }

            }
            if(pointCount == 1 && numCount > 0){
                return true
            }
            return false
        }
    }
}

fun main() {
    println(Question20.isNumber("1 "))
//    println(Question20.isNumber("+100"))
//    println(Question20.isNumber("5e2"))
//    println(Question20.isNumber("-123"))
//    println(Question20.isNumber("3.1416"))
//    println(Question20.isNumber("-1E-16"))
//    println(Question20.isNumber("0123"))
////
////
//    println("false-----------")
//    println(Question20.isNumber("12e"))
//    println(Question20.isNumber("1a3.14"))
//    println(Question20.isNumber("1.2.3"))
//    println(Question20.isNumber("+-5"))
//    println(Question20.isNumber("12e+5.4"))
}