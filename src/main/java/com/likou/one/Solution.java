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
     * ������Ҫ������֪��ÿһ�������������һ����㿪ʼ����
     * Ȼ�󲻶�ת��ÿһ��������ҽ�㷽�򼴿ɵõ����
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        //next���ڴ����һ��Ľ��
        List<TreeNode> next = new LinkedList<>();
        //now���ڴ�ŵ�ǰ������Ľ��
        List<TreeNode> now = new LinkedList<>();
        now.add(root);
        int flag = -1;
        while (!now.isEmpty()) {
            //���浱ǰ������, �ڱ���������now�Ĵ�С�ᷢ���仯
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
            //����һ�㸳ֵ��now
            List<TreeNode> temp = now;
            now = next;
            next = temp;
            //����ǰ���������ֵ��������
            results.add(result);
            //�޸ı�־, ת����һ�α�������
            flag = -flag;
        }
        return results;
    }


    public static void main(String[] args) {

    }
}

