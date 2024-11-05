package leetCode;

/**
 * https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful
 * 
 * @author subhrajeetghosh
 */
public class MinChangeNumBinString {
    public int minChanges(String s) { // time complexity - O(n)
        int count = 0;
        for (int i = 0; i < s.length() - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
