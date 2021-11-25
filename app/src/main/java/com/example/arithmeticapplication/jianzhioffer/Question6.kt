package com.example.arithmeticapplication.jianzhioffer

import com.example.arithmeticapplication.leecode.ListNode

/**
 *@author ruichaoqun
 *创建日期：2021/11/23 1:46
 *描述：Question5
 *输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 

限制：

0 <= 链表长度 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question6 {
    companion object{
        fun reversePrint(head: ListNode?): IntArray {
            var node = head
            var num = 0
            while (node != null){
                num ++
                node = node.next
            }
            var arr = IntArray(num)
            var newNode = head
            while (newNode != null){
                arr[num-1] = newNode.`val`
                newNode = newNode.next
                num -= 1
            }
            return arr
        }
    }
}

fun main() {
    var node1 = ListNode(1)
    var node2 = ListNode(3)
    var node3 = ListNode(2)
    node1.next = node2
    node2.next = node3
    var arr = Question6.reversePrint(node1)
    for (va in arr){
        print(va)
    }
}