package leetCode;

/**
 * https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray
 * 
 * @author subhrajeetghosh
 */
public class MaxAbsoluteSumSubArray {
    public int maxAbsoluteSum(int[] nums) { // time complexity - O(n)
        int currentMaxSum = nums[0], currentMinSum = nums[0];
        int maxSum = nums[0], minSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMaxSum = Math.max(currentMaxSum + nums[i], nums[i]);
            currentMinSum = Math.min(currentMinSum + nums[i], nums[i]);
            maxSum = Math.max(currentMaxSum, maxSum);
            minSum = Math.min(currentMinSum, minSum);
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }

    public int maxAbsoluteSum_2ndMethod(int[] nums) { // time complexity - O(n)
        int prefixSum = 0, minSum = 0, maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            minSum = Math.min(prefixSum, minSum);
            maxSum = Math.max(prefixSum, maxSum);
        }
        return maxSum - minSum;
    }
}
