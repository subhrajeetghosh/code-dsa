package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
 * 
 * @author subhrajeetghosh
 */
public class MinRemoveValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int openCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else if (s.charAt(i) == ')') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    continue;
                }
            }
            sb.append(s.charAt(i));
        }
        StringBuilder newSb = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && openCount > 0) {
                openCount--;
            } else {
                newSb.append(sb.charAt(i));
            }
        }
        return newSb.reverse().toString();
    }
}
