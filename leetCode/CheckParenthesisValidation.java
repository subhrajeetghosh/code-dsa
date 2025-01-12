package leetCode;

import java.util.Stack;

public class CheckParenthesisValidation {
    public boolean canBeValid(String s, String locked) { // time complexity - O(n)
        Stack<Integer> lockedStack = new Stack<Integer>();
        Stack<Integer> unlockedStack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && locked.charAt(i) == '1') {
                if (!lockedStack.isEmpty()) {
                    lockedStack.pop();
                } else if (!unlockedStack.isEmpty()) {
                    unlockedStack.pop();
                } else {
                    return false;
                }
            } else {
                if (locked.charAt(i) == '1') {
                    lockedStack.push(i);
                } else {
                    unlockedStack.push(i);
                }
            }
        }
        if (lockedStack.size() > unlockedStack.size())
            return false;
        while (!lockedStack.isEmpty()) {
            if (lockedStack.peek() > unlockedStack.peek()) {
                return false;
            } else {
                lockedStack.pop();
                unlockedStack.pop();
            }
        }
        return unlockedStack.size() % 2 == 0;
    }
}
