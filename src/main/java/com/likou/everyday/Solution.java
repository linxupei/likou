package com.likou.everyday;



public class Solution {

    /**
     * 分析可得同一种颜色兔子说的数字n最多只能有n+1次
     * 当超过n+1时要考虑作为另外一种兔子,因此同一个数字最多有
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

