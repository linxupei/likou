package com.likou.one;

import java.util.*;

class Solution {
    /**
     * 通过分析题意, 可知该题在求以石子构成的图所拥有的连通分量的个数
     * 每一个连通分量代表这一部分的石子最后能移除至只剩一个石子
     * 因此返回的结果就是: 所有的石子的数量-连通分量的个数
     *
     * 而通过并查集, 则可以快速找出石子之间关系, 找出连通分量个数
     */
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone :
                stones) {
            unionFind.union(~stone[0], stone[1]);
            //unionFind.union(stone[0]-10001, stone[1]);
            //unionFind.union(stone[0]+10001, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    private class UnionFind {
        private Map<Integer, Integer> parent;
        //连通分量个数
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                //并查集集中新加入一个结点, 结点的父亲是它自己, 所以联通分量的总数+1
                count++;
            }

            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }

            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent.put(rootX, rootY);
            count--;
        }
    }

    public static void main(String[] args) {

    }
}

