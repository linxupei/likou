package com.likou.everyday;


import java.util.*;

public class Solution {

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

