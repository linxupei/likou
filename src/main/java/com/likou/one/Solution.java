package com.likou.one;

import netscape.security.UserTarget;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

    /**
     * ������ӵķ�ʽ
     * ��ʼʱֻ��һ����, �����ڵ�
     * ����һ��'#', ��λ����һ��
     * ����һ������, ��λ����һ����ͬʱ��������
     */
    public boolean isValidSerialization1(String preorder) {
        Deque<Integer> stack = new LinkedList<>();
        int length = preorder.length();
        int index = 0;
        stack.push(1);
        while (index < length) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(index) == ',') {
                index++;
            } else if (preorder.charAt(index) == '#') {
                int count = stack.pop() - 1;
                if (count > 0) {
                    stack.push(count);
                }
                index++;
            } else {
                while (index < length && preorder.charAt(index) != ',') {
                    index++;
                }
                int count = stack.pop() - 1;
                if (count > 0) {
                    stack.push(count);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    /**
     * ������ӵķ�ʽ
     * ����������֪, ��ӵ�ʱ����Ժ��Կ����ڽ��,
     * ֻҪͳ�ƿӵ���������
     * ��ʼʱֻ��һ����, �����ڵ�
     * ����һ��'#', ��λ����һ��
     * ����һ������, ��λ����һ����ͬʱ��������
     */
    public static boolean isValidSerialization(String preorder) {
        int total = 1;
        int length = preorder.length();
        int index = 0;
        while (index < length) {
            if (total == 0) {
                return false;
            }
            if (preorder.charAt(index) == ',') {
                index++;
            } else if (preorder.charAt(index) == '#') {
                total--;
                index++;
            } else {
                while (index < length && preorder.charAt(index) != ',') {
                    index++;
                }
                total++;
            }
        }
        return total == 0;
    }


    public static void main(String[] args) {
        System.out.println(isValidSerialization("1 + 2 * 3"));
    }
}

