package com.likou.everyday;


import java.util.*;

public class Solution {

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode();
        TreeNode temp = dummyNode;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                temp.right = node;
                root = node.right;
                node.right = null;
                node.left = null;
                temp = temp.right;
            }
        }
        return dummyNode.right;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(1);
        System.out.println(increasingBST(root));
    }
}





