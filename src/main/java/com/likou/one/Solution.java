package com.likou.one;

import com.sun.deploy.util.StringUtils;
import netscape.security.UserTarget;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    /**
     * ���ҵ�����ת�ĵ�һ������ǰһ��λ��, ����ʹ��ͷ���뷨, ���뱻��ת�ķ�Χ���
     * ���������û����ת�Ľ��
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (right - left < 1) {
            return head;
        }
        ListNode tempHead = new ListNode();
        ListNode result = tempHead;
        tempHead.next = head;
        for (int i = 0; i < left - 1; i++) {
            tempHead = tempHead.next;
        }
        ListNode last = tempHead.next;
        ListNode leftHead = tempHead.next;
        tempHead.next = null;
        while (left <= right) {
            ListNode temp = leftHead;
            leftHead = leftHead.next;
            temp.next = tempHead.next;
            tempHead.next = temp;
            left++;
        }
        last.next = leftHead;
        return result.next;
    }

    /**
     * ֱ��ͷ�����뷨����
     */
    public ListNode reverseList1(ListNode head) {
        ListNode tempHead = new ListNode();
        tempHead.next = null;
        ListNode result = tempHead;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = tempHead.next;
            tempHead.next = temp;
        }
        return result.next;
    }

    /**
     * ��������Ϊ1->2->3->4->5->6->null
     * ��������һ����֮��1->2-3->6<-5<-4
     * Ҫʹ6ָ��3, ��3.next.next=3;
     * ����3.next=null
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
    }
}

