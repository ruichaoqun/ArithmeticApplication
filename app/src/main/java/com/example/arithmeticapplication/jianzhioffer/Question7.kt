package com.example.arithmeticapplication.jianzhioffer

import com.example.arithmeticapplication.leecode.tree.TreeNode

/**
 *@author ruichaoqun
 *创建日期：2021/11/23 14:05
 *描述：Question7
 *输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。

假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

示例 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
示例 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

限制：

0 <= 节点个数 <= 5000

 
 */
class Question7 {
    companion object{
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            if(preorder.size == 0){
                return null
            }
            var node = TreeNode(preorder[0])
            defChild(preorder,0,preorder.size-1,inorder,0,inorder.size - 1,node)
            return node
        }

        fun defChild(preorder: IntArray,pLeft:Int,pRight:Int,inorder:IntArray,iLeft:Int,iRight:Int,parent:TreeNode){
            var value = parent.`val`
            var parnetInInorder = 0
            for (i in iLeft..iRight){
                if(inorder[i] == value){
                    parnetInInorder = i
                    break
                }
            }
            var leftCount = parnetInInorder - iLeft
            var rightCount = iRight - parnetInInorder
            if(leftCount != 0){
                var node = TreeNode(preorder[pLeft+1])
                parent.left = node
                defChild(preorder,pLeft+1,pLeft+leftCount,inorder,iLeft,parnetInInorder-1,node)
            }
            if(rightCount != 0){
                var node = TreeNode(preorder[pLeft+leftCount+1])
                parent.right = node
                defChild(preorder,pLeft+leftCount+1,pRight,inorder,parnetInInorder+1,iRight,node)
            }
        }
    }
}

fun main() {
    var arr1 = intArrayOf(3,9,20,15,7)
    var arr2 = intArrayOf(9,3,15,20,7)
    println(Question7.buildTree(arr1,arr2))
}