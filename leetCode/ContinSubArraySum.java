package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/continuous-subarray-sum
 * 
 * @author subhrajeetghosh
 */
public class ContinSubArraySum {
    // Bruteforce approch
    public boolean checkSubarraySum_2ndMethod(int[] nums, int k) { // time complexity - O(n)
        for (int i = 0; i < nums.length; i++) {
            long sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0)
                    return true;
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) { // time complexity - O(n)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = (int) (sum % k);
            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}
