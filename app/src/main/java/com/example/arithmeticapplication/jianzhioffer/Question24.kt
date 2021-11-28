package com.example.arithmeticapplication.jianzhioffer

import com.example.arithmeticapplication.leecode.ListNode

/**
 *@author ruichaoqun
 *创建日期：2021-11-28 17:10
 *描述：Question24
 *定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 

限制：

0 <= 节点个数 <= 5000

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question24 {
    fun reverseList(head: ListNode?): ListNode? {
        val newHead = ListNode(0)
        var p = head
        while (p != null){
            var q = p.next
            p.next = newHead.next
            newHead.next = p
            p = q
        }
        return newHead.next
    }
}