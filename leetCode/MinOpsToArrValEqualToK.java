package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k
 * 
 * @author subhrajeetghosh
 */
public class MinOpsToArrValEqualToK {
    public int minOperations(int[] nums, int k) { // time complexity - O(nlogn)
        Arrays.sort(nums);
        if (nums.length == 0 || nums[0] < k)
            return -1;
        int index = nums.length - 2, currentNum = nums[nums.length - 1], result = 0;
        while (index >= 0) {
            if (nums[index] < currentNum) {
                result++;
                currentNum = nums[index];
            }
            index--;
        }
        if (nums[0] > k)
            result++;
        return result;
    }

    public int minOperations_2ndMethod(int[] nums, int k) { // time complexity - O(n)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            } else if (num > k) {
                set.add(num);
            }
        }
        return set.size();
    }
}
