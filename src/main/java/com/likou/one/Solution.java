package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 设总共N对情侣
     * 分析座位情况, 有三种
     * 以每对情侣为一个图的一个结点
     * 1.一对情侣已坐在对应的位置上, 无须交换(1-1)
     * 2.两对情侣刚好交错分坐, 交换一次即可(2-1)
     * 3.三(多)对情侣各自错开, 形成头尾相连的环, 需交换两次(n-1)
     * 使用并查集, 设总共有n个连通分量
     * 每一个环即一个连通分量(ni)
     * (n1-1)+(n2-1)+...+(ni-1) = N-n;
     */
    public static int minSwapsCouples(int[] row) {
        int length = row.length;
        int n = length >> 1;
        FindUnion findUnion = new FindUnion(n);
        for (int i = 0; i < n; i+=2) {
            findUnion.union(row[i]>>1, row[i+1]>>1);
        }
        return n- findUnion.getCount();
    }

    static class FindUnion {
        int count;
        int[] parent;

        FindUnion(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (x != parent[x]) {
                x = find(parent[x]);
            }
            // 使用一种方法即可
            // while (x != parent[x]) {
            //     parent[x] = parent[parent[x]];
            //     x = parent[x];
            // }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(minSwapsCouples(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}

