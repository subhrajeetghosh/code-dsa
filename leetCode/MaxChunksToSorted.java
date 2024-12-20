package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted
 * 
 * @author subhrajeetghosh
 */
public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) { //time complexity - O(n)
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<arr.length; i++) {
            if(stack.isEmpty() || stack.peek() < arr[i]) {
                stack.push(arr[i]);
            } else {
                int currentMax = stack.peek();
                while(!stack.isEmpty() && stack.peek() > arr[i]) {
                    stack.pop();
                }
                stack.push(currentMax);
            }
        }
        return stack.size();
    }
}
