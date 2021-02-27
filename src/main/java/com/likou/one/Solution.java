package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    /**
     * ����+��������
     * ����������Ϊ�ַ���Сд��ĸ����
     */
    public static int longestSubstring(String s, int k) {
        int result = 0;
        int length = s.length();
        for (int i = 1; i <= 26; i++) {
            int l = 0, r = 0;
            //ͳ��[l, r]�������ĸƵ��
            int[] frequent = new int[26];
            //�ܵ�����
            int total = 0;
            //����k������
            int less = 0;
            while (r < length) {
                int index = s.charAt(r)-'a';
                frequent[index]++;
                //����һ��ȫ�µ�����
                if (frequent[index] == 1) {
                    total++;
                    less++;
                }
                //�������ﵽ����ͱ�׼
                if (frequent[index] == k) {
                    less--;
                }
                while (total > i) {
                    index = s.charAt(l)-'a';
                    frequent[index]--;
                    //��������޷��ﵽ��ͱ�׼
                    if (frequent[index] == k-1) {
                        less++;
                    }
                    //������౻�Ƴ���
                    if (frequent[index] == 0) {
                        total--;
                        less--;
                    }
                    l++;
                }
                //û��һ�������޷��ﵽ��׼
                if (less == 0) {
                    result = Math.max(result, r-l+1);
                }
                r++;
            }
        }
        return result;
    }

    /**
     * ����, ÿһ������k�ε���ĸ��������Ϊһ���ָ���, ���ַ����ָ������ɲ���
     */
    public static int longestSubstring_(String s, int k) {
        int length = s.length();
        return dfs(s, 0, length-1, k);
    }

    public static int dfs(String s, int l, int r, int k) {
        int[] frequent = new int[26];
        //ͳ��ĳһ���Ӵ�����ĸ����
        for (int i = l; i <= r; i++) {
            frequent[s.charAt(i)-'a']++;
        }

        //�ҵ�һ���ָ���
        //ע: Ϊʲô�����ҵ�һ���ָ���?
        //�����Ӵ����ܹ���, ���ں����ĵݹ���, ������ҷָ�, ��˲���
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (frequent[i] > 0 && frequent[i] < k) {
                split = (char) (i+'a');
                break;
            }
        }

        //��û�зָ���, ˵����ǰ�Ӵ�����Ҫ��
        if (split == 0) {
            return r-l+1;
        }

        int i = l;
        int result = 0;
        while (i <= r) {
            //�ҵ�һ���Ƿָ�����λ��
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            int length = dfs(s, start, i-1, k);
            result = Math.max(length, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("ababbc", 2));
    }
}

