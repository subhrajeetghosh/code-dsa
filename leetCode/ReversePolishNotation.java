package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation
 * 
 * @author subhrajeetghosh
 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) { // time complexity - O(n)
        Stack<Integer> tokenStore = new Stack<Integer>();
        for (String s : tokens) {
            if (isOperator(s)) {
                int secondNumber = tokenStore.pop();
                int firstNumber = tokenStore.pop();
                tokenStore.push(operation(s, firstNumber, secondNumber));
            } else {
                tokenStore.push(Integer.parseInt(s));
            }
        }
        return tokenStore.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }

    private int operation(String s, int a, int b) {
        if (s.equals("+")) {
            return a + b;
        } else if (s.equals("-")) {
            return a - b;
        } else if (s.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
