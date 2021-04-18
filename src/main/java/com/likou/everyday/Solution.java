package com.likou.everyday;


import java.util.*;

public class Solution {
    /**
     * 使用快慢指针即可
     */
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 当遇到非目标值, 把结点放入新链表, 并与原链表断开即可
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        ListNode pre = null;
        while (head != null) {
            pre = head;
            if (head.val != val) {
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
            pre.next = null;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        removeElement(new int[]{1,5,9,9}, 1);
    }
}





