package com.example.arithmeticapplication.jianzhioffer

import java.util.*

/**
 *@author ruichaoqun
 *创建日期：2021/11/23 14:50
 *描述：Question9
 *用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
提示：

1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question9 {
    val stack1 = Stack<Int>()
    val stack2 = Stack<Int>()
    var currentStack = stack1
    var otherStack = stack2
    fun appendTail(value: Int) {
        currentStack.push(value)
    }

    fun deleteHead(): Int {
        if(otherStack.empty()){
            while (!currentStack.empty()){
                otherStack.push(currentStack.pop())
            }
        }

        if(otherStack.empty()){
            return -1
        }
        return otherStack.pop()
    }
}

fun main() {
    var q = Question9()
    q.appendTail(3)
    println(q.deleteHead())
    println(q.deleteHead())
}