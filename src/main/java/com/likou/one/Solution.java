package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ���ܹ�N������
     * ������λ���, ������
     * ��ÿ������Ϊһ��ͼ��һ�����
     * 1.һ�����������ڶ�Ӧ��λ����, ���뽻��(1-1)
     * 2.�������¸պý������, ����һ�μ���(2-1)
     * 3.��(��)�����¸��Դ�, �γ�ͷβ�����Ļ�, �轻������(n-1)
     * ʹ�ò��鼯, ���ܹ���n����ͨ����
     * ÿһ������һ����ͨ����(ni)
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
            // ʹ��һ�ַ�������
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

