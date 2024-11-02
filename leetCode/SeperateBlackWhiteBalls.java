package leetCode;

/**
 * https://leetcode.com/problems/separate-black-and-white-balls
 * 
 * @author subhrajeetghosh
 */
public class SeperateBlackWhiteBalls {
    public long minimumSteps(String s) { // time complexity - O(n)
        long swap = 0;
        int blackCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                swap += blackCount;
            } else {
                blackCount++;
            }
        }
        return swap;
    }
}
