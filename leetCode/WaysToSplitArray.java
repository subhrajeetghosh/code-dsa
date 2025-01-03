package leetCode;

/**
 * https://leetcode.com/problems/number-of-ways-to-split-array
 * 
 * @author subhrajeetghosh
 */

class WaysToSplitArray {
    public int waysToSplitArray(int[] nums) { //time complexity - O(n)
        long[] prefixSum = new long[nums.length];
        long currentSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentSum += nums[i];
            prefixSum[i] = currentSum;
        }
        currentSum = 0l;
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currentSum += nums[i];
            if (currentSum >= prefixSum[i + 1]) {
                result++;
            }
        }
        return result;
    }
}