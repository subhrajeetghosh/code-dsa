package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber-iv
 * 
 * @author subhrajeetghosh
 */
public class HouseRobberIV {
    Map<String, Integer> map;

    // Memoization
    public int minCapability(int[] nums, int k) { // time complexity - O(n*k)
        map = new HashMap<>();
        return findMinCap(nums, k, 0);
    }

    private int findMinCap(int[] nums, int k, int index) {
        if (k == 0)
            return 0;
        if (index >= nums.length)
            return Integer.MAX_VALUE;
        String key = k + "-" + index;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int minOfMax = Math.max(nums[index], findMinCap(nums, k - 1, index + 2));
        int skip = findMinCap(nums, k, index + 1);
        map.put(key, Math.min(minOfMax, skip));
        return map.get(key);
    }

    //Binery Search
    public int minCapability_2ndMethod(int[] nums, int k) { // time complexity - O(n log m)
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int i = 0, count = 0;
            while (i < nums.length) {
                if (nums[i] <= mid) {
                    count++;
                    i += 2;
                } else {
                    i++;
                }
            }
            if (k <= count)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
