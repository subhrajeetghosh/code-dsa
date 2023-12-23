package leetCode;

/**
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string
 * 
 * @author Subhrajeet Ghosh
 */
public class SpittingString {
    // Brute force Approch
    public int maxScore(String s) { // time complexity - O(n*n)
        int ans = 0;
        char[] strArray = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            int currentAns = 0;
            for (int j = 0; j <= i; j++) {
                if (strArray[j] == '0') {
                    currentAns++;
                }
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (strArray[j] == '1') {
                    currentAns++;
                }
            }
            ans = Math.max(ans, currentAns);
        }
        return ans;
    }
}
