package com.likou.everyday;


import lombok.extern.java.Log;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.regex.Matcher;

public class Solution {

    public static void main(String[] args) {

    }
}


class Trie {

    static class TrieNode {
        public TrieNode[] next;
        public boolean isLast;
        public int size;
        TrieNode() {}

        TrieNode(int size) {
            this.size = size;
            next = new TrieNode[size];
        }
    }

    private static final int SIZE = 26;

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(SIZE);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        int length = chars.length;
        TrieNode p = root;
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            TrieNode child = p.next[ch - 'a'];
            if (child == null) {
                TrieNode node = new TrieNode(SIZE);
                p.next[ch - 'a'] = node;
                p = node;
            } else {
                p = child;
            }
        }
        p.isLast = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isLast;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }

    public TrieNode find(String word) {
        char[] chars = word.toCharArray();
        int length = chars.length;
        TrieNode p = root;
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            TrieNode child = p.next[ch - 'a'];
            if (child == null) {
                return null;
            } else {
                p = child;
            }
        }
        return p;
    }
}

