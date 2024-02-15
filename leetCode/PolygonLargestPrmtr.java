package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
 * 
 * @author subhtajeetghosh
 */
public class PolygonLargestPrmtr {
    public long largestPerimeter(int[] nums) { // time complexity - O(n log n)
        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < prefixSum[i - 1]) {
                return prefixSum[i];
            }
        }
        return -1;
    }
}
