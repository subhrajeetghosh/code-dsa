package leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-of-interesting-subarrays
 * 
 * @author subhrajeetghosh
 */
public class CountInterestingSubArrays {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) { // time complexity - O(n^2)
        long result = 0l;
        for (int i = 0; i < nums.size(); i++) {
            long count = 0;
            for (int j = i; j < nums.size(); j++) {
                if (nums.get(j) % modulo == k) {
                    count++;
                }
                if (count % modulo == k) {
                    result++;
                }
            }

        }
        return result;
    }

    public long countInterestingSubarrays_2ndMethod(List<Integer> nums, int modulo, int k) { // time complexity - O(n)
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        long result = 0;
        int remainderPrefix = 0;
        for (int num : nums) {
            if (num % modulo == k) {
                remainderPrefix = (remainderPrefix + 1) % modulo;
            }

            int target = (remainderPrefix - k + modulo) % modulo;
            result += prefixCount.getOrDefault(target, 0);
            prefixCount.put(remainderPrefix, prefixCount.getOrDefault(remainderPrefix, 0) + 1);
        }
        return result;
    }
}
