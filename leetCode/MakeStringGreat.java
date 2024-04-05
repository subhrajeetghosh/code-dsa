package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/make-the-string-great
 * 
 * @author subhrajeetghosh
 */
public class MakeStringGreat {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<Character>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!st.isEmpty() && Math.abs(s.charAt(i) - st.peek()) == 32) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
