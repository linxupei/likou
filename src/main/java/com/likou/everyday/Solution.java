package com.likou.everyday;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    /**
     * 注意: 不需要实现NestedInteger接口, 注意题目说明
     * 使用深度优先遍历将所有数据存储到列表即可
     * 使用ArrayList是因为测试数据更多使用next()函数, 获取数据时间复杂度为O(1)
     */
    public class NestedIterator implements Iterator<Integer> {
        List<Integer> integerList;
        Integer index;

        public NestedIterator(List<NestedInteger> nestedList) {
            index = 0;
            integerList = new ArrayList<>();
            getList(integerList, nestedList);
        }

        public void getList(List<Integer> integerList, List<NestedInteger> nestedList) {
            for (NestedInteger nested : nestedList) {
                if (nested.isInteger()) {
                    integerList.add(nested.getInteger());
                } else {
                    getList(integerList, nested.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return integerList.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < integerList.size();
        }
    }


    public static void main(String[] args) {

    }
}

