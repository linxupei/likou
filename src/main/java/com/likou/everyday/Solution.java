package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    /**
     * 穿过最少的砖块数即穿过最多的缝隙数
     * 统计每一块砖右边界到墙的左边界的距离
     * 找出最多的那一个缝隙
     */
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (List<Integer> list : wall) {
            int dis = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                dis  += list.get(i);
                hashMap.put(dis, hashMap.getOrDefault(dis, 0) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return wall.size() - max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.getImportance(new int[]{2, 2, 3, 2}));
    }
}





