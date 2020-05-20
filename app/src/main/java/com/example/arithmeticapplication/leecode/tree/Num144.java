package com.example.arithmeticapplication.leecode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Rui Chaoqun
 * @date :2020/4/1 9:31
 * description:给定一个二叉树，返回它的 前序 遍历。
 */
public class Num144 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        Num144 num144 = new Num144();
        List<Integer> s = num144.preorderTraversal(treeNode);
        System.out.println("args = [" + args + "]");
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            integers.add(node.val);
            while (node.left != null){
                stack.push(node.left);
                node.left = null;
            }
            TreeNode node1 = stack.pop();
            if(node1.right != null){
                stack.push(node1.right);
                node1.right = null;
            }
        }
        return integers;
    }
}
