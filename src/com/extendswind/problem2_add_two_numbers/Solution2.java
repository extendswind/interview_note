package com.extendswind.problem2_add_two_numbers;

/**
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 * 
 */

// * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode first = cur;
        ListNode tmpNode = cur;
        int value;
        int carry = 0; // 进位
        boolean isFisrst = true;

        // 正常while循环写法
        while ((l1 != null) || (l2 != null) || (carry != 0)) {
            if(isFisrst == true){
                isFisrst = false;
            }else{
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            if(tmpNode != null)
                tmpNode.next = cur;
            value = carry;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            carry = value / 10;
            value = value % 10;
            cur.val = value;
        }
        return first;
    }
    
  public static void main(String[] args){
    /*
      > 
      Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
      Output: 7 -> 0 -> 8
      Explanation: 342 + 465 = 807.
    */
    Solution2 slt = new Solution2();
    ListNode list1 = new ListNode(2);
    list1.next = new ListNode(4);
    list1.next.next = new ListNode(3);
    ListNode list2 = new ListNode(5);
    list2.next = new ListNode(6);
    list2.next.next = new ListNode(4);
    
    int result1 = slt.list2num(slt.addTwoNumbers(list1, list2));
    System.out.println("test1: 807  " + result1);

    list1 = new ListNode(5);
    list2 = new ListNode(5);
    int result2 = slt.list2num(slt.addTwoNumbers(list1, list2));
    System.out.println("test2: 10  " + result2);
  }

  public int list2num(ListNode list){
    int result = 0;
    int i = 0;
    while(list != null){
      result += list.val * Math.pow(10,i);
      i++;
      list = list.next;
    }
    return result;
  }
}

/*
 * 
 * 遍历两个List而已，不过涉及初始结果的保存
 * 
 * 有两个特殊情况显得不太优雅：
 * 
 * - 第一次循环的访问需要保留first指针，因此只能放在外部或者在循环内标记 -
 * 最后可能会有进位，需要在wihle循环的条件中添加addToNext或者放在循环后
 * 
 */
