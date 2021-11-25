package com.example.arithmeticapplication.jianzhioffer


/**
 *@author ruichaoqun
 *创建日期：2021/11/24 23:54
 *描述：Question14-1
 *给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：

2 <= n <= 58

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question14 {
    companion object{
        fun cuttingRope(n: Int): Int {
            var temp = IntArray(n+1)
            temp[0] = 0
            temp[1] = 1
            for (i in 2..n){
                var value = 0
                for (n in 1..i/2){
                    var sum1 = temp[i-n]*n
                    var sum2 = (i-n)*n
                    value = max(value, max(sum1,sum2))
                }
                temp[i] = value
            }
            return temp[n]
        }

        fun max(a:Int,b:Int):Int{
            return if(a>b) a else b
        }
    }



}

fun main() {
    println(Question14.cuttingRope(2))
    println(Question14.cuttingRope(3))
    println(Question14.cuttingRope(4))
    println(Question14.cuttingRope(5))
    println(Question14.cuttingRope(6))
    println(Question14.cuttingRope(7))
    println(Question14.cuttingRope(8))
    println(Question14.cuttingRope(9))
    println(Question14.cuttingRope(10))
}