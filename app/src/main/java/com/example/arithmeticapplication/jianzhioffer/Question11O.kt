package com.example.arithmeticapplication.jianzhioffer

/**
 *@author ruichaoqun
 *创建日期：2021/11/23 15:41
 *描述：Question11O
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question11O {
    companion object{
        fun minArray(numbers: IntArray): Int {
            var low = 0
            var high = numbers.size - 1
            while (low < high){
                var pivot = (low+high)/2
                if(numbers[pivot] < numbers[high]){
                    high = pivot
                }else if(numbers[pivot] > numbers[high]){
                    low = pivot+1
                }else{
                    high -= 1
                }
            }
            return numbers[low]
        }
    }
}

fun main() {
    println(Question11O.minArray(intArrayOf(1,3,5)))
}