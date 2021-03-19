package com.likou.one;

import com.sun.deploy.util.StringUtils;
import netscape.security.UserTarget;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Solution {
    /**
     * ʹ�ø÷���Ч�ʼ���
     */
    public static int evalRPN1(String[] tokens) {
        int top0, top1 = 0, top2 = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (String str : tokens) {
            try {
                top0 = Integer.parseInt(str);
                stack.push(top0);
            } catch (Exception e) {
                top1 = stack.pop();
                top2 = stack.pop();
                if (str.equals("+")) {
                    stack.push(top2 + top1);
                } else if (str.equals("-")) {
                    stack.push(top2 - top1);
                } else if (str.equals("*")) {
                    stack.push(top2 * top1);
                } else if (str.equals("/")) {
                    stack.push(top2 / top1);
                }
            }
        }
        return stack.pop();
    }

    /**
     * ��������
     * ��ʹ���������
     * ����һ����Ч�Ĳ������ʽ�ַ�������Ϊ����
     * ���ָպñ��������һ��
     * ������(n+1)>>1, �����(n-1)>>1
     * ����������,�ַ�������ǰ��ȫ��������, �����Ҫ�ռ�(n+1)>>1
     */
    public static int evalRPN(String[] tokens) {
        int top1 = 0, top2 = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                top1 = stack.pop();
                top2 = stack.pop();
                stack.push(top2 + top1);
            } else if (str.equals("-")) {
                top1 = stack.pop();
                top2 = stack.pop();
                stack.push(top2 - top1);
            } else if (str.equals("*")) {
                top1 = stack.pop();
                top2 = stack.pop();
                stack.push(top2 * top1);
            } else if (str.equals("/")) {
                top1 = stack.pop();
                top2 = stack.pop();
                stack.push(top2 / top1);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        int i=10 ;
        List list = null;
        Set set = null;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //hashMap.put(null, 1);
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1, null);
        System.out.println(i++==10 ? ++i : --i);
    }
}

