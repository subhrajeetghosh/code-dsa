package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-elements-with-maximum-frequency
 * 
 * @author subhrajeetghosh
 */
public class CountElementMaxFreq {
    public int maxFrequencyElements(int[] nums) { // time complexity - O(n)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int highestFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            highestFreq = Math.max(highestFreq, map.get(nums[i]));
        }
        int result = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == highestFreq) {
                result += highestFreq;
            }
        }
        return result;
    }
}
