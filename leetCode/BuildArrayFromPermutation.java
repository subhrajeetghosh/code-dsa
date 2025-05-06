package leetCode;

/**
 * https://leetcode.com/problems/build-array-from-permutation
 * @author subhrajeetghosh
 */
public class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) { // time complexity - O(n)
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    // in place
    public int[] buildArray_2ndMethod(int[] nums) { // time complexity - O(n)
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] /= 1000;
        }
        return nums;
    }
}
