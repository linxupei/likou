package com.likou.everyday;


import java.util.*;



public class Solution {

    /**
     * �ݹ�汾
     * �жϵ�ǰ�����Ƿ�����һ��������ͬ, ����û��ѡ����һ������
     * ��Ϊtrue, ˵�����Ӽ��Ѿ������ɹ�
     * ���������Ӽ�, ɸѡ�Ӽ�
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
        //�жϵ�ǰ�����Ƿ�����һ��������ͬ, ����û��ѡ����һ������
        //
        //�������1101(1,2,2), ��ǰ���Ȼ�Ѿ���һ����ͬ�Ӽ�111(1,2,2)
        //((i >> (j-1)) & 1) == 0�ж���һ�������Ƿ�ѡ��
        if (!choosePre && start > 0 && nums[start - 1] == nums[start]) {
            return;
        }
        clr.add(nums[start]);
        dfs_subsets(results, clr, true, nums, start + 1);
        clr.remove(clr.size() - 1);
    }

    /**
     * �ǵݹ�汾
     * �жϵ�ǰ�����Ƿ�����һ��������ͬ, ����û��ѡ����һ������
     * ��Ϊtrue, ˵�����Ӽ��Ѿ������ɹ�
     * ���������Ӽ�, ɸѡ�Ӽ�
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
                //�жϵ�ǰ������λ�Ƿ�Ϊ1
                //����1˵��ѡ����±�
                if (((i >> j) & 1) != 0) {
                    //nums = 1,2,2,2
                    //�жϵ�ǰ�����Ƿ�����һ��������ͬ, ����û��ѡ����һ������
                    //
                    //�������1101(1,2,2), ��ǰ���Ȼ�Ѿ���һ����ͬ�Ӽ�111(1,2,2)
                    //((i >> (j-1)) & 1) == 0�ж���һ�������Ƿ�ѡ��
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
     * �ǵݹ�汾, �оٳ��������, ʹ��hashsetȥ���ظ�
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
                //�жϵ�ǰ������λ�Ƿ�Ϊ1
                //����1˵��ѡ����±�
                if (t == 1) {
                    clr.add(nums[j]);
                }
            }
            results.add(new ArrayList<>(clr));
        }
        return new ArrayList<>(results);
    }

    /**
     * �ݹ�汾, �оٳ��������, ʹ��hashsetȥ���ظ�
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
        //����Ӹ��±�Ԫ��
        List<Integer> list1 = new ArrayList<>(subset);
        subsets.add(list1);
        getSubset(subsets, list1, nums, start+1);

        //��Ӹ��±�Ԫ��
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
        // ѡ��ǰλ�õ�Ԫ�أ����¾���
        subset.add(nums[start]);
        getSubset1(subsets, subset, nums, start + 1);

        // ��ѡ��ǰλ�õ�Ԫ�أ����ݣ������¾���
        subset.remove(subset.size() - 1);
        getSubset1(subsets, subset, nums, start + 1);
    }



    public static void main(String[] args) {
        subsetsWithDup(new int[] {1, 2, 2, 3});
    }
}

