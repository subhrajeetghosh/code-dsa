package leetCode;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-complete-subarrays-in-an-array
 * 
 * @author subhrajeetghosh
 */
public class CountDistinctSubArray {

    public int countCompleteSubarrays_2ndMethod(int[] nums) { // time complexity - O(n^2)
        Set<Integer> distinctSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            distinctSet.add(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                set.add(nums[j]);
                if (set.size() == distinctSet.size()) {
                    result++;
                }
            }
        }
        return result;
    }

    public int countCompleteSubarrays(int[] nums) { // time complexity - O(n)
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        Map<Integer, Integer> numsMap = new HashMap<>();
        int result = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            numsMap.put(nums[right], numsMap.getOrDefault(nums[right], 0) + 1);
            while (numsMap.size() == unique.size()) {
                result += nums.length - right;
                numsMap.put(nums[left], numsMap.get(nums[left]) - 1);
                if (numsMap.get(nums[left]) == 0) {
                    numsMap.remove(nums[left]);
                }
                left++;
            }
        }
        return result;
    }
}
