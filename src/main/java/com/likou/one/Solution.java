package com.likou.one;

import netscape.security.UserTarget;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

    /**
     * 先处理'*','/', 再处理'+','-',
     * 用preSign记录上一个符号
     * 要注意处理最后一个数字
     */
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';
        int n = s.length();
        int num = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                num = 0;
                preSign = ch;
            }
        }
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }


    public static void main(String[] args) {
        System.out.println(calculate("1 + 2 * 3"));
    }
}

