package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

    /**
     * pu��Ϊ����ջ
     * po��Ϊ���ջ
     */
    class MyQueue {
        private Deque<Integer> pu;
        private Deque<Integer> po;

        /** Initialize your data structure here. */
        public MyQueue() {
            pu = new LinkedList<>();
            po = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pu.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            //�����ջΪ�յ�ʱ��, ������ջ��ֵ�������ջ��
            if (po.isEmpty()) {
                while (!pu.isEmpty()) {
                    po.push(pu.pop());
                }
            }
            return po.pop();
        }

        /** Get the front element. */
        public int peek() {
            //�����ջΪ�յ�ʱ��, ������ջ��ֵ�������ջ��
            if (po.isEmpty()) {
                while (!pu.isEmpty()) {
                    po.push(pu.pop());
                }
            }
            return po.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return po.isEmpty() && pu.isEmpty();
        }
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLIS(new int[]{10,9,2,5,7,3,101,18}));
        //System.out.println(maxEnvelopes(new int[][]{{1, 0}, {1, 1}, {1, 2}, {2, 1}, {3, 5}, {4, 3}, {5, 6}}));
    }
}

