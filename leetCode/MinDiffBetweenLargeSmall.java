package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves
 * 
 * @author subhrajeeghosh
 */
public class MinDiffBetweenLargeSmall {
    public int minDifference(int[] nums) { // time complexity - O(n log n)
        if (nums.length <= 4)
            return 0;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, Math.abs(nums[i] - nums[nums.length - 1 - (3 - i)]));
        }
        return res;
    }
}
