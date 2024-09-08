package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-array-by-increasing-frequency
 * 
 * @author subhrajeetghosh
 */
public class SortArrIncreFreq {
    public int[] frequencySort(int[] nums) { // time complexity - O(n^2)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length;) {
            int currentMin = Integer.MAX_VALUE;
            int currentVal = -1;
            for (int num : map.keySet()) {
                if (map.get(num) < currentMin) {
                    currentMin = map.get(num);
                    currentVal = num;
                } else if (map.get(num) == currentMin) {
                    currentVal = Math.max(num, currentVal);
                }
            }
            for (int j = 0; j < currentMin; j++) {
                result[i++] = currentVal;
            }
            map.remove(currentVal);
        }
        return result;
    }
}
