package com.extendswind.leetcode1;

import java.util.HashMap;
import java.util.Map;


/**

 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.

 */

class Solution{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i= 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i= 0; i < nums.length; i++){
            int otherNum = target - nums[i];
            if(map.containsKey(otherNum) && map.get(otherNum) != i)
                return new int[]{i, map.get(otherNum)};
        }
        return null;
    }
}

public class _1TwoSum{
    public static void main(String[] args) {

    }
}


/*
 从数组中找到两个和为target的数，解决方案：
 1. brute force   O(n^2)
 2. 使用Map根据一个元素查找另一个元素，空间换时间  O(n)*HashMap get函数的开销，hashmap的get开销是常数？
 3. 当数组为sorted时，可以使用一个指针从前向后一个指针从后向前（排序时间n*log(n)，还要添加额外的数据存储位置信息）

 上面使用方案2
 */
