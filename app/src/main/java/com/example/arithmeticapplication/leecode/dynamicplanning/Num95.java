package com.example.arithmeticapplication.leecode.dynamicplanning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2019/12/11 9:34
 * description:给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class Num95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new LinkedList<>();
        }
        return generateTrees(1,n);
    }

    /**
     * 动态规划+递归的思想
     * @param left
     * @param right
     * @return 返回当前left到right的所有搜索树
     */
    public List<TreeNode> generateTrees(int left,int right){
        List<TreeNode> list = new LinkedList<>();
        //跳出递归条件
        if(left > right){
            list.add(null);
            return list;
        }
        //遍历从left到right，尝试将每一个节点当做根节点
        for (int i = left; i <= right ; i++) {
            //拿到当i为根节点是它的左子树的所有搜索树
            List<TreeNode> leftTrees = generateTrees(left,i-1);
            //拿到当i为根节点是它的右子树的所有搜索树
            List<TreeNode> rightTrees = generateTrees(i+1,right);

            //以i为根节点的所有搜索树就是它的 左子树的所有搜索树 * 右子树的所有搜索树（这儿注意两个子搜索树最小要是1，不能是10）
            for (TreeNode l:leftTrees) {
                for (TreeNode r:rightTrees) {
                    //生成根节点
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = l;
                    treeNode.right = r;
                    //加入到数组中
                    list.add(treeNode);
                }
            }
        }
        return list;
    }

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
