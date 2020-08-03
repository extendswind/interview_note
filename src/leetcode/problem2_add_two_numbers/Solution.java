package leetcode.problem2_add_two_numbers;
import java.lang.Math;



public class Solution {

  /**
   * Definition for singly-linked list.
   * */
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

    ListNode cur = new ListNode(0);
    ListNode first = cur;
    int value;
    int carry = 0;  //进位

    // 一种逻辑上更具备可读性的写法
    while(true){
      value = carry;
      if(l1 != null){
        value += l1.val;
        l1 = l1.next;
      }
      if(l2 != null){
        value += l2.val;
        l2 = l2.next;
      }
      carry = value / 10;
      value = value % 10;
      cur.val = value;

      if((l1 != null) || (l2 != null) || (carry != 0)){
        cur.next = new ListNode(0);
        cur = cur.next;
      } else {
        break;
      }
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
    Solution slt = new Solution();
    ListNode list1 = new ListNode(2);
    list1.next = new ListNode(4);
    list1.next.next = new ListNode(3);
    ListNode list2 = new ListNode(5);
    list2.next = new ListNode(6);
    list2.next.next = new ListNode(4);
    
    int result1 = slt.list2num(slt.addTwoNumbers1(list1, list2));
    System.out.println("test1: 807  " + result1);

    list1 = new ListNode(5);
    list2 = new ListNode(5);
    int result2 = slt.list2num(slt.addTwoNumbers1(list1, list2));
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