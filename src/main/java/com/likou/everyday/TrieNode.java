package com.likou.everyday;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/4/14 7:18
 * @describe 前缀树结点
 */
public class TrieNode {
    public TrieNode[] next;
    public boolean isLast;
    public int size;
    TrieNode() {}

    TrieNode(int size) {
        this.size = size;
        next = new TrieNode[size];
    }
}
