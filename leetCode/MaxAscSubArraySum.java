package leetCode;

/**
 * https://leetcode.com/problems/maximum-ascending-subarray-sum
 * 
 * @author subhrajeetghosh
 */
public class MaxAscSubArraySum {
    public int maxAscendingSum(int[] nums) { // time complexity - O(n)
        int maxSum = 0, result = 0, currentNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentNum < nums[i]) {
                maxSum += nums[i];
                result = Math.max(maxSum, result);
            } else {
                maxSum = nums[i];
            }
            currentNum = nums[i];
        }
        return result;
    }
}
