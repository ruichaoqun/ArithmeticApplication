package com.example.arithmeticapplication.jianzhioffer

import com.example.arithmeticapplication.leecode.tree.TreeNode

/**
 *@author ruichaoqun
 *创建日期：2021-11-28 18:03
 *描述：Question27
 *请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 

示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
 

限制：

0 <= 节点个数 <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Question27 {
    fun mirrorTree(root: TreeNode?): TreeNode? {
        mirror(root)
        return root
    }

    fun mirror(root: TreeNode?){
        if(root == null){
            return
        }
        var q = root.left
        root.left = root.right
        root.right = q
        mirror(root.left)
        mirror(root.right)
    }
}