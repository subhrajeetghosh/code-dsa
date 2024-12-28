package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/target-sum
 * 
 * @author subhrajeetghosh
 */
public class TargetSum {
    int result = 0;

    // Recursion
    public int findTargetSumWays_2ndMethod(int[] nums, int target) { // time complexity - O(2^n), n -> length of nums
        findWaysForTarget(nums, target, -1, 0);
        return result;
    }

    private void findWaysForTarget(int[] nums, int target, int index, int sum) {
        index++;
        if (index >= nums.length) {
            if (sum == target) {
                result++;
            }
            return;
        }
        findWaysForTarget(nums, target, index, sum + nums[index]);
        findWaysForTarget(nums, target, index, sum - nums[index]);
    }

    //Memorization
    Map<String, Integer> map;

    public int findTargetSumWays(int[] nums, int target) { // time complexity - O(n)
        map = new HashMap<String, Integer>();
        return findWays(nums, -1, target, 0);
    }

    private int findWays(int[] nums, int index, int target, int sum) {
        String key = index + "-" + sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        index++;
        if (nums.length == index) {
            return target == sum ? 1 : 0;
        }
        int add = findWays(nums, index, target, sum + nums[index]);
        int substract = findWays(nums, index, target, sum - nums[index]);

        map.put(key, add + substract);
        return map.get(key);
    }
}
