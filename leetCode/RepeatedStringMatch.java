package leetCode;

/**
 * https://leetcode.com/problems/repeated-string-match
 * 
 * @author subhrajeetghosh
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) { // time complexity - O(m + n)
        int result = 1;
        StringBuilder sb = new StringBuilder(a);
        while (sb.length() < b.length()) {
            result++;
            sb.append(a);
        }
        if (sb.indexOf(b) >= 0)
            return result;
        sb.append(a);
        if (sb.indexOf(b) >= 0)
            return result + 1;
        return -1;
    }
}
