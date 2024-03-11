package leetCode;

/**
 * https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 * 
 * @author subhajeetghosh
 */
public class MinLenRemovalString {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                while (i < j && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
                while (i < j && s.charAt(j) == s.charAt(j - 1)) {
                    j--;
                }
                i++;
                j--;

            } else {
                return (j - i) + 1;
            }
        }
        return i <= j ? 1 : 0;
    }
}
