package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 经过简要分析可知从每一层遍历输出的最后一个结点开始遍历
     * 然后不断转换每一层遍历左右结点方向即可得到结果
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        //next用于存放下一层的结点
        List<TreeNode> next = new LinkedList<>();
        //now用于存放当前遍历层的结点
        List<TreeNode> now = new LinkedList<>();
        now.add(root);
        int flag = -1;
        while (!now.isEmpty()) {
            //保存当前层结点数, 在遍历过程中now的大小会发生变化
            int size = now.size();
            List<Integer> result = new LinkedList<>();
            for (int i = size-1; i >= 0; i--) {
                TreeNode node = now.remove(i);
                result.add(node.val);
                if (flag > 0) {
                    if (node.right != null) {
                        next.add(node.right);
                    }
                    if (node.left != null) {
                        next.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        next.add(node.left);
                    }
                    if (node.right != null) {
                        next.add(node.right);
                    }
                }
            }
            //将下一层赋值给now
            List<TreeNode> temp = now;
            now = next;
            next = temp;
            //将当前遍历层的数值加入结果集
            results.add(result);
            //修改标志, 转变下一次遍历方向
            flag = -flag;
        }
        return results;
    }


    public static void main(String[] args) {

    }
}

