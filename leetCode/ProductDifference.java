package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs
 * 
 * @author Subhrajeet Ghosh
 */

public class ProductDifference {
    public int maxProductDifference(int[] nums) { // time complexity - O(n log n)
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }

    public int maxProductDifference_2ndMethod(int[] nums) { // time complexity - O(n)
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min2) {
                min1 = min2;
                min2 = nums[i];
            } else if (nums[i] < min1) {
                min1 = nums[i];
            }
            if (nums[i] >= max2) {
                max1 = max2;
                max2 = nums[i];
            } else if (nums[i] > max1) {
                max1 = nums[i];
            }
        }
        return max1 * max2 - min1 * min2;
    }

}
