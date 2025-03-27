package leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-index-of-a-valid-split
 * 
 * @author subhrajeetghosh
 */
public class MinIndexValidSplitDominanat {
    public int minimumIndex(List<Integer> nums) { // time copmlexity - O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }
        int dominant = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > nums.size() / 2) {
                dominant = key;
            }
        }
        if (dominant == 0)
            return -1;
        int leftCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }
            int rightCount = map.get(dominant) - leftCount;
            if ((i + 1) / 2 < leftCount && (nums.size() - (i + 1)) / 2 < rightCount) {
                return i;
            }
        }
        return -1;
    }
}
