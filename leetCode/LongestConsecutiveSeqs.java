package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * @author subhrajeetghosh
 */
public class LongestConsecutiveSeqs {

    public int longestConsecutive(int[] nums) { // time complexity - O(n log n)
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int currentStack = 1, result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                currentStack++;
            } else {
                result = Math.max(currentStack, result);
                currentStack = 1;
            }
        }
        return Math.max(result, currentStack);
    }

    public int longestConsecutive_2ndMethod(int[] nums) { // time complexity - O(n)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int streak = 0;
                while (set.contains(num)) {
                    num++;
                    streak++;
                }
                result = Math.max(result, streak);
            }
        }
        return result;
    }

    public int longestConsecutive_3rdMethod(int[] nums) { // time complexity o(n)
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, map.getOrDefault(num - 1, 0) + map.getOrDefault(num + 1, 0) + 1);
                map.put(num - map.getOrDefault(num - 1, 0), map.get(num));
                map.put(num + map.getOrDefault(num + 1, 0), map.get(num));
                result = Math.max(result, map.get(num));
            }
        }
        return result;
    }
}