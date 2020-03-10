package com.example.arithmeticapplication.leecode.tree;

/**
 * @author Rui Chaoqun
 * @date :2020/3/10 10:08
 * description:将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num108 {

    public static void main(String[] args) {
        TreeNode  treeNode = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println("args = [" + args + "]");
    }

    public static  TreeNode sortedArrayToBST(int[] nums) {
        return stack(nums,0,nums.length-1);
    }

    public static TreeNode stack(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        if(left == right){
            return new TreeNode(nums[left]);
        }
        int middle = left + (right-left)/2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = stack(nums,left,middle-1);
        treeNode.right = stack(nums,middle+1,right);
        return treeNode;
    }
}
