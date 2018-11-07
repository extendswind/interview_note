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


// * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null)
            return new ListNode(0);

        int sum = l1.val + l2.val;
        int addToNext = sum / 10 ;
        l1 = l1.next;
        l2 = l2.next;
        ListNode first = new ListNode(sum%10);
        ListNode current = first;

        while((l1!=null || l2!=null) || addToNext != 0){
            sum = 0;
            sum += addToNext;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            addToNext = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
        }
        return first;
    }
}


public class _1TwoSum{
    public static void main(String[] args) {

    }
}


/*

遍历两个List而已，不过涉及初始结果的保存

有两个特殊情况显得不太优雅：

- 第一次循环的访问需要保留first指针，因此只能放在外部或者在循环内标记
- 最后可能会有进位，需要在wihle循环的条件中添加addToNext或者放在循环后

 */
