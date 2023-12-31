package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array
 * 
 * @author subhrajeetghosh
 */
public class LargestTwoMultiple {
    public int maxProduct(int[] nums) { // time complexity - O(n)
        int biggest = 0;
        int secondBiggest = 0;
        for (int num : nums) {
            if (num > biggest) {
                secondBiggest = biggest;
                biggest = num;
            } else {
                secondBiggest = Math.max(secondBiggest, num);
            }
        }
        return (biggest - 1) * (secondBiggest - 1);
    }

    public int maxProduct_2ndMethod(int[] nums) { // time complexity - O(n log n)
        Arrays.sort(nums);
        return (nums[nums.length - 2] - 1) * (nums[nums.length - 1] - 1);
    }
}
