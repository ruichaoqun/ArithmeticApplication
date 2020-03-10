package com.example.arithmeticapplication.leecode.tree;

/**
 * @author Rui Chaoqun
 * @date :2020/3/10 9:22
 * description:
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num106 {

    public static void main(String[] args) {
        Num106 num106 = new Num106();
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode node = num106.buildTree(inorder,postorder);
        System.out.println("args = [" + node.val + "]");
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        return stack(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    public TreeNode stack(int[] inorder,int[] postorder,int inorderLeft,int inorderRight,int postorderLeft,int postorderRight){
        if(inorderLeft > inorderRight){
            return null;
        }
        if(inorderLeft == inorderRight){
            return new TreeNode(inorder[inorderLeft]);
        }
        TreeNode treeNode = new TreeNode(postorder[postorderRight]);
        int i;
        for (i = inorderLeft; i <= inorderRight; i++) {
            if(inorder[i] == treeNode.val){
                break;
            }
        }
        int p = i - inorderLeft;
        treeNode.left = stack(inorder,postorder,inorderLeft,i-1,postorderLeft,postorderLeft+p-1);
        treeNode.right = stack(inorder,postorder,i+1,inorderRight,postorderLeft+p,postorderRight-1);
        return treeNode;
    }
}
