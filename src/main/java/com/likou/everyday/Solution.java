package com.likou.everyday;


import java.util.*;

public class Solution {

    /**
     * 先统计长度, 然后找到断点(count - (k % count))
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tempHead = head;
        ListNode result = new ListNode();
        ListNode tail = null;
        int count = 0;
        while (tempHead != null) {
            tail = tempHead;
            tempHead = tempHead.next;
            count++;
        }
        int changeCount = k % count;
        if (changeCount == 0) {
            return head;
        }
        tempHead = head;
        for (int i = 1; i < count - changeCount; i++) {
            tempHead = tempHead.next;
        }
        result.next = tempHead.next;
        tempHead.next = null;
        tail.next = head;
//        tempHead = result.next;
//        while (tempHead != null && tempHead.next != null) {
//            tempHead = tempHead.next;
//        }
//        tempHead.next = head;
        return result.next;
    }


    public static void main(String[] args) {

    }
}

