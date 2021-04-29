package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    /**
     * 位进制
     * 由于数组中的元素都在int范围内, 可以依次计算答案的每一个二进制位是0还是1
     * 答案的第i个二进制位, 可能为0或1, 而非答案的元素, 每一个元素都出现了3次,
     * 对应着第i个二进制位的 3个0 或 3个1, 因此答案的第i个二进制位就是数组所有元素
     * 的第i个二进制位除以3的余数
     */
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ret |= (1 << i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{2, 2, 3, 2}));
    }
}





