package com.likou.one;

import java.util.*;

class Solution {
    /**
     * ����ש��, ��һ����ͨ�������������ͨ����
     * �����鼯��������ͨ�����ϲ���һ����ͨ����
     */

    private int rows;
    private int cols;

    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        rows = grid.length;
        cols = grid[0].length;

        //��һ��,����������Ӧ��ש�����
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

        //�ڶ���,��ͼ,��ש����ש��֮������ӹ�ϵ���벢�鼯, size��ʾ�����С, ��ʾ������ݶ��ڲ��鼯�еı��
        int size = rows * cols;
        UnionFind unionFind = new UnionFind(size + 1);
        //����һ�����ݶ�����
        for (int i = 0; i < cols; i++) {
            if (copy[0][i] == 1) {
                unionFind.union(i, size);
            }
        }
        //��������, ��һ���Ϸ��������û��ש��
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (copy[i][j] == 1) {
                    //�ж��Ϸ��Ƿ���ש��
                    if (copy[i - 1][j] == 1) {
                        unionFind.union(getIndex(i - 1, j), getIndex(i, j));
                    }
                    //�ж����Ƿ���ש��
                    if (j > 0 && copy[i][j - 1] == 1) {
                        unionFind.union(getIndex(i, j - 1), getIndex(i, j));
                    }
                }
            }
        }

        //������, ���򲹻ر��õ���ש��, ��ÿһ����Ϊ����ש������ݶ�������ש���������¼�� res ������
        int hitLength = hits.length;
        int []res = new int[hitLength];
        for (int i = hitLength-1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];

            //��ԭ�����и�λ�ñ��Ͳ�����ש��, ����Ҫ�����κβ���
            if (grid[x][y] == 0) {
                continue;
            }

            //��ȡδ����ǰ�����ݶ�����(�����������)��ש������
            int origin = unionFind.getSize(size);

            //����ש�����ݶ�ֱ������, ���ڲ��鼯��˵��
            if (x == 0) {
                unionFind.union(y, size);
            }

            //�鿴��ש�������Ƿ���ש��, ��������
            for (int[] location :
                    DIRECTIONS) {
                int nx = x + location[0];
                int ny = y + location[1];
                if (inArea(nx, ny) && copy[nx][ny] == 1) {
                    unionFind.union(getIndex(x, y), getIndex(nx, ny));
                }
            }

            int current = unionFind.getSize(size);

            // ��ȥ�� 1 �����򲹻ص�ש�飨�����Ƴ���ש�飩���� 0 �Ƚϴ�С������Ϊ����һ���������ӵ�ǰש�飬����ʹ�����ݶ����ӵ�ש��������
            res[i] = Math.max(0, current-origin-1);

            //����ש��
            copy[x][y] = 1;
        }
        return res;
    }

    /**
     * ���������ڶ�ά�������Ƿ�Խ��
     */
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    /**
     * ��ά����ת��Ϊһά����
     */
    private int getIndex(int x, int y) {
        return x * cols + y;
    }

    private class UnionFind {
        //��ǰ���ĸ��׽��
        private int[] parent;

        //�Ե�ǰ���Ϊ���ڵ�������Ľ������
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
         * ·��ѹ��, ֻҪ��ÿ�����ཻ���ϵĸ��ڵ�����������Ľ��������ֵ��ȷ����,
         * �����·��ѹ���Ĺ����в���ά������size
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
            //�ںϲ�ʱά������size
            size[rootY] += size[rootX];
        }

        /**
         * �ڲ��鼯�ĸ��ڵ�����������Ľ������
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

