package com.likou.everyday;


import lombok.extern.java.Log;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.regex.Matcher;

public class Solution {


    /**
     * 中序遍历把所有结点找出, 由于是二叉搜索树, 此时已排好序, 找最小差值
     */
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        readNode(list, root);
        int result = Integer.MAX_VALUE;
        int size = list.size();
        for (int i = 1; i < size; i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (diff < result) {
                result = diff;
            }
        }
        return result;
    }



    public void readNode(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        readNode(list, root.left);
        list.add(root.val);
        readNode(list, root.right);
    }


    public static void main(String[] args) {

    }
}

