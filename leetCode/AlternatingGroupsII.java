package leetCode;

/**
 * https://leetcode.com/problems/alternating-groups-ii/
 * 
 * @author subhrajeetghosh
 */
public class AlternatingGroupsII {
    // Brute force approach
    public int numberOfAlternatingGroups_2ndMethod(int[] colors, int k) { // time complexity - O(n*k)
        int result = 0;
        for (int i = 0; i < colors.length; i++) {
            int tmpK = k - 1, j = i + 1, currentCl = colors[i];
            boolean alternateFlag = true;
            while (tmpK-- > 0) {
                if (colors[j % colors.length] == currentCl) {
                    alternateFlag = false;
                    break;
                } else {
                    currentCl = colors[j % colors.length];
                    j++;
                }
            }
            if (alternateFlag)
                result++;
        }
        return result;
    }

    // Optimized approach
    public int numberOfAlternatingGroups(int[] colors, int k) { // time complexity - O(n)
        int result = 0;
        int left = 0, right = 1, cntColor = colors[0], tmpK = 1;
        while (left < colors.length) {
            if (tmpK < k) {
                if (colors[right % colors.length] == cntColor) {
                    left = right;
                    right++;
                    tmpK = 1;
                } else {
                    cntColor = colors[right % colors.length];
                    right++;
                    tmpK++;
                }
            } else {
                result++;
                if (colors[right % colors.length] == cntColor) {
                    left = right;
                    right++;
                    tmpK = 1;
                } else {
                    cntColor = colors[right % colors.length];
                    right++;
                    left++;
                }
            }
        }
        return result;
    }
}
