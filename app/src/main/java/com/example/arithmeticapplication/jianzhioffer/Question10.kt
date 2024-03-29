package com.example.arithmeticapplication.jianzhioffer

/**
 *@author ruichaoqun
 *创建日期：2021/11/23 15:09
 *描述：Question10
 *写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 

示例 1：

输入：n = 2
输出：1
示例 2：

输入：n = 5
输出：5
 

提示：

0 <= n <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question10 {
    companion object{
        fun fib(n: Int): Int {
            var MOD = 1000000007
            if (n < 2) {
                return n
            }
            var p = 0
            var q = 0
            var r = 1
            for (i in 2..n) {
                p = q
                q = r
                r = (p + q) % MOD
            }
            return r
        }
    }
}

fun main() {
    println(Question10.fib(2))
    println(Question10.fib(5))
    println(Question10.fib(100))
}