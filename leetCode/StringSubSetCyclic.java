package leetCode;

/**
 * https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments
 * 
 * @author subhrajeetghosh
 */
public class StringSubSetCyclic {
    public boolean canMakeSubsequence(String str1, String str2) { // time complexity - O(n)
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            char c1 = str1.charAt(i), c2 = str2.charAt(j);
            if (c1 == c2 || (c1 - 'a' + 1) % 26 == c2 - 'a') {
                j++;
            }
            i++;
        }
        return j == str2.length();
    }

}
