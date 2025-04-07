package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum
 * 
 * @author subhrajeetghosh
 */
public class PartitionEqualSubSetArrSum {
    int totalSum = 0;
    Map<String, Boolean> memo;

    public boolean canPartition(int[] nums) { // time complexity - O(n* targetSum)
        memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        if (totalSum % 2 != 0)
            return false;
        totalSum /= 2;
        return backtrack(nums, 0, totalSum);
    }

    private boolean backtrack(int[] nums, int index, int currentSum) {
        String key = index + "-" + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (currentSum == 0)
            return true;
        if (currentSum < 0 || index >= nums.length)
            return false;
        boolean result = backtrack(nums, index + 1, currentSum - nums[index]) || backtrack(nums, index + 1, currentSum);
        memo.put(key, result);
        return result;
    }
}
