package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/divide-array-into-arrays-with-max-difference
 * 
 * @author subhrajeetghosh
 */
public class DivideArrayToArrays {
    public int[][] divideArray(int[] nums, int k) { // time complexity - O(n log n)
        Arrays.sort(nums);
        int index = 0;
        int[][] result = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i] + k < nums[i + 2])
                return new int[0][0];
            result[index][0] = nums[i];
            result[index][1] = nums[i + 1];
            result[index++][2] = nums[i + 2];
        }
        return result;
    }
}
