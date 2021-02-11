package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ͨ��ʹ��ֻ����k�����ֵ�С����
     * ÿ��ֻ��������k����, ��ô���ڵ���ǵ�k�����
     */
    class KthLargest {
        int k;
        List<Integer> nums;
        PriorityQueue<Integer> kNum;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.nums = new LinkedList<>();
            this.kNum = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                this.nums.add(nums[i]);
                kNum.offer(nums[i]);
                if (i >= k && !kNum.isEmpty()) {
                    kNum.poll();
                }
            }
        }

        public int add(int val) {
            kNum.add(val);
            if (!kNum.isEmpty() && kNum.size() > k) {
                kNum.poll();
            }
            return kNum.size() == k ? kNum.peek() : null;
        }
    }

    public static void main(String[] args) {

    }
}

