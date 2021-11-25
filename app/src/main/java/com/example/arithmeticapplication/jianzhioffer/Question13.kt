package com.example.arithmeticapplication.jianzhioffer


/**
 *@author ruichaoqun
 *创建日期：2021/11/24 23:09
 *描述：Question13
 *地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question13 {
    companion object{
        fun movingCount(m: Int, n: Int, k: Int): Int {
            //深度优先搜索
            var arr = Array(m){BooleanArray(n)}
            return dfs(m,n,k,0,0,arr)
        }

        fun dfs(m:Int,n:Int,k:Int,ms:Int,ns:Int,arr:Array<BooleanArray>):Int{
            if(ms == m || ns == n || arr[ms][ns] ||  !checkAvailable(ms,ns,k)){
                return 0
            }
            arr[ms][ns] = true
            return 1 + dfs(m,n,k,ms+1,ns,arr) + dfs(m,n,k,ms,ns+1,arr)
        }

        fun checkAvailable(m:Int, n:Int, k:Int):Boolean{
            var sum = 0
            var mt = m
            var nt = n
            while (mt>0){
                sum += mt%10
                mt /= 10
            }
            while (nt>0){
                sum += nt%10
                nt /= 10
            }
            if(sum <= k){
                return true
            }
            return false
        }
    }
}

fun main() {
    println(Question13.movingCount(1,2,1))
}