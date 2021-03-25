package com.likou.everyday;


import java.util.*;

public class Solution {

    /**
     * ����ͨͨɾ���ظ����
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

