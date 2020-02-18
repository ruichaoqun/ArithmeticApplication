package com.example.arithmeticapplication.leecode.tree;

import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num114 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(6);
        Num114 num114 = new Num114();
        num114.flatten1(node);
        System.out.printf("");
    }
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        helper(root,stack);
        TreeNode node = stack.pop();
        node.left = null;
        node.right = null;
        while (!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            node1.left = null;
            node1.right = node;
            node = node1;
        }
    }

    public void helper(TreeNode node,Stack<TreeNode> stack){
        if(node == null){
            return;
        }
        stack.push(node);
        helper(node.left,stack);
        helper(node.right,stack);
    }

    public void flatten1(TreeNode root) {
        while (root != null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            if(left != null){
                root.left = null;
                root.right = left;
                while (left.right != null){
                    left = left.right;
                }
                left.right = right;
            }
            root = root.right;
        }
    }
}
