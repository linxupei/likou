package com.likou.everyday;



public class Solution {

    /**
     * �����ɵ�ͬһ����ɫ����˵������n���ֻ����n+1��
     * ������n+1ʱҪ������Ϊ����һ������,���ͬһ�����������
     * (Math.ceil((double)frequency[i] / (i + 1)) * (i + 1))
     */
    public static int numRabbits(int[] answers) {
        int length = answers.length;
        if (length == 0) {
            return 0;
        }
        int result = 0;
        int[] frequency = new int[1000];
        for (int answer : answers) {
            frequency[answer]++;
        }
        for (int i = 0; i < 1000; i++) {
            if (frequency[i] > 0) {
//                if (frequency[i] >= i + 1) {
//                    result += (frequency[i] / (i + 1) * (i + 1));
//                }
//                if (frequency[i] % (i + 1) != 0) {
//                    result += i + 1;
//                }
                result += Math.ceil((double)frequency[i] / (i + 1)) * (i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        numRabbits(new int[]{0,0,1,1,1});
    }
}

