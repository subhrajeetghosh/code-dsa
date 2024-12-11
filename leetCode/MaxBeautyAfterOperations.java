package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation
 * 
 * @author subhrajeetghosh
 */
public class MaxBeautyAfterOperations {
    public int maximumBeauty_2nd(int[] nums, int k) { // time complexity - O(n*m)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int left = Math.max(0, num - k);
            int right = num + k;
            for (; left <= right; left++) {
                map.put(left, map.getOrDefault(left, 0) + 1);
            }
        }
        int result = 0;
        for (int key : map.keySet()) {
            result = Math.max(result, map.get(key));
        }
        return result;
    }

    public int maximumBeauty(int[] nums, int k) { // time complexity - O(n log n)
        Arrays.sort(nums);
        int left = 0, maxResult = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            maxResult = Math.max(maxResult, right - left + 1);
        }

        return maxResult;
    }
}
