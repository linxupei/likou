package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
//        List<Integer> arr = new ArrayList<>();
//        getNodes(arr, root);
//        int lowIndex = binarySearch(arr, low);
//        int heightIndex = binarySearch(arr, high);
//        int ret = 0;
//        for (int i = lowIndex; i <= heightIndex; i++) {
//            ret += arr.get(i);
//        }
//        return ret;
        return getSum(root, low, high);
    }


    public int getSum(TreeNode root, int low, int height) {
        if (root == null) {
            return 0;
        }
        //当root.val比height还大, 只能到左子树查找, 右子树的每个结点比root.val都大
        if (root.val > height) {
            return getSum(root.left, low, height);
        }
        //当root.val比low还小, 只能到右子树查找, 左子树的每个结点比root.val都小
        if (root.val < low) {
            return getSum(root.right, low, height);
        }
        return root.val + getSum(root.left, low, height) + getSum(root.right, low, height);
    }

    //中序遍历
    public void getNodes(List<Integer> arr, TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                arr.add(p.val);
                p = p.right;
            }
        }
    }

    //二分查找法
    public int binarySearch(List<Integer> arr, Integer target) {
        //在arr[l...h]中查找
        int l = 0, h = arr.size() - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (arr.get(mid).compareTo(target) == 0) {
                return mid;
            }
            if (arr.get(mid).compareTo(target) > 0) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}





