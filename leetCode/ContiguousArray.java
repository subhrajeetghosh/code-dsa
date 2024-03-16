package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array
 * 
 * @author subhrajeetghosh
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) { // time complexity - O(n)
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return result;
    }
}
