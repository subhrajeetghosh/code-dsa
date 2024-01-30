package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks
 * 
 * @author subhrajeetghosh
 */
public class ImplQueueUsingStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public ImplQueueUsingStack() {  //time complexity - O(n)
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty())
            copyStack();
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty())
            copyStack();
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

    private void copyStack() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
