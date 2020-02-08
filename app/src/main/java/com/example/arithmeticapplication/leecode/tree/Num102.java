package com.example.arithmeticapplication.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num102 {

    //二叉树的层次遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists= new ArrayList<>();
        if(root == null){
            return lists;
        }
        stack(root,0,lists);
        return lists;
    }


    public void stack(TreeNode node,int level,List<List<Integer>> lists){
        if(lists.size() <= level){
            lists.add(new ArrayList<Integer>());
        }
        lists.get(level).add(node.val);
        if(node.left != null){
            stack(node.left,level+1,lists);
        }

        if(node.right != null){
            stack(node.right,level+1,lists);
        }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists= new ArrayList<>();
        if(root == null){
            return lists;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        int level = 0;
        while (!treeNodes.isEmpty()){
            lists.add(new ArrayList<Integer>());
            int tree_size = treeNodes.size();
            for (int i = 0; i < tree_size; i++) {
                TreeNode node = treeNodes.remove();
                lists.get(level).add(node.val);
                if(node.left != null){
                    treeNodes.add(node.left);
                }
                if(node.right != null){
                    treeNodes.add(node.right);
                }
            }
            level++;
        }
        return lists;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> lists= new ArrayList<>();
        if(root == null){
            return lists;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        s(nodeList,lists);
        return lists;
    }


    public void s(List<TreeNode> nodeList,List<List<Integer>> lists){
        List<Integer> list = new ArrayList<>();
        if(nodeList.size() == 0){
            return;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            list.add(nodeList.get(i).val);
            if(nodeList.get(i).left != null){
                treeNodeList.add(nodeList.get(i).left);
            }
            if(nodeList.get(i).right != null){
                treeNodeList.add(nodeList.get(i).right);
            }
        }
        lists.add(list);
        s(treeNodeList,lists);
    }

}
