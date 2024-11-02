package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-square-streak-in-an-array
 * 
 * @author subhrajeetghosh
 */
public class LongestSqrStreakArr {
    public int longestSquareStreak(int[] nums) { // time complexity - O(n)
        Set<Long> set = new HashSet<Long>();
        for (int num : nums) {
            set.add((long) num);
        }
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            long currentNum = (long) nums[i] * (long) nums[i];
            int currentLength = 1;
            while (set.contains(currentNum)) {
                currentNum *= currentNum;
                currentLength++;
                result = Math.max(result, currentLength);
            }
        }
        return result;
    }
}
