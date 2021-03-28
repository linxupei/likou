package com.likou.everyday;


import java.util.*;

class BSTIterator {

    List<Integer> valueList;
    int index;
    int size;

    public BSTIterator(TreeNode root) {
        valueList = new ArrayList<>();
        middleTraversal(root);
        index = 0;
        size = valueList.size();
    }

    /**
     * 中序遍历把所有数据加入valueList
     */
    public void middleTraversal1(TreeNode root) {
        TreeNode current = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                valueList.add(current.val);
                current = current.right;
            }
        }
    }

    public void middleTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            middleTraversal(root.left);
        }
        valueList.add(root.val);
        if (root.right != null) {
            middleTraversal(root.right);
        }
    }

    public int next() {
        return valueList.get(index++);
    }

    public boolean hasNext() {
        return index < size;
    }
}

public class Solution {




    public static void main(String[] args) {

    }
}

