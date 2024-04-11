package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-k-digits
 * 
 * @author subhrajeetghosh
 */
public class RemoveKDigit {
    public String removeKdigits(String num, int k) { // time complexity - O(n+m) m - leading zero
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && st.peek() > (num.charAt(i) - '0') && k > 0) {
                st.pop();
                k--;
            }
            st.add((num.charAt(i) - '0'));
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        if (st.isEmpty())
            return "0";
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    // Better concise version
    public String removeKdigits_2ndMethod(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!st.isEmpty() && st.peek() > c && k > 0) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        // Remove remaining largest digits from the end
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Construct the result string
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
