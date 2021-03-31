package com.likou.everyday;


import java.util.*;



public class Solution {
    /**
     * 采用地板除法
     * N * (N-1) / (N-2) = N + 1;
     * N * (N-1) / (N-2) + (N-3) - (N-4) * (N-5) / (N-6)
     * (N-3) == (N-4) * (N-5) / (N-6), 后面没四项都为0
     */
    public static int clumsy(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }

    /**
     * 遍历每一个数字, 使用flag作为判断运算符标志
     */
    public static int clumsy1(int N) {
        int result = 0;
        int flag = 0;
        int temp = 1;
        for (int i = N; i > 0; i--) {
            switch (flag++ % 4) {
                case 0:
                case 1:
                    temp *= i;
                    break;
                case 2:
                    temp /= i;
                    result += temp;
                    temp = -1;
                    break;
                case 3:
                    result += i;
                    break;
                default:
                    break;
            }
        }
        //当flag等于1或者2时说明result还没有进行相加就退出循环了,因此需要加回来
        if (flag % 4 < 3 && flag % 4 > 0) {
            result += temp;
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(clumsy(4));
    }
}

