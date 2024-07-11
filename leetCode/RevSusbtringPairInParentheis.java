package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 
 * @author subhrajeetghosh
 */

public class RevSusbtringPairInParentheis {
    public String reverseParentheses(String s) { // time complexity - O(n)
        Stack<StringBuilder> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.add(new StringBuilder());
            } else if (s.charAt(i) == ')') {
                st.peek().reverse();
                if (st.size() > 1) {
                    StringBuilder sb = st.pop();
                    st.peek().append(sb);
                }
            } else {
                if (st.isEmpty()) {
                    st.add(new StringBuilder());
                }
                st.peek().append(s.charAt(i));
            }
        }
        return st.peek().toString();
    }
}
