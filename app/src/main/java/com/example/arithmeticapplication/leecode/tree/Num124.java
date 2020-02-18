package com.example.arithmeticapplication.leecode.tree;

import android.content.Intent;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num124 {
    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        //[5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);

        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        node.right.right.right = new TreeNode(-7);
        node.right.right.right.right = new TreeNode(10);
        Num124 num124 = new Num124();
        System.out.printf(""+num124.maxPathSum(node));
    }

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root);
        return max;
    }

    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(helper(node.left),0);
        int right = Math.max(helper(node.right),0);
        max = Math.max(max,left+right+node.val);
        return node.val + Math.max(left,right);
    }
}
