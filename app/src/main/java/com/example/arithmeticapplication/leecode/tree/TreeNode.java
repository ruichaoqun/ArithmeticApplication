package com.example.arithmeticapplication.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        List<TreeNode> list = new ArrayList<>();
        list.add(this);
        while (list.size() > 0){
            int count = list.size();
            for (int i = 0;i < count;i++){
                TreeNode node = list.get(0);
                list.remove(0);
                if(node == null){
                    builder.append("null,");
                }else{
                    builder.append(node.val);
                    builder.append(",");
                    list.add(node.left);
                    list.add(node.right);
                }
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
