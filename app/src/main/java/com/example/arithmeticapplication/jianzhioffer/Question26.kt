package com.example.arithmeticapplication.jianzhioffer

import com.example.arithmeticapplication.leecode.tree.TreeNode

/**
 *@author ruichaoqun
 *创建日期：2021-11-28 17:20
 *描述：Question26
 *输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

     3
    / \
   4   5
  / \
 1   2
给定的树 B：

   4 
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

示例 1：

输入：A = [1,2,3], B = [3,1]
输出：false
示例 2：

输入：A = [3,4,5,1,2], B = [4,1]
输出：true
限制：

0 <= 节点个数 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question26 {
    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
        if(A == null || B == null){
            return false
        }
        return dfs(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B)
    }

    fun dfs(A: TreeNode?, B: TreeNode?):Boolean{
        if(B == null || A == null){
            return false
        }
        if(A.`val` == B.`val`){
            if(B.left == null && B.right == null){
                return true
            }else if(B.left != null && B.right != null){
                return dfs(A.left,B.left) && dfs(A.right,B.right)
            }else if(B.left != null){
                return dfs(A.left,B.left)
            }else{
                return dfs(A.right,B.right)
            }
        }else{
            return false
        }
    }
}

fun main() {
    var q = Question26()
    var node1 = TreeNode(-2)
    var node2 = TreeNode(1)
//    var node3 = TreeNode(1)
//    var node4 = TreeNode(-4)
//    var node5 = TreeNode(-3)
    node1.left = node2
//    node1.right = node3
//    node2.left = node4
//    node2.right = node5


    var b1 = TreeNode(-2)
    var b2 = TreeNode(1)
    var b3 = TreeNode(2)
    b1.left = b2
    b1.right = b3
    println(q.isSubStructure(node1,b1))
}