package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {

    int ans = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        int[] em = new int[k];
        dfs(em, jobs, 0, 0, 0);
        return ans;
    }

    /**
     *
     * @param em 各个工人的工作时长
     * @param jobs 每一份工作消耗的时间
     * @param index 当前的工作下标
     * @param max 当前工人中最大时长
     * @param used 对 max >= ans,
     */
    public void dfs(int[] em, int[] jobs, int index, int max, int used) {
        if (max >= ans) {
            return;
        }
        if (index == jobs.length) {
            ans = Math.min(ans, max);
            return;
        }

        // 此为朴素dfs
        // for (int i = 0; i < em.length; i++) {
        //     em[i] += jobs[index];
        //     dfs(em, jobs, index + 1, Math.max(max, em[i]));
        //     em[i] -= jobs[index];
        // }

        //当有工人还没有工作时, 先优先为他安排一份工作
        if (used < em.length) {
            em[used] = jobs[index];
            dfs(em, jobs, index + 1, Math.max(max, em[used]), used + 1);
            em[used] = 0;
        }

        for (int i = 0; i < used; i++) {
            em[i] += jobs[index];
            dfs(em, jobs, index + 1, Math.max(max, em[i]), used);
            em[i] -= jobs[index];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumTimeRequired(new int[]{1,2,3}, 1));
    }
}





