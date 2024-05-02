package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative
 * 
 * @author subhrajeetghosh
 */
public class LargePostitveNegetive {
    public int findMaxK(int[] nums) { // time complexity - O(n)
        Set<Integer> set = new HashSet<>();
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            int k = nums[i] * -1;
            if (set.contains(k)) {
                result = Math.max(result, Math.abs(k));
            }
        }
        return result;
    }

    // not optimal approch
    public int findMaxK_2nd(int[] nums) { // time complexity - O(n log n)
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int i = nums.length - 1;
        while (i > 0 && nums[i] > 0) {
            if (set.contains(nums[i] * -1)) {
                return nums[i];
            }
            i--;
        }
        return -1;
    }
}
