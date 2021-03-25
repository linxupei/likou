package com.likou.everyday;


import java.util.*;

public class Solution {

    /**
     * 普普通通删除重复结点
     */
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode tempHead = new ListNode();
        ListNode current = head;
        ListNode tempCurrent = tempHead;
        int val = 0;
        while (current != null) {
            val = current.val;
            if (current.next != null && current.next.val == val) {
                current = current.next;
                while (current != null && current.val == val) {
                    current = current.next;
                }
            } else {
                tempCurrent.next = current;
                current = current.next;
                tempCurrent = tempCurrent.next;
                tempCurrent.next = null;
            }
        }
        return tempHead.next;
    }

    /**
     * 普普通通删除重复结点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        ListNode current = tempHead.next;
        head = head.next;
        while (head != null) {
            if (current.val != head.val) {
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }
        current.next = null;
        return tempHead.next;
    }


    public static void main(String[] args) {

    }
}

