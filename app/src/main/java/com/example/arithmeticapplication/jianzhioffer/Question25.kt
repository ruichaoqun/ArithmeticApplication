package com.example.arithmeticapplication.jianzhioffer

import com.example.arithmeticapplication.leecode.ListNode

/**
 *@author ruichaoqun
 *创建日期：2021-11-28 17:13
 *描述：Question25
 *输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question25 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var p = l1
        var q = l2
        var newHeader = ListNode(0)
        var r = newHeader
        while (p != null && q != null){
            if(p.`val` < q.`val`){
                r.next = p
                r = r.next
                p = p.next
            }else{
                r.next = q
                r = r.next
                q = q.next
            }
        }
        if(p != null){
            r.next = p
        }
        if(q != null){
            r.next = q
        }
        return newHeader.next
    }
}