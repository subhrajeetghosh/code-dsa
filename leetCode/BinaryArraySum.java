package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum
 * 
 * @author subhrajeetghosh
 */
public class BinaryArraySum {
    public int numSubarraysWithSum(int[] nums, int goal) { // time complexity - O(n)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int prefixSum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - goal)) {
                result += map.get(prefixSum - goal);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}
