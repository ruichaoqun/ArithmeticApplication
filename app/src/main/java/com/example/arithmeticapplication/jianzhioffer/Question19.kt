package com.example.arithmeticapplication.jianzhioffer

import java.util.*

/**
 *@author ruichaoqun
 *创建日期：2021/11/25 15:03
 *描述：Question19
 *请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question19 {
    companion object{
        fun isMatch(s: String, p: String): Boolean {
            if(s.isEmpty() && p.isEmpty()){
                return true
            }
            return dfs(s,0,p,0)
        }

        fun dfs(s: String, m:Int,p: String,n:Int):Boolean{
            //循环退出
            if(m == s.length && n == p.length){
                return true
            }

            if(n == p.length){
                return false
            }

            if(m == s.length){
                if(p[n] == '*'){
                    return dfs(s,m,p,n+1)
                }else if(p[n] != '*' && n < p.length-1 && p[n+1] == '*'){
                    return dfs(s,m,p,n+2)
                }
                return false
            }

            var k = s[m]
            var l = p[n]

            if(k == l){
                if(dfs(s,m+1,p,n+1)){
                    return true
                }else if(n < p.length-1 && p[n+1] == '*'){
                    return dfs(s,m+1,p,n+2) || dfs(s,m,p,n+2)
                }
                return false
            }
            if(l == '.'){
                if(dfs(s,m+1, p,n+1)){
                    return true
                }else if(n < p.length-1 && p[n+1] == '*'){
                    return dfs(s,m,p,n+2) || dfs(s,m+1,p,n) || dfs(s,m+1,p,n+2)
                }
                return false
            }
            if(l == '*'){
                var t = p[n-1]
                if(k == t){
                    return dfs(s,m+1,p,n)||dfs(s,m+1,p,n+1)||dfs(s,m,p,n+1)
                }else if(t == '.'){
                    return dfs(s,m+1,p,n)||dfs(s,m+1,p,n+1)||dfs(s,m,p,n+1)
                }else{
                    return dfs(s,m,p,n+1)
                }
            }
            if(n < p.length-1 && p[n+1] == '*'){
                return dfs(s,m,p,n+2)
            }
            return false
        }
    }

}

fun main() {
    println(Question19.isMatch("",".*"))

}