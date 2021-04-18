package com.likou.everyday;


import java.util.*;

public class Solution {
    /**
     * ʹ�ÿ���ָ�뼴��
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
     * ��������Ŀ��ֵ, �ѽ�����������, ����ԭ����Ͽ�����
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





