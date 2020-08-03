package codingInterviews;

import org.junit.Assert;

import java.util.Stack;

public class _9QueueImplementByTwoStack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public static void main(String[] argvs){
        _9QueueImplementByTwoStack s = new _9QueueImplementByTwoStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(4);
        s.push(6);
        Assert.assertEquals(s.pop(), 1);
        Assert.assertEquals(s.pop(), 2);
        Assert.assertEquals(s.pop(), 3);
        Assert.assertEquals(s.pop(), 4);
        Assert.assertEquals(s.pop(), 4);
        Assert.assertEquals(s.pop(), 6);
    }
}
