package leetCode;

/**
 * https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray
 * 
 * @author subhrajeetghosh
 */
public class LongestStrctMonotonicSubArr {
    public int longestMonotonicSubarray(int[] nums) { // time complexity - O(n)
        int inc = 1, dec = 1, maxInc = 1, maxDec = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            inc = nums[i] < nums[i + 1] ? inc + 1 : 1;
            dec = nums[i] > nums[i + 1] ? dec + 1 : 1;
            maxInc = Math.max(maxInc, inc);
            maxDec = Math.max(maxDec, dec);
        }
        return Math.max(maxInc, maxDec);
    }
}
