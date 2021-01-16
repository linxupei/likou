package com.likou.one;

import java.util.*;

class Solution {
    /**
     * 击碎砖块, 将一个连通分量变成两个连通分量
     * 而并查集将两个连通分量合并成一个连通分量
     */

    private int rows;
    private int cols;

    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        rows = grid.length;
        cols = grid[0].length;

        //第一步,把网格中相应的砖块击碎
        int [][]copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        for (int[] hit :
                hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        //第二步,建图,把砖块与砖块之间的连接关系输入并查集, size表示网格大小, 表示虚拟的屋顶在并查集中的编号
        int size = rows * cols;
        UnionFind unionFind = new UnionFind(size + 1);
        //将第一行与屋顶连接
        for (int i = 0; i < cols; i++) {
            if (copy[0][i] == 1) {
                unionFind.union(i, size);
            }
        }
        //其余网格, 看一下上方和左边有没有砖块
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (copy[i][j] == 1) {
                    //判断上方是否有砖块
                    if (copy[i - 1][j] == 1) {
                        unionFind.union(getIndex(i - 1, j), getIndex(i, j));
                    }
                    //判断左方是否有砖块
                    if (j > 0 && copy[i][j - 1] == 1) {
                        unionFind.union(getIndex(i, j - 1), getIndex(i, j));
                    }
                }
            }
        }

        //第三步, 逆序补回被敲掉的砖块, 把每一次因为补回砖块而与屋顶相连的砖块的增量记录到 res 数组中
        int hitLength = hits.length;
        int []res = new int[hitLength];
        for (int i = hitLength-1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];

            //若原网格中该位置本就不存在砖块, 则不需要进行任何操作
            if (grid[x][y] == 0) {
                continue;
            }

            //获取未连接前的与屋顶连接(包含间接连接)的砖块数量
            int origin = unionFind.getSize(size);

            //若该砖块与屋顶直接连接, 则在并查集中说明
            if (x == 0) {
                unionFind.union(y, size);
            }

            //查看该砖块四面是否有砖块, 有则连接
            for (int[] location :
                    DIRECTIONS) {
                int nx = x + location[0];
                int ny = y + location[1];
                if (inArea(nx, ny) && copy[nx][ny] == 1) {
                    unionFind.union(getIndex(x, y), getIndex(nx, ny));
                }
            }

            int current = unionFind.getSize(size);

            // 减去的 1 是逆向补回的砖块（正向移除的砖块），与 0 比较大小，是因为存在一种情况，添加当前砖块，不会使得与屋顶连接的砖块数更多
            res[i] = Math.max(0, current-origin-1);

            //补上砖块
            copy[x][y] = 1;
        }
        return res;
    }

    /**
     * 输入坐标在二维网格中是否越界
     */
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    /**
     * 二维坐标转换为一维坐标
     */
    private int getIndex(int x, int y) {
        return x * cols + y;
    }

    private class UnionFind {
        //当前结点的父亲结点
        private int[] parent;

        //以当前结点为根节点的子树的结点总数
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * 路径压缩, 只要求每个不相交集合的根节点的子树包含的结点总数数值正确即可,
         * 因此在路径压缩的过程中不用维护数组size
         */
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            //在合并时维护数组size
            size[rootY] += size[rootX];
        }

        /**
         * 在并查集的根节点的子树包含的结点总数
         */
        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }

    public static void main(String[] args) {
        int [][]grid = new int[][] {
                {1,1,1},{0,1,0},{0,0,0}
        };
        int [][]hits = new int[][] {
                {0,2},{2,0},{0,1},{1,2}
        };
    }
}

