package com.likou.one;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 使用二分查找法+深度优先遍历
     */
    private static final int[][] directions = new int[][] {{-1, 0},{1, 0},{0, -1},{0, 1}};
    private static int N;

    public static int swimInWater(int[][] grid) {
        N = grid.length;
        int[] index = new int[N*N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                index[grid[i][j]] = getIndex(i, j);
            }
        }

        UnionFind unionFind = new UnionFind(N * N);
        for (int i = 0; i < index.length; i++) {
            int x = index[i] / N;
            int y = index[i] % N;
            for (int k = 0; k < 4; k++) {
                int tx = x + directions[k][0];
                int ty = y + directions[k][1];
                if (border(tx, ty) && grid[tx][ty] <= i) {
                    unionFind.union(index[i], getIndex(tx, ty));
                }
            }
            if (unionFind.isConnected(0, N*N-1)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 广度优先遍历
     * @param grid 网格
     * @param threshold 阈值
     * @return 是否满足条件
     */
    public static boolean bfs(int[][] grid, int threshold) {
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int k = 0; k < 4; k++) {
                int tx = position[0] + directions[k][0];
                int ty = position[1] + directions[k][1];
                if (border(tx, ty) && !visited[tx][ty] && grid[tx][ty] <= threshold) {
                    if (tx == N - 1 && ty == N - 1) {
                        return true;
                    }
                    queue.offer(new int[]{tx, ty});
                    visited[tx][ty] = true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先遍历, 遍历当前结点的邻接结点
     * @param grid 网格
     * @param visited 格子遍历情况
     * @param x 坐标
     * @param y 坐标
     * @param threshold 阈值
     * @return 是否满足条件
     */
    public static boolean dfs(int[][] grid, boolean[][] visited, int x, int y, int threshold) {
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int tx = x + directions[k][0];
            int ty = y + directions[k][1];
            if (border(tx, ty) && !visited[tx][ty] && grid[tx][ty] <= threshold) {
                if (tx == N - 1 && ty == N - 1) {
                    return true;
                }
                if (dfs(grid, visited, tx, ty, threshold)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean border(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    //将二维表格转化为一维表格
    public static int getIndex(int x, int y) {
        return x * N + y;
    }

    static class UnionFind {
        private int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        //判断两个位置是否拥有同一个根节点, 即是否连通
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int p, int q) {
            if (isConnected(p, q)) {
                return;
            }
            parent[find(p)] = find(q);
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{10,12,4,6},{9,11,3,5},{1,7,13,8},{2,0,15,14}};
        swimInWater(grid);
    }
}

