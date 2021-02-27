package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    /**
     * 使用二进制方法表示
     */
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> result = new LinkedList<>();
        HashMap<Integer, Integer> frequent = new HashMap<>();
        //找出每一个谜底对应的二进制数, 将相同的合并, 频率加1
        for (String word : words) {
            int length = word.length();
            int mask = 0;
            for (int i = 0; i < length; i++) {
                mask |= (1 << (word.charAt(i)-'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequent.put(mask, frequent.getOrDefault(mask, 0) + 1);
            }
        }
        for (String puzzle : puzzles) {
            int length = puzzle.length();
            int count = 0;
            int mask = 0;
            for (int i = 1; i < length; i++) {
                mask |= (1 << (puzzle.charAt(i)-'a'));
            }
            int subset = mask;
            //找二进制子集普通方法
            do {
                //使每一个二进制子集, 都包含谜面首字母
                int s = subset | (1 << (puzzle.charAt(0)-'a'));
                if (frequent.containsKey(s)) {
                    count += frequent.get(s);
                }
                subset = (subset-1) & mask;
            } while (subset != mask);
            result.add(count);
        }
        return result;
    }

    /**
     * 暴力不可取, 超时需谨慎
     */
    public static List<Integer> findNumOfValidWords_1(String[] words, String[] puzzles) {
        int pLength  = puzzles.length;
        int wLength = words.length;
        List<Integer> result = new LinkedList<>();
        boolean[][] keywords = new boolean[pLength][26];
        boolean[][] wordFrequents = new boolean[wLength][26];
        //统计每一个puzzle所含有的字母
        for (int i = 0; i < pLength; i++) {
            int length = puzzles[i].length();
            for (int j = 0; j < length; j++) {
                keywords[i][puzzles[i].charAt(j)-'a'] = true;
            }
        }
        //统计每一个word包含的字母
        for (int i = 0; i < wLength; i++) {
            int length = words[i].length();
            for (int j = 0; j < length; j++) {
                wordFrequents[i][words[i].charAt(j)-'a'] = true;
            }
        }
        for (int i = 0; i < pLength; i++) {
            int count = 0;
            char first = puzzles[i].charAt(0);
            for (int j = 0; j < wLength; j++) {
                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    if (wordFrequents[j][k] && wordFrequents[j][k] != keywords[i][k]) {
                        flag = false;
                        break;
                    }
                }
                if (flag && wordFrequents[j][first-'a']) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
//        int mask = 0;
//        String str = "aboveyz";
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            int temp = (1 << (ch - 'a'));
//            mask |= temp;
//        }
//        int subset = mask;
//        do {
//            subset = (subset - 1) & mask;
//        } while (subset != mask);
//        System.out.println(mask);
        System.out.println(findNumOfValidWords(
                new String[]{"aaaa","asas","able","ability","actt","actor","access"},
                new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}));
    }
}

