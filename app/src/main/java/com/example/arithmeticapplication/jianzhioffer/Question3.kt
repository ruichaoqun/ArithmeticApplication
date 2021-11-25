package com.example.arithmeticapplication.jianzhioffer

import kotlin.math.abs


/**
 *@author ruichaoqun
 *创建日期：2021/11/23 0:19
 *描述：Question3
 *找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
 

限制：

2 <= n <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Question3{
    companion object{
        fun findRepeatNumber(nums: IntArray): Int? {
            val temp = IntArray(nums.size)
            for (i in nums){
                temp[i] += 1
                if(temp[i] > 1){
                    return i
                }
            }
            return null
        }

        fun findRepeatNumber1(nums: IntArray): Int {
            nums.sort()
            for ((i,index) in  nums.withIndex()){
                if(i > 0 && index == nums[i-1]){
                    return index;
                }
            }
            return  -1
        }

        fun findRepeatNumber2(nums: IntArray): Int {
            var zeroCount = 0
            for ((i,index) in  nums.withIndex()){
                if(nums[abs(index)] < 0){
                    return abs(index)
                }else{
                    if(index == 0){
                        if(zeroCount > 0)
                            return 0
                        zeroCount++
                    }
                    nums[abs(index)] = -nums[abs(index)]
                }
            }
            return  -1
        }
    }
}

fun main() {
    println("${Question3.findRepeatNumber2(intArrayOf(2, 3, 1, 0, 2, 5, 3))}")
}
