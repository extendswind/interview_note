package codingInterviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class _6PrintListFromTailToHead {

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>(stack.size());
        while(!stack.empty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    public static void main(String[] argvs){
        _6PrintListFromTailToHead s = new _6PrintListFromTailToHead();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ArrayList<Integer> arrayList = s.printListFromTailToHead(head);
        for(int e : arrayList){
            System.out.println(e);
        }
    }

}
