package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring
 * 
 * @author subhrajeetghosh
 */
public class RemoveOccurranceSubString {
    public String removeOccurrences(String s, String part) { // time complexity - O(n^2)
        StringBuilder sb = new StringBuilder(s);
        int indexOf = sb.indexOf(part);
        while (indexOf != -1) {
            sb.delete(indexOf, indexOf + part.length());
            indexOf = sb.indexOf(part);
        }
        return sb.toString();
    }

    public String removeOccurrences_2ndMethod(String s, String part) { // time complexity - O(n*m)
        Stack<Character> st = new Stack<Character>();
        for (char c : s.toCharArray()) {
            st.push(c);
            if (st.size() >= part.length() && isMatch(st, part)) {
                for (int i = 0; i < part.length(); i++) {
                    st.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    private boolean isMatch(Stack<Character> st, String part) {
        for (int i = 0; i < part.length(); i++) {
            if (st.get(st.size() - part.length() + i) != part.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
