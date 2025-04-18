package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
 * 
 * @author subhrajeetghosh
 */
public class CountEqualDivisiblePairInArray {
    public int countPairs(int[] nums, int k) { // time complexity - O(n^2)
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public int countPairs_2ndMethod(int[] nums, int k) { // time complexity - O(n^2)
        int result = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], _ -> new ArrayList<>()).add(i);
        }
        for (List<Integer> indexes : map.values()) {
            for (int i = 0; i < indexes.size(); i++) {
                for (int j = i + 1; j < indexes.size(); j++) {
                    if (indexes.get(i) * indexes.get(j) % k == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public int countPairs_2ndMwthod(int[] nums, int k) { // time complexity - O(n^2) but better in most case
        int result = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }
        for (List<Integer> indexes : map.values()) {
            for (int i = 0; i < indexes.size(); i++) {
                for (int j = i + 1; j < indexes.size(); j++) {
                    if (indexes.get(i) * indexes.get(j) % k == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
