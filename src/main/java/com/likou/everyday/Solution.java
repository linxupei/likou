package com.likou.everyday;


import java.util.*;

public class Solution {

    /**
     * 使用二分查找法, 判断某个船容量需要多少天
     * 船容量最小值为货物之中最大值, 船容量最大值为全部货物总和
     */
    public static int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }
//        left = Arrays.stream(weights).max().getAsInt();
//        right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left +  ((right - left) >> 1);
            int possible = possible(weights, mid);
            if (possible > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 判断对于某个船容量, 需要在几天内运完
     */
    public static int possible(int[] weights, int capacity) {
        int days = 0;
        int count = 0;
        for (int weight : weights) {
            count += weight;
            if (count > capacity) {
                days++;
                count = weight;
            }
        }
        return ++days;
    }


    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }
}





