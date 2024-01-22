package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/set-mismatch
 * 
 * @author subhrajeetghosh
 */
public class SetMismatch {
    // Bruteforce approch
    public int[] findErrorNums(int[] nums) { // time complexity - O(n log n)
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Integer missingNumber = null;
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                missingNumber = i;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (i + 1 == nums[i]) {
                    return new int[] { i + 1, missingNumber };
                } else if (i == nums[i]) {
                    return new int[] { i, missingNumber };
                }
            }
        }
        return new int[0];
    }

    // optimized approch
    public int[] findErrorNums_2ndMethod(int[] nums) { // time complexity - O(n)
        int len = nums.length;
        long sum = (len * (len + 1)) / 2;
        int[] result = new int[2];
        boolean[] seen = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            sum -= nums[i];
            if (seen[nums[i]])
                result[0] = nums[i];
            seen[nums[i]] = true;
        }
        result[1] = result[0] + (int) sum;
        return result;
    }
}
