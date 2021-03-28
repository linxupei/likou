package com.likou.everyday;

/**
 * @author ЧЋащ
 * @version 1.0
 * @date 2021/3/28 9:28
 * @describe
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
