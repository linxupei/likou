package com.likou.everyday;


import java.util.*;



public class Solution {
    /**
     * ���õذ����
     * N * (N-1) / (N-2) = N + 1;
     * N * (N-1) / (N-2) + (N-3) - (N-4) * (N-5) / (N-6)
     * (N-3) == (N-4) * (N-5) / (N-6), ����û���Ϊ0
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
     * ����ÿһ������, ʹ��flag��Ϊ�ж��������־
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
        //��flag����1����2ʱ˵��result��û�н�����Ӿ��˳�ѭ����,�����Ҫ�ӻ���
        if (flag % 4 < 3 && flag % 4 > 0) {
            result += temp;
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(clumsy(4));
    }
}

