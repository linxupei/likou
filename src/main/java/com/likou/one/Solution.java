package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }

    /**
     * 单调递减队列
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int length = nums.length;
        int[] maxNums = new int[length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        maxNums[0] = nums[deque.peekFirst()];
        for (int i = k; i < length; i++) {
            //若当前值比队列末尾值大, 移除队列末尾值
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //将队列头中下标不符合滑动窗口范围的移除
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offer(i);
            maxNums[i-k+1] = nums[deque.peekFirst()];
        }
        return maxNums;
    }

    /**
     * 通过优先队列, 大根堆
     * 将当前下标以及下标对应的值放入大根堆中
     * 先比较值, 再比较下标
     */
    public static int[] maxSlidingWindow_(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0]-o1[0] : o2[1]-o1[1]);
        int[] maxNums = new int[length - k + 1];
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        maxNums[0] = priorityQueue.peek()[0];
        for (int i = k; i < length; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
            //当根节点的下标不在滑动窗口范围内的时候, 移除
            while (priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }
            maxNums[i-k+1] = priorityQueue.peek()[0];
        }
        return maxNums;
    }

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3));
    }
}

