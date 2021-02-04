package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        int numsLength = nums.length;
        int length = numsLength-k+1;
        double[] result = new double[length];
        DualHeap dualHeap = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dualHeap.insert(nums[i]);
        }
        result[0] = dualHeap.getMedian();
        for (int i = k; i < numsLength; i++) {
            dualHeap.erase(nums[i-k]);
            dualHeap.insert(nums[i]);
            result[i-k+1] = dualHeap.getMedian();
        }
//        int[] temp = new int[k];
//        if (k % 2 != 0) {
//            for (int i = 0; i < length; i++) {
//                for (int j = i; j < k+i; j++) {
//                    temp[j-i] = nums[j];
//                }
//                Arrays.sort(temp);
//                result[i] = temp[k/2];
//            }
//        } else {
//            for (int i = 0; i < length; i++) {
//                for (int j = i; j < k+i; j++) {
//                    temp[j-i] = nums[j];
//                }
//                Arrays.sort(temp);
//                BigDecimal a = new BigDecimal(temp[k/2]);
//                BigDecimal b = new BigDecimal(temp[k/2-1]);
//                a = a.add(b);
//                a = a.divide(new BigDecimal(2));
//                result[i] = a.doubleValue();
//            }
//        }

        return result;
    }

    /**
     * 设定small数量与large相等或small数量比large多1
     */
    static class DualHeap {
        //保存较小的一部分数字
        private PriorityQueue<Integer> small;
        //保存较大的一部分数字
        private PriorityQueue<Integer> large;
        //小根堆与大根堆中元素数量, 与实际数量不一定一致
        private int smallNum, largeNum;
        //数组长度, 判断奇数或偶数
        private int k;
        //保存某个数字需要删除的次数, 键为数字, 值为次数
        private HashMap<Integer, Integer> nums;

        DualHeap(int k) {
            small = new PriorityQueue<>(Comparator.reverseOrder());
            large = new PriorityQueue<>();
            nums = new HashMap<>();

            this.k = k;
            smallNum = 0;
            largeNum = 0;
        }

        /**
         * 获取中位数
         */
        public double getMedian() {
            return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
        }

        public void insert(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                smallNum++;
            } else {
                large.offer(num);
                largeNum++;
            }
            makeBalance();
        }

        public void erase(int num) {
            nums.put(num, nums.getOrDefault(num, 0)+1);
            if (num <= small.peek()) {
                smallNum--;
                if (small.peek() == num) {
                    prune(small);
                }
            } else {
                largeNum--;
                if (large.peek() == num) {
                    prune(large);
                }
            }
            makeBalance();
        }

        /**
         * 将在需要删除的堆顶元素删除, 直至堆顶元素不再是需要删除的元素
         * 但堆中仍有需要删除的元素, 这是延迟删除
         */
        public void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (nums.containsKey(num)) {
                    nums.put(num, nums.get(num)-1);
                    if (nums.get(num) == 0) {
                        nums.remove(num);
                    }
                    heap.poll();
                } else {
                    break;
                }
            }
        }

        //维持设定的队列平衡
        public void makeBalance() {
            //small的数量比large多2
            if (smallNum > largeNum + 1) {
                large.offer(small.poll());
                largeNum++;
                smallNum--;
                //small栈顶元素被移除, 需要进行prune
                prune(small);
            } else if (smallNum < largeNum) {
                //large数量比small多1
                small.offer(large.poll());
                largeNum--;
                smallNum++;
                //large栈顶元素被移除, 需要进行prune
                prune(large);
            }
        }
    }

    public static void main(String[] args) {
        medianSlidingWindow(new int[]{
                -2147483648,-2147483648,2147483647,-2147483648,-2147483648,
                -2147483648,2147483647,2147483647,2147483647,2147483647,
                -2147483648,2147483647,-2147483648}, 3);
    }
}

