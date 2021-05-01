package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {

    /**
     * 将每一个员工信息保存在哈希表中, 以便快速查询
     * 通过深度优先遍历计算相应的员工链重要度总和
     */
    public int getImportance(List<Employee> employees, int id) {
        int size = employees.size();
        HashMap<Integer, Employee> hashMap = new HashMap<>(size);
        for (Employee employee : employees) {
            hashMap.put(employee.id, employee);
        }
        return getImportance(hashMap, id);
    }

    /**
     * 深度优先遍历
     */
    public int getImportance(HashMap<Integer, Employee> hashMap, int id) {
        Employee employee = hashMap.get(id);
        //基本问题, 当没有相应员工时, 返回重要度0
        if (employee == null) {
            return 0;
        }
        int ret = employee.importance;
        for (int subordinate : employee.subordinates) {
            ret += getImportance(hashMap, subordinate);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.getImportance(new int[]{2, 2, 3, 2}));
    }
}





