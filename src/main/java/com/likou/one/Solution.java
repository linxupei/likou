package com.likou.one;

import java.util.*;

class Solution {
    /**
     * 通过两点之间的斜率是否相同即可判断是否都在同一直线上
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];
        int length = coordinates.length;
        int temp = divisor(x,y);
        x /= temp;
        y /= temp;
        for (int i = 2; i < length; i++) {
            int tx = coordinates[i][0] - coordinates[0][0];
            int ty = coordinates[i][1] - coordinates[0][1];
            temp = divisor(tx, ty);
            tx /= temp;
            ty /= temp;
            if (ty != y || tx != x) {
                return false;
            }
        }
        return true;
    }


    public int divisor(int a, int b) {
        int temp;

        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}

