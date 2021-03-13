package com.likou.one;

import com.sun.deploy.util.StringUtils;
import netscape.security.UserTarget;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    /**
     * ÆÕÍ¨µÄ¹þÏ£Ó³Éä
     */
    class MyHashMap {
        private static final int BASE = 769;
        private LinkedList[] data;

        /** Initialize your data structure here. */
        public MyHashMap() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                data[i] = new LinkedList<int []>();
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = hash(key);
            Iterator iterator = data[hash].iterator();
            for (Object o : data[hash]) {
                int[] next = (int []) o;
                if (next[0] == key) {
                    data[hash].remove(next);
                }
            }
            data[hash].offerLast(new int[]{key, value});
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash = hash(key);
            Iterator iterator = data[hash].iterator();
            for (Object o : data[hash]) {
                int[] next = (int []) o;
                if (next[0] == key) {
                    return next[1];
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash = hash(key);
            Iterator iterator = data[hash].iterator();
            for (Object o : data[hash]) {
                int[] next = (int []) o;
                if (next[0] == key) {
                    data[hash].remove(next);
                    return;
                }
            }
        }

        public int hash(int key) {
            return key % BASE;
        }
    }

    public static void main(String[] args) {

    }
}

