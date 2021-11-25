package com.example.arithmeticapplication.jianzhioffer

import com.example.arithmeticapplication.leecode.ListNode

/**
 *@author ruichaoqun
 *创建日期：2021/11/25 14:50
 *描述：Question18
 *给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 

说明：

题目保证链表中节点的值互不相同
若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question18 {
    companion object{
        fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
            var p:ListNode? = null
            var q = head
            if(head == null){
                return head
            }
            while (q != null && q.`val` != `val`){
                p = q
                q= q.next
            }
            if(q != null){
                if(p == null){
                    var s = q.next
                    q.next = null
                    return s
                }else{
                    p.next = q.next
                    q.next = null
                    return head
                }
            }
            return head
        }
    }
}

fun main() {
    var node1 = ListNode(5)
    var node2 = ListNode(4)
    var node3 = ListNode(3)
    var node4 = ListNode(2)
    var node5 = ListNode(1)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    println(Question18.deleteNode(node1,9).toString())
}