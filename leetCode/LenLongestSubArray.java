package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author subhrajeetghosh
 */
public class LenLongestSubArray {
    // Bruteforce approch
    public int maxSubarrayLength(int[] nums, int k) { // time complexity - O(n^2)
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            int currentLen = 0;
            for (int j = i; j < nums.length; j++) {
                countMap.put(nums[j], countMap.getOrDefault(nums[j], 0) + 1);
                if (countMap.get(nums[j]) <= k) {
                    currentLen++;
                    result = Math.max(currentLen, result);
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public int maxSubarrayLength_2ndMethod(int[] nums, int k) { // time complexity - O(n)
        int result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int currentLen = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            currentLen++;
            if (countMap.get(nums[i]) <= k) {
                result = Math.max(currentLen, result);
            } else {
                while (countMap.get(nums[i]) > k) {
                    currentLen--;
                    countMap.put(nums[j], countMap.get(nums[j]) - 1);
                    j++;
                }
            }
            result = Math.max(currentLen, result);
        }
        return result;
    }
}
