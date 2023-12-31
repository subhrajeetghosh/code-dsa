package leetCode;

/**
 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful
 * 
 * @author subhrajeetghosh
 */

public class MinRopeColour {
    public int minCost(String colors, int[] neededTime) { // time complexity - O(n)
        int ans = 0;
        char[] charArray = colors.toCharArray();
        for (int i = 0; i < neededTime.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                ans += Math.min(neededTime[i], neededTime[i + 1]);
                neededTime[i + 1] = Math.max(neededTime[i], neededTime[i + 1]);
            }
        }
        return ans;
    }
}
