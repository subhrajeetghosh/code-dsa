package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses
 * 
 * @author subhrajeetghosh
 */
public class GenerateParenthesis {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis_2ndMethod(int n) { // time complexity - O(2n * 2^2*n)
        dfs_2ndMethod(n, new StringBuilder());
        return res;
    }

    private void dfs_2ndMethod(int n, StringBuilder sb) {
        if (n * 2 == sb.length()) {
            if (isValid(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }
        sb.append("(");
        dfs_2ndMethod(n, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        dfs_2ndMethod(n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    // Optimized Approch
    public List<String> generateParenthesis(int n) { // time complexity - O(Cn) - C -> catalin number
        dfs(n, new StringBuilder(), 0, 0);
        return res;
    }

    private void dfs(int n, StringBuilder sb, int open, int close) {
        if (n * 2 == sb.length()) {
            if (isValid(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }
        if (open < n) {
            sb.append("(");
            dfs(n, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open > close) {
            sb.append(")");
            dfs(n, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
