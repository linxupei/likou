package com.likou.everyday;


import java.util.*;

public class Solution {

    /**
     * 滑动窗口+TreeSet
     * abs(nums[i]-nums[j]) <= t, 即nums[j]落在区间[nums[i]-t, nums[i]+t]
     */
    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int length = nums.length;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            Long x = (long) nums[i];
            Long y = treeSet.ceiling(x - t);
            treeSet.add(x);
            if (y != null && y <= x + t) {
                return true;
            }
            if (i >= k) {
                treeSet.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    /**
     * 滑动窗口+桶排序(Hash表实现)
     * 设定桶的大小为t+1
     * nums[i] = (t+1) * a(桶编号) + b(0<b<t)
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        long w = t + 1;
        HashMap<Long, Long> hashMap = new HashMap<>(k / 3 * 4);
        for (int i = 0; i < length; i++) {
            long id = getID(nums[i], w);
            if (hashMap.containsKey(id)) {
                return true;
            }
            if (hashMap.containsKey(id - 1) && Math.abs(nums[i] - hashMap.get(id - 1)) <= t) {
                return true;
            }
            if (hashMap.containsKey(id + 1) && Math.abs(nums[i] - hashMap.get(id + 1)) <= t) {
                return true;
            }
            hashMap.put(id, (long) nums[i]);
            if (i >= k) {
                hashMap.remove(getID(nums[i-k], w));
            }
        }
        return false;
    }

    public static long getID(long x, long w) {
        if (x >= 0) {
           return x / w;
        }
        //正数从0开始分桶
        //负数从-1开始分桶
        return (x + 1) / w - 1;
    }

    /**
     * 滑动窗口+桶排序
     **/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
            if (i >= k) {
                hashSet.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3);
    }
}





