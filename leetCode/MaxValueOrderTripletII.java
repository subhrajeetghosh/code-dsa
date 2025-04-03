package leetCode;

/**
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii
 * 
 * @author subhrajeetghosh
 */
public class MaxValueOrderTripletII {
    public long maximumTripletValue(int[] nums) { // time complexity - O(n)
        long result = 0;
        int maxI = nums[0], maxDiff = nums[0] - nums[1];
        for (int i = 1; i < nums.length - 1; i++) {
            maxI = Math.max(maxI, nums[i]);
            maxDiff = Math.max(maxDiff, maxI - nums[i]);
            result = Math.max(result, (long) maxDiff * nums[i + 1]);
        }
        return result;
    }
}
