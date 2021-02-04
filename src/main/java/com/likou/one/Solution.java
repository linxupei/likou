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
     * �趨small������large��Ȼ�small������large��1
     */
    static class DualHeap {
        //�����С��һ��������
        private PriorityQueue<Integer> small;
        //����ϴ��һ��������
        private PriorityQueue<Integer> large;
        //С������������Ԫ������, ��ʵ��������һ��һ��
        private int smallNum, largeNum;
        //���鳤��, �ж�������ż��
        private int k;
        //����ĳ��������Ҫɾ���Ĵ���, ��Ϊ����, ֵΪ����
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
         * ��ȡ��λ��
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
         * ������Ҫɾ���ĶѶ�Ԫ��ɾ��, ֱ���Ѷ�Ԫ�ز�������Ҫɾ����Ԫ��
         * ������������Ҫɾ����Ԫ��, �����ӳ�ɾ��
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

        //ά���趨�Ķ���ƽ��
        public void makeBalance() {
            //small��������large��2
            if (smallNum > largeNum + 1) {
                large.offer(small.poll());
                largeNum++;
                smallNum--;
                //smallջ��Ԫ�ر��Ƴ�, ��Ҫ����prune
                prune(small);
            } else if (smallNum < largeNum) {
                //large������small��1
                small.offer(large.poll());
                largeNum--;
                smallNum++;
                //largeջ��Ԫ�ر��Ƴ�, ��Ҫ����prune
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

