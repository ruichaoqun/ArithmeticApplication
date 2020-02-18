package com.example.arithmeticapplication.leecode.tree;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num105 {

    public static void main(String[] args) {
        Num105 num105 = new Num105();
        TreeNode node = num105.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.printf(""+node.val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int preLeft,int preRight,int[] inorder,int inLeft,int inRight) {
        TreeNode treeNode = new TreeNode(preorder[preLeft]);
        int i = inLeft;
        for (; i <= inRight; i++) {
            if(inorder[i] == treeNode.val){
                break;
            }
        }
        int leftCounts = i-inLeft;
        int rightCounts = inRight-i;
        if(leftCounts != 0){
            treeNode.left = buildTree(preorder,preLeft +1,preLeft+leftCounts,inorder,inLeft,i-1);
        }
        if(rightCounts != 0){
            treeNode.right = buildTree(preorder,preRight-rightCounts+1,preRight,inorder,i+1,inRight);
        }
        return treeNode;
    }
}
