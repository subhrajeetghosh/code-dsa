package leetCode;

import java.util.HashSet;
import java.util.Set;

public class MaxSumDistictSubArray {
    // little fast approch
    public long maximumSubarraySum_2ndMethod(int[] nums, int k) { // time complexity - O(n)
        int left = 0, right = 0, result = 0, currentSum = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (; right < nums.length; right++) {
            if (set.contains(nums[right])) {
                currentSum -= nums[left];
                set.remove(nums[left++]);
            }

            set.add(nums[right]);
            currentSum += nums[right];

            if (right - left + 1 > k) {
                currentSum -= nums[left];
                set.remove(nums[left++]);
            }

            if (right - left + 1 == k) {
                result = Math.max(result, currentSum);
            }
        }
        return result;
    }

    // Different Approch
    public long maximumSubarraySum(int[] nums, int k) { // time complexity - O(n)
        int left = 0;
        long result = 0, currentSum = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                currentSum -= nums[left];
                set.remove(nums[left++]);
            }
            set.add(nums[right]);
            currentSum += nums[right];

            if (set.size() > k) {
                currentSum -= nums[left];
                set.remove(nums[left++]);
            }

            if (set.size() == k) {
                result = Math.max(result, currentSum);
            }
        }
        return result;
    }
}
