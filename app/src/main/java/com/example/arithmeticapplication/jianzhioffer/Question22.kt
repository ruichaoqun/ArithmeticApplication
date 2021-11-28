package com.example.arithmeticapplication.jianzhioffer

import com.example.arithmeticapplication.leecode.ListNode

/**
 *@author ruichaoqun
 *创建日期：2021-11-28 17:01
 *描述：Question22
 *输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

 

示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question22 {
    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        if(head == null){
            return null
        }
        var p = head
        var r = p
        var i = k
        while (i > 1 && r != null){
            r = r.next
            i--
        }
        if(r == null){
            return null
        }
        while (r?.next != null){
            r = r.next
            p = p?.next
        }
        return p
    }
}

fun main() {

}