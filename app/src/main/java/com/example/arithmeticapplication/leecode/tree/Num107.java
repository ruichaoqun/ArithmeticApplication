package com.example.arithmeticapplication.leecode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2020/3/10 9:38
 * description:给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num107 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        List<List<Integer>> listList = levelOrderBottom(node);
        System.out.println("args = [" + args + "]");
    }


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        List<List<Integer>> listList = new ArrayList<>();
        if(root == null){
            return listList;
        }
        treeNodes.add(root);
        while (treeNodes.size() != 0){
            int count = treeNodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = treeNodes.remove(0);
                list.add(node.val);
                if(node.left != null){
                    treeNodes.add(node.left);
                }
                if(node.right != null){
                    treeNodes.add(node.right);
                }
            }
            listList.add(list);
        }
        Collections.reverse(listList);
        return listList;
    }
}
