package com.likou.one;

import com.sun.deploy.util.StringUtils;
import netscape.security.UserTarget;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

    /**
     * ͨ��һ�α���, ��¼����ǰ�ķ���, �к�����ǰ�����Լ����������
     * -(-1-(-1))
     */
    public static int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int total = 0;
        int sign = 1;
        int index = 0;
        int length = s.length();
        stack.push(1);
        while (index < length) {
            if (s.charAt(index) == ' ') {
                index++;
            } else if (s.charAt(index) == '+') {
                index++;
                sign = stack.peek();
            } else if (s.charAt(index) == '-') {
                index++;
                //�ı䵱ǰ����: ��-(-1), �������������ȡ��
                sign = -stack.peek();
            } else if (s.charAt(index) == '(') {
                index++;
                stack.push(sign);
            } else if (s.charAt(index) == ')') {
                //����sign(), ����ǰ��sign
                index++;
                stack.pop();
            } else {
                int temp = 0;
                while (index < length && Character.isDigit(s.charAt(index))) {
                    temp = temp * 10 + (s.charAt(index) - '0');
                    index++;
                }
                total += temp * sign;
            }
        }
        return total;
    }

    /**
     * �ȴ�����ײ������, ���ײ�����ת���ɽ��, �ٴ����������
     */
    public int calculate1(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;

        while (index < stringBuffer.length()) {
            if (stringBuffer.charAt(index) == '(') {
                stack.push(index);
            }
            if (stringBuffer.charAt(index) == ')') {
                int start = stack.pop();
                String temp = stringBuffer.substring(start + 1, index);
                stringBuffer.delete(start, index + 1);
                String insert = "" + dual(temp);
                stringBuffer.insert(start, insert);
                index = start + insert.length() - 1;
            }
            index++;
        }
        return dual(stringBuffer.toString());
    }

    /**
     * �����������ڵı��ʽ
     */
    public int dual(String s) {
        int total = 0;
        int index = 0;
        int flag = 1;
        int temp = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (ch >= '0' && ch <= '9') {
                temp = temp * 10 + (int) (ch - '0');
            } else if (ch == '+') {
                total += flag * temp;
                temp = 0;
                flag = 1;
            } else if (ch == '-') {
                total += flag * temp;
                temp = 0;
                flag = -1;
                //�ж��Ƿ����'--'�����
                if (s.charAt(index + 1) == '-') {
                    flag = 1;
                    index++;
                }
            }
            index++;
        }
        return total + flag * temp;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1001"));
    }
}

