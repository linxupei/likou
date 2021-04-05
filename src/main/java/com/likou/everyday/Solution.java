package com.likou.everyday;


import java.util.Arrays;

public class Solution {

    /**
     * 两数组从后往前排序即可, 不需要额外的空间
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
//        if (m == 0) {
//            nums1 = nums2;
//        }
        int index = nums1.length - 1, index1 = m - 1, index2 = n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0 && index2 >= 0) {
                if (nums1[index1] > nums2[index2]) {
                    nums1[index--] = nums1[index1--];
                } else {
                    nums1[index--] = nums2[index2--];
                }
            } else if (index1 >=0) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }
    }

    public static void main(String[] args) {
        int []nums1 = new int[]{0};
        int []nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}

