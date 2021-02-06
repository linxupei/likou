package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 将所有小于x的结点放入listNode1
     * 其余放入listNode2
     * 最后合并两个链表即可
     * 此方法不会改变原链表
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode();
        ListNode listNode1 = head1;
        ListNode head2 = new ListNode();
        ListNode listNode2 = head2;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                listNode1.next = new ListNode(temp.val);
                listNode1 = listNode1.next;
            } else {
                listNode2.next = new ListNode(temp.val);
                listNode2 = listNode2.next;
            }
            temp = temp.next;
        }
        listNode1.next = head2.next;
        return head1.next;
    }

    public static void main(String[] args) {

    }
}

