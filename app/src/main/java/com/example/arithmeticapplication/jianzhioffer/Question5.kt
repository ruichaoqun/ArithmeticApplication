package com.example.arithmeticapplication.jianzhioffer

/**
 *@author ruichaoqun
 *创建日期：2021/11/23 1:46
 *描述：Question5
 *请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 

限制：

0 <= s 的长度 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question5 {
    companion object{
        fun replaceSpace(s: String): String {
            if(s.length == 0){
                return s
            }
            var arr = s.toCharArray()
            var count = 0
            for (index in arr){
                if(index == ' '){
                    count ++;
                }
            }
            if(count == 0){
                return s
            }
            var arrNew = CharArray(arr.size+count*2)
            var p = 0
            for (c in arr){
                if(c == ' '){
                    arrNew[p]='%'
                    arrNew[p+1]='2'
                    arrNew[p+2]='0'
                    p +=3
                }else{
                    arrNew[p]=c
                    p++
                }
            }
            return String(arrNew)
        }
    }
}

fun main() {
    println("${Question5.replaceSpace("We are happy.")}")
}