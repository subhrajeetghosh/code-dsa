package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-score-from-removing-substrings
 * 
 * @author subhrajeetghosh
 */
public class MaxScoreRemoveStr {
    public int maximumGain(String s, int x, int y) { // time complexity - O(n)
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        char first = x > y ? 'a' : 'b';
        char second = x > y ? 'b' : 'a';
        int result = 0;
        for (char c : s.toCharArray()) {
            if (!st1.isEmpty() && st1.peek() == first && c == second) {
                result += max;
                st1.pop();
            } else {
                st1.push(c);
            }
        }

        while (!st1.isEmpty()) {
            if (!st2.isEmpty() && st2.peek() == first && st1.peek() == second) {
                result += min;
                st1.pop();
                st2.pop();
            } else {
                st2.push(st1.pop());
            }
        }
        return result;
    }
}
