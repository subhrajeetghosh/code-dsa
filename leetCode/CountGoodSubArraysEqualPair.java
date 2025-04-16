package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-the-number-of-good-subarrays
 * 
 * @author subhrajeetghosh
 */
public class CountGoodSubArraysEqualPair {
    public long countGood_2ndMethod(int[] nums, int k) { // time complexity - O(n^3)
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < nums.length; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                int pair = 0;
                for (int key : map.keySet()) {
                    int samePairCount = map.get(key);
                    if (samePairCount > 1) {
                        pair += (samePairCount * (samePairCount - 1)) / 2;
                    }
                    if (pair >= k) {
                        result++;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public long countGood_3rdMethod(int[] nums, int k) { // time complexity - O(n^2)
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            long pair = 0;
            for (int j = i; j < nums.length; j++) {
                int oldCount = map.getOrDefault(nums[j], 0);
                pair -= (oldCount * (oldCount - 1)) / 2;
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                int newCount = map.get(nums[j]);
                pair += (newCount * (newCount - 1)) / 2;
                if (pair >= k) {
                    result++;
                }
            }
        }
        return result;
    }

    public long countGood(int[] nums, int k) { // time complexity - O(n)
        int left = 0;
        long result = 0, pair = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            long oldPair = map.getOrDefault(nums[right], 0l);
            map.put(nums[right], map.getOrDefault(nums[right], 0l) + 1l);
            pair += oldPair;
            while (left < right && pair >= k) {
                result += nums.length - right;
                map.put(nums[left], map.getOrDefault(nums[left], 0l) - 1l);
                pair -= map.get(nums[left]);
                left++;
            }
        }
        return result;
    }
}
