package com.likou.everyday;


import java.util.*;



public class Solution {

    /**
     * 递归版本
     * 判断当前数字是否与上一个数字相同, 并且没有选择上一个数字
     * 若为true, 说明该子集已经被生成过
     * 遍历所有子集, 筛选子集
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> clr = new ArrayList<>();
        dfs_subsets(results, clr, false, nums, 0);
        return results;
    }

    public void dfs_subsets(List<List<Integer>> results, List<Integer> clr, boolean choosePre, int[] nums, int start) {
        if (start >= nums.length) {
            results.add(new ArrayList<>(clr));
        }
        dfs_subsets(results, clr, false, nums, start + 1);
        //nums = 1,2,2,2
        //判断当前数字是否与上一个数字相同, 并且没有选择上一个数字
        //
        //如二进制1101(1,2,2), 则前面必然已经有一个相同子集111(1,2,2)
        //((i >> (j-1)) & 1) == 0判断上一个数字是否被选择
        if (!choosePre && start > 0 && nums[start - 1] == nums[start]) {
            return;
        }
        clr.add(nums[start]);
        dfs_subsets(results, clr, true, nums, start + 1);
        clr.remove(clr.size() - 1);
    }

    /**
     * 非递归版本
     * 判断当前数字是否与上一个数字相同, 并且没有选择上一个数字
     * 若为true, 说明该子集已经被生成过
     * 遍历所有子集, 筛选子集
     */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> clr = new ArrayList<>();
        int length = nums.length;
        int mask = 1 << length;
        Arrays.sort(nums);
        boolean flag = true;
        for (int i = 0; i < mask; i++) {
            flag = true;
            clr.clear();
            for (int j = 0; j < length; j++) {
                //判断当前二进制位是否为1
                //等于1说明选择该下标
                if (((i >> j) & 1) != 0) {
                    //nums = 1,2,2,2
                    //判断当前数字是否与上一个数字相同, 并且没有选择上一个数字
                    //
                    //如二进制1101(1,2,2), 则前面必然已经有一个相同子集111(1,2,2)
                    //((i >> (j-1)) & 1) == 0判断上一个数字是否被选择
                    if (j > 0 && ((i >> (j-1)) & 1) == 0 && nums[j] == nums[j-1]) {
                        flag = false;
                        break;
                    }
                    clr.add(nums[j]);
                }
            }
            if (flag) {
                results.add(new ArrayList<>(clr));
            }
        }
        return results;
    }

    /**
     * 非递归版本, 列举出所有组合, 使用hashset去除重复
     */
    public static List<List<Integer>> subsetsWithDup11(int[] nums) {
        HashSet<List<Integer>> results = new HashSet<>();
        List<Integer> clr = new ArrayList<>();
        int length = nums.length;
        int mask = 1 << length;
        Arrays.sort(nums);
        for (int i = 0; i < mask; i++) {
            clr.clear();
            for (int j = 0; j < length; j++) {
                int t = (i >> j) & 1;
                //判断当前二进制位是否为1
                //等于1说明选择该下标
                if (t == 1) {
                    clr.add(nums[j]);
                }
            }
            results.add(new ArrayList<>(clr));
        }
        return new ArrayList<>(results);
    }

    /**
     * 递归版本, 列举出所有组合, 使用hashset去除重复
     */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        HashSet<List<Integer>> subsets = new HashSet<>();
        Arrays.sort(nums);
        getSubset(subsets, new ArrayList<>(), nums, 0);
        List<List<Integer>> results = new ArrayList<>(subsets);
        return results;
    }

    public void getSubset(HashSet<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {
        if (start >= nums.length) {
            return;
        }
        //不添加该下标元素
        List<Integer> list1 = new ArrayList<>(subset);
        subsets.add(list1);
        getSubset(subsets, list1, nums, start+1);

        //添加该下标元素
        List<Integer> list2 = new ArrayList<>(subset);
        list2.add(nums[start]);
        subsets.add(list2);
        getSubset(subsets, list2, nums, start+1);
    }

    public void getSubset1(HashSet<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {
        if (start >= nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        // 选择当前位置的元素，往下决策
        subset.add(nums[start]);
        getSubset1(subsets, subset, nums, start + 1);

        // 不选当前位置的元素（回溯），往下决策
        subset.remove(subset.size() - 1);
        getSubset1(subsets, subset, nums, start + 1);
    }



    public static void main(String[] args) {
        subsetsWithDup(new int[] {1, 2, 2, 3});
    }
}

