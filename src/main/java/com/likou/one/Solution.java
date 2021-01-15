package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {

    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone :
                stones) {
            unionFind.union(~stone[0], stone[1]);
            unionFind.union(stone[0]-10001, stone[1]);
            unionFind.union(stone[0]+10001, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    private class UnionFind {
        private Map<Integer, Integer> parent;

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

