package basic;

import java.util.Stack;

/**
 *
 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 示例1
 输入
 复制

 [9,3,7],[6,3]

 输出
 复制

 {1,0,0,0}

 备注:

 1≤n,m≤10^6
 0≤a_i,b_i≤9

 */

/**
 * 下面有两种思路
 * 1. 使用stack将链表中的元素插入stack按pop顺序相加，
 * 2. 首先翻转链表，从头结点开始相加后得到结果，对结果再次翻转。
 */

class ListNode {
  int val;
  ListNode next = null;
  public ListNode(int val){
    this.val = val;
  }
}


public class ListAdd {

  public static void main(String[] argv){
    ListNode l1 = new ListNode(9);
    l1.next = new ListNode(3);
    l1.next.next = new ListNode(7);
    ListNode l2 = new ListNode(6);
    l2.next = new ListNode(3);
    ListAdd ListAdd = new ListAdd();

    ListAdd.printList(ListAdd.addInListByStack(l1, l2));
  }

  public ListNode addInListByStack(ListNode head1, ListNode head2) {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    ListNode l1 = head1;
    while(l1 != null){
      stack1.push(l1.val);
      l1 = l1.next;
    }
    ListNode l2 = head2;
    while(l2 != null){
      stack2.push(l2.val);
      l2 = l2.next;
    }

    Stack<Integer> addResult = new Stack<>();
    int addOver = 0;
    while(!stack1.isEmpty() || !stack2.isEmpty() || addOver != 0){
      int sum = addOver;
      if(!stack1.isEmpty()){
        sum += stack1.pop();
      }
      if(!stack2.isEmpty()){
        sum += stack2.pop();
      }
      if(sum >= 10){
        addOver = 1;
        sum = sum % 10;
      } else {
        addOver = 0;
      }
      addResult.push(sum);
    }

    ListNode result = new ListNode(0);
    ListNode resultHead = result;
    while(!addResult.isEmpty()){
      result.next = new ListNode(addResult.pop());
      result = result.next;
    }

    return resultHead.next;
  }

  /**
   * 通过链表翻转的形式实现链表相加
   */
  public ListNode addInList (ListNode head1, ListNode head2) {
    // write code here
    ListNode newList1 = reverseList(head1);
    ListNode newList2 = reverseList(head2);
    ListNode result = new ListNode(0);
    ListNode resultHead = result;
    int addNext = 0;
    while(newList1 != null || newList2 != null || addNext != 0){
      int add1 = 0;
      if(newList1 != null){
        add1 = newList1.val;
      }
      int add2 = 0;
      if(newList2 != null){
        add2 = newList2.val;
      }
      int sum = add1 + add2 + addNext;
      if(sum >= 10){
        addNext = sum / 10;
        sum = sum % 10;
      } else {
        addNext = 0;
      }
      if(newList1 != null)
        newList1 = newList1.next;
      if(newList2 != null)
        newList2 = newList2.next;
      result.next = new ListNode(sum);
      result = result.next;
      //result.val = sum;
    }
    return reverseList(resultHead.next);
  }

  /**
   * 辅助函数 用于翻转链表
   * 返回翻转链表后的头结点
   */
  private ListNode reverseList(ListNode head){
    ListNode n1 = head;
    if(head == null || head.next == null){
      return head;
    }
    ListNode n2 = n1.next;
    ListNode n3;
    while(n2 != null){
      n3 = n2.next;
      n2.next = n1;
      n1 = n2;
      n2 = n3;
    }
    head.next = null;
    return n1;
  }

  /**
   * 打印链表中的所有元素
   * @param list
   */
  public void printList(ListNode list){
    while(list != null){
      System.out.println(list.val + " ");
      list = list.next;
    }
  }



}

