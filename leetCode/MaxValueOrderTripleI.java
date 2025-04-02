package leetCode;

/**
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i
 * 
 * @author subhrajeetghosh
 */
public class MaxValueOrderTripleI {
    public long maximumTripletValue(int[] nums) { // time complexity - O(n^3)
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    result = Math.max(result, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return result;
    }

    // optimized
    public long maximumTripletValue_2ndMethod(int[] nums) { // time complexity - O(n^2)
        long result = 0;
        int maxI = nums[0];
        for (int j = 1; j < nums.length; j++) {
            maxI = Math.max(maxI, nums[j - 1]);
            for (int k = j + 1; k < nums.length; k++) {
                result = Math.max(result, (long) (maxI - nums[j]) * nums[k]);
            }
        }
        return result;
    }

    // more optimized
    public long maximumTripletValue_3rdMethod(int[] nums) { // time complexity - O(n)
        long result = 0;
        int maxI = nums[0], largestDiff = nums[0] - nums[1];
        for (int k = 2; k < nums.length; k++) {
            maxI = Math.max(maxI, nums[k - 2]);
            largestDiff = Math.max(largestDiff, maxI - nums[k - 1]);
            result = Math.max(result, (long) largestDiff * nums[k]);
        }
        return result;
    }
}
