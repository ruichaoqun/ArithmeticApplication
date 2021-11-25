package com.example.arithmeticapplication.jianzhioffer

/**
 *@author ruichaoqun
 *创建日期：2021/11/25 14:43
 *描述：Question17
 *输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
 

说明：

用返回一个整数列表来代替打印
n 为正整数

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question17 {
    companion object{
        fun printNumbers(n: Int): IntArray {
            var m = n
            var count = 1
            while (m>0){
                count *=10
                m--
            }
            var arr = IntArray(count-1)
            for (i in arr.indices){
                arr[i] = i+1
            }
            return arr
        }
    }
}

fun main() {
    var arr = Question17.printNumbers(1)
    println(arr)
}