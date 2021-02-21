package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> add = new LinkedList<>();
        Deque<Integer> des = new LinkedList<>();
        int result = 0;
        int left = 0, right = 0;
        int length = nums.length;
        while (right < length) {
            while (!add.isEmpty() && add.peekLast() > nums[right]) {
                add.pollLast();
            }
            while (!des.isEmpty() && des.peekLast() < nums[right]) {
                des.pollLast();
            }
            add.offer(nums[right]);
            des.offer(nums[right]);
            while (!add.isEmpty() && !des.isEmpty() && des.peekFirst()- add.peekFirst() > limit) {
                if (nums[left] == add.peekFirst()) {
                    add.pollFirst();
                }
                if (nums[left] == des.peekFirst()) {
                    des.pollFirst();
                }
                left++;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }

    /**
     * 通过滑动窗口+自平衡的排序二叉树
     */
    public static int longestSubarray_2(int[] nums, int limit) {
        int result = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int left = 0, right = 0;
        int length = nums.length;
        while (right < length) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while (!treeMap.isEmpty() && treeMap.lastKey()-treeMap.firstKey() > limit) {
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left++;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }


    /**
     * 使用大根堆, 小根堆, 确定区间的范围
     */
    public static int longestSubarray_1(int[] nums, int limit) {
        PriorityQueue<int []> small = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });
        PriorityQueue<int []> big = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1]-o1[1];
            }
            return o2[0]-o1[0];
        });
        int left = 0;
        int right = 0;
        int length = nums.length;
        int result = 0;
        boolean maxFlag = false, minFlag = false;
        while (right < length) {
            small.offer(new int[]{nums[right], right});
            big.offer(new int[]{nums[right], right});
            //移除不在范围的值
            while (!small.isEmpty() && small.peek()[1] < left) {
                small.poll();
            }
            while (!big.isEmpty() && big.peek()[1] < left) {
                big.poll();
            }
            int max = Math.abs(nums[right]-big.peek()[0]);
            int maxIndex = big.peek()[1];
            int min = Math.abs(nums[right]-small.peek()[0]);
            int minIndex = small.peek()[1];
            while (!big.isEmpty() && max > limit) {
                maxIndex = big.poll()[1];
                //移除不在范围的值
                while (!big.isEmpty() && big.peek()[1] < maxIndex) {
                    big.poll();
                }
                max = Math.abs(nums[right]-big.peek()[0]);
                maxFlag = true;
            }
            while (!small.isEmpty() && min > limit) {
                minIndex = small.poll()[1];
                //移除不在范围的值
                while (!small.isEmpty() && small.peek()[1] < minIndex) {
                    small.poll();
                }
                min = Math.abs(nums[right]-small.peek()[0]);
                minFlag = true;
            }
            if (maxFlag || minFlag) {
                result = Math.max(result, right-left);
                if (maxFlag && minFlag) {
                    //最大值发生变化
                    left = Math.max(minIndex, maxIndex) + 1;
                } else if (maxFlag) {
                    //最小值发生变化
                    left = maxIndex + 1;
                } else {
                    //最大值, 最小值都发生变化
                    left = minIndex + 1;
                }
                maxFlag = false;
                minFlag = false;
            }
            right++;
        }
        return Math.max(result, right-left);
    }


    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{
                4,2,2,2,4,4,2,2}, 0));
    }
}

