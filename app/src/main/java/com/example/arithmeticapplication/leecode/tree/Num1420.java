package com.example.arithmeticapplication.leecode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rui Chaoqun
 * @date :2020/3/16 10:18
 * description:检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 *
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 *
 * 示例1:
 *
 *  输入：t1 = [1, 2, 3], t2 = [2]
 *  输出：true
 * 示例2:
 *
 *  输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 *  输出：false
 * 提示：
 *
 * 树的节点数目范围为[0, 20000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-subtree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num1420 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        boolean b = checkSubTree(t1,t2);
        System.out.println("args = [" + b + "]");
    }

    public static boolean checkSubTree(TreeNode t1, TreeNode t2) {
        return t1 != null && (isSubTree(t1,t2) || (t1.left != null && checkSubTree(t1.left,t2))  || (t1.right != null && checkSubTree(t1.right,t2)));
    }

    public  static boolean isSubTree(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.val != t2.val){
            return false;
        }
        if(t1.val == t2.val && isSubTree(t1.left,t2.left) && isSubTree(t1.right,t2.right)){
            return true;
        }
        return false;
    }
}
